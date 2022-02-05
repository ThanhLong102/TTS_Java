package Polymorphism_Abstraction.Service;

import Polymorphism_Abstraction.Entity.Subject;
import Polymorphism_Abstraction.Entity.Teacher;
import Polymorphism_Abstraction.Entity.teaching.SubjectTeaching;
import Polymorphism_Abstraction.Entity.teaching.Teaching;
import Polymorphism_Abstraction.Menu.Menu;
import Polymorphism_Abstraction.Util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeachingService {

    public static final String TEACHING_DATA_FILE = "src/Polymorphism_Abstraction/Util/File/teaching.dat";

    private static boolean isNullOfEmptyTeacherOrSubject() {
        return Menu.teachers.length == 0 || Menu.subjects.length == 0;
    }


    public void createTeaching() {
        if (isNullOfEmptyTeacherOrSubject()) {
            System.out.println("Bạn cần nhập thông tin giảng viên và môn học trước khi phân công giảng dạy.");
            return;
        }
        Teacher teacher = inputTeacherId();
        int totalLesson = getTotalLesson(teacher);
        if (totalLesson >= 200) {
            System.out.println("Giảng viên bạn chọn đã vượt quá số tiết cho phép dạy, vui lòng phân công cho giảng viên khác");
            return;
        }
        int subjectNumber = inputSubjectNumber();
        if (totalLesson == 0) {
            SubjectTeaching[] subjectTeachings = new SubjectTeaching[subjectNumber];
            createSubjectTeaching(subjectTeachings, subjectNumber, teacher);
            Teaching teaching = new Teaching(teacher, subjectTeachings);
            addTeachingToArray(teaching);
        } else {
            Teaching teaching = findTeaching(teacher.getId());
            SubjectTeaching[] subjectTeachings = new SubjectTeaching[subjectNumber + teaching.getSubjectTeachings().length];
            System.arraycopy(teaching.getSubjectTeachings(), 0, subjectTeachings, 0, teaching.getSubjectTeachings().length);
            updateOrAddSubjectTeaching(subjectTeachings, subjectNumber, teacher);
            Teaching tempTeaching = new Teaching(teacher, subjectTeachings);
            updateTeachingToArray(tempTeaching);
        }
        Menu.fileUtil.writeDataToFile(Menu.teachings, TEACHING_DATA_FILE);
    }

    private void updateTeachingToArray(Teaching teaching) {
        int indexTeachingExits = findIndexTeachingExits(teaching.getTeacher().getId());
        Menu.teachings[indexTeachingExits] = teaching;
    }

    private int findIndexTeachingExits(int id) {
        for (int i = 0; i < Menu.teachings.length; i++) {
            if (Menu.teachings[i].getTeacher().getId() == id)
                return i;
        }
        return -1;
    }

    private void updateOrAddSubjectTeaching(SubjectTeaching[] subjectTeachings, int subjectNumber, Teacher teacher) {
        for (int j = 0; j < subjectNumber; j++) {
            int currentTotalLesson = new Teaching(teacher, subjectTeachings).getCurrentTotalLesson();
            if (currentTotalLesson >= 200) {
                System.out.println("Giảng viên bạn chọn đã vượt quá số tiết cho phép dạy, vui lòng phân công cho giảng viên khác");
                return;
            }
            Subject subject = inputSubjectId(j, teacher);
            int indexSubjectTeachingExits = findSubjectTeaching(subject.getId(), subjectTeachings);
            if (indexSubjectTeachingExits < 0) {
                int classQuantity = inputClassQuantity(subject, teacher, currentTotalLesson);
                SubjectTeaching subjectTeaching = new SubjectTeaching(subject, classQuantity);
                addSubjectTeachingToArray(subjectTeaching, subjectTeachings);
            } else {
                currentTotalLesson = currentTotalLesson -
                        subjectTeachings[indexSubjectTeachingExits].getClassQuantity()
                                * subjectTeachings[indexSubjectTeachingExits].getSubject().getTotalLesson();
                int classQuantity = inputClassQuantity(subject, teacher, currentTotalLesson);
                SubjectTeaching subjectTeaching = new SubjectTeaching(subject, classQuantity);
                subjectTeachings[indexSubjectTeachingExits] = subjectTeaching;
            }
        }
    }

    private int findSubjectTeaching(int id, SubjectTeaching[] subjectTeachings) {
        for (int i = 0; i < subjectTeachings.length; i++) {
            if (DataUtil.isNullOrEmpty(subjectTeachings[i]))
                break;
            if (subjectTeachings[i].getSubject().getId() == id)
                return i;
        }
        return -1;
    }


    private void addTeachingToArray(Teaching teaching) {
        for (int k = 0; k < Menu.teachings.length; k++) {
            if (DataUtil.isNullOrEmpty(Menu.teachings[k])) {
                Menu.teachings[k] = teaching;
                break;
            }
        }
    }

    private void createSubjectTeaching(SubjectTeaching[] subjectTeachings, int subjectNumber, Teacher teacher) {
        for (int j = 0; j < subjectNumber; j++) {
            int currentTotalLesson = new Teaching(teacher, subjectTeachings).getCurrentTotalLesson();
            if (currentTotalLesson >= 200) {
                System.out.println("Giảng viên bạn chọn đã vượt quá số tiết cho phép dạy, vui lòng phân công cho giảng viên khác");
                return;
            }
            Subject subject = inputSubjectId(j, teacher);
            int classQuantity = inputClassQuantity(subject, teacher, currentTotalLesson);
            SubjectTeaching subjectTeaching = new SubjectTeaching(subject, classQuantity);
            addSubjectTeachingToArray(subjectTeaching, subjectTeachings);
        }
    }

    private int inputClassQuantity(Subject subject, Teacher teacher, int currentTotalLesson) {
        System.out.print("Nhập số lớp của môn " + subject.getName() + " mà giảng viên " + teacher.getFullName() + " muốn dạy: ");
        int classQuantity;
        do {
            try {
                classQuantity = new Scanner(System.in).nextInt();
                if (classQuantity > 0 && classQuantity <= 3) {
                    int totalLessonTmp = currentTotalLesson;
                    currentTotalLesson += subject.getTotalLesson() * classQuantity;
                    if (totalLessonTmp > 200) {
                        System.out.print("Nếu số lớp đăng ký dạy là " + classQuantity + " với môn học này thì tổng số tiết giảng dạy của giảng viên sẽ vượt quá 200, " + "vui lòng thu nhỏ số lớp giảng dạy cho môn học này: ");
                        continue;
                    }
                    break;
                }
                System.out.print("Số lớp giảng dạy cho 1 môn học là số nguyên dương và không được lớn hơn 3, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lớp muốn dạy phải là một số nguyên dương, không phải là chữ, vui lòng nhập lại: ");
            }
        } while (true);
        return classQuantity;
    }

    private Subject inputSubjectId(int j, Teacher teacher) {
        System.out.print("Nhập ID môn học thứ " + (j + 1) + "  mà giảng viên " + teacher.getFullName() + "muốn dạy: ");
        Subject subject;
        do {
            try {
                int subjectId = new Scanner(System.in).nextInt();
                subject = Menu.subjectService.findSubjectById(subjectId);
                if (!DataUtil.isNullOrEmpty(subject)) {
                    break;
                }
                System.out.print("ID môn học vừa nhập không tồn tại trong hệ thống, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("ID môn học phải là số nguyên dương, không phải là chữ, vui lòng nhập lại: ");
            }
        } while (true);
        return subject;
    }

    private void addSubjectTeachingToArray(SubjectTeaching subjectTeaching, SubjectTeaching[] subjectTeachings) {
        for (int k = 0; k < subjectTeachings.length; k++) {
            if (DataUtil.isNullOrEmpty(subjectTeachings[k])) {
                subjectTeachings[k] = subjectTeaching;
                break;
            }
        }
    }

    private int inputSubjectNumber() {
        System.out.print("Nhập số lượng môn học mà giảng viên này muốn dạy: ");
        int subjectNumber;
        do {
            try {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber > 0) {
                    break;
                }
                System.out.print("Số lớp phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lớp là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        return subjectNumber;
    }

    private Teacher inputTeacherId() {
        System.out.print("Nhập ID của giảng viên mà bạn muốn phân công: ");
        Teacher teacher;
        do {
            try {
                int teacherId = new Scanner(System.in).nextInt();
                teacher = Menu.teacherService.findTeacherById(teacherId);
                if (!DataUtil.isNullOrEmpty(teacher)) {
                    break;
                }
                System.out.print("ID giảng viên vừa nhập không tồn tại trong hệ thống, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("ID giảng viên phải là một số nguyên dương, không phải là chữ, vui lòng nhập lại: ");
            }
        } while (true);
        return teacher;
    }


    private int getTotalLesson(Teacher teacher) {
        if (DataUtil.isNullOrEmpty(teacher)) {
            return 0;
        }
        Teaching teaching = findTeaching(teacher.getId());
        if (DataUtil.isNullOrEmpty(teaching)) {
            return 0;
        }
        return teaching.getCurrentTotalLesson();
    }


    private Teaching findTeaching(int teacherId) {
        for (int i = 0; i < Menu.teachings.length; i++) {
            if(DataUtil.isNullOrEmpty(Menu.teachings[i]))
                return null;
            if (Menu.teachings[i].getTeacher().getId() == teacherId) {
                return Menu.teachings[i];
            }
        }
        return null;
    }


    public void showTeachings() {
        for (int i = 0; i < Menu.teachings.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.teachings[i])) {
                break;
            }
            System.out.println(Menu.teachings[i]);
        }
    }

    public void sortByNameTeacher() {
        for (int i = 0; i < Menu.teachings.length - 1; i++) {
            if (DataUtil.isNullOrEmpty(Menu.teachings[i]))
                break;
            for (int j = i + 1; j < Menu.teachings.length; j++) {
                if (DataUtil.isNullOrEmpty(Menu.teachings[j]))
                    break;
                int compare = compareNameTeacher(Menu.teachings[i], Menu.teachings[j]);
                if (compare > 0) {
                    swap(i, j);
                }
            }
        }
    }

    public void sortByTotalLessonEachSubject() {
        for (int i = 0; i < Menu.teachings.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.teachings[i]))
                break;
            for (int j = 0; j < Menu.teachings[i].getSubjectTeachings().length - 1; j++) {
                if (DataUtil.isNullOrEmpty(Menu.teachings[i].getSubjectTeachings()[j]))
                    break;
                for (int k = 0; k < Menu.teachings[i].getSubjectTeachings().length; k++) {
                    if (DataUtil.isNullOrEmpty(Menu.teachings[i].getSubjectTeachings()[k]))
                        break;
                    int compare = compareTotalLesson(Menu.teachings[i].getSubjectTeachings()[j]
                            , Menu.teachings[i].getSubjectTeachings()[k]);
                    if (compare > 0) {
                        swapTeaching(i, j, k);
                    }
                }
            }
        }
    }

    private int compareTotalLesson(SubjectTeaching o1, SubjectTeaching o2) {
        return o2.getSubject().getTotalLesson() - o1.getSubject().getTotalLesson();
    }

    private void swapTeaching(int i, int j, int k) {
        SubjectTeaching temp = Menu.teachings[i].getSubjectTeachings()[j];
        Menu.teachings[i].getSubjectTeachings()[j] = Menu.teachings[i].getSubjectTeachings()[k];
        Menu.teachings[i].getSubjectTeachings()[k] = temp;
    }

    public int compareNameTeacher(Teaching o1, Teaching o2) {
        String[] ten1 = o1.getTeacher().getFullName().split("\\s+");
        String[] ten2 = o2.getTeacher().getFullName().split("\\s+");
        if (ten1[ten1.length - 1].equalsIgnoreCase(ten2[ten2.length - 1])) {
            return o1.getTeacher().getFullName().compareToIgnoreCase(o2.getTeacher().getFullName());
        } else {
            return ten1[ten1.length - 1].compareToIgnoreCase(ten2[ten2.length - 1]);
        }
    }

    private void swap(int i, int j) {
        Teaching tempTeaching = Menu.teachings[i];
        Menu.teachings[i] = Menu.teachings[j];
        Menu.teachings[j] = tempTeaching;
    }


    public void salaryCalculation() {
        for (int i = 0; i < Menu.teachings.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.teachings[i]))
                break;
            System.out.println(Menu.teachings[i].getTeacher());
            System.out.println("Được hưởng lương: " + Menu.teachings[i].getSalary());
        }
    }

    public void initializePointTableData() {
        Object teachingFromFile = Menu.fileUtil.readDataFromFile(TeachingService.TEACHING_DATA_FILE);
        if (!DataUtil.isNullOrEmpty(teachingFromFile)) {
            Teaching[] copyTeachings = (Teaching[]) teachingFromFile;
            System.arraycopy(copyTeachings, 0, Menu.teachings, 0, copyTeachings.length);
        }
    }

}

