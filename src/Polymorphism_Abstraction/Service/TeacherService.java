package Polymorphism_Abstraction.Service;

import Polymorphism_Abstraction.Entity.Teacher;
import Polymorphism_Abstraction.Menu.Menu;
import Polymorphism_Abstraction.Util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherService {

    public static final String TEACHER_DATA_FILE = "src/Polymorphism_Abstraction/Util/File/teacher.dat";

    public void addNewTeacher() {
        System.out.print("Nhập số giảng viên muốn thêm mới: ");
        int teacherNumber = -1;
        do {
            try {
                teacherNumber = new Scanner(System.in).nextInt();
                if (teacherNumber > 0) {
                    break;
                }
                System.out.print("Số giảng viên muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số giảng viên muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < teacherNumber; i++) {
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            addTeacherToArray(teacher);
        }
        Menu.fileUtil.writeDataToFile(Menu.teachers, TEACHER_DATA_FILE);
    }

    public void addTeacherToArray(Teacher teacher) {
        for (int i = 0; i < Menu.teachers.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.teachers[i])) {
                Menu.teachers[i] = teacher;
                break;
            }
        }
    }

    public void showTeachers() {
        for (int i = 0; i < Menu.teachers.length; i++) {
            Teacher teacher = Menu.teachers[i];
            if (DataUtil.isNullOrEmpty(teacher)) {
                break;
            }
            System.out.println(teacher);
        }
    }

    public Teacher findTeacherById(int teacherId) {
        for (int i = 0; i < Menu.teachers.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.teachers[i]))
                return null;
            if (teacherId == Menu.teachers[i].getId()) {
                return Menu.teachers[i];
            }
        }
        return null;
    }

    public void initializeTeacherData() {
        Object teacherFromFile = Menu.fileUtil.readDataFromFile(TeacherService.TEACHER_DATA_FILE);
        if (!DataUtil.isNullOrEmpty(teacherFromFile)) {
            Teacher[] copyTeachers = (Teacher[]) teacherFromFile;
            System.arraycopy(copyTeachers, 0, Menu.teachers, 0, copyTeachers.length);
            for (int i = 0; i < copyTeachers.length; i++) {
                if (DataUtil.isNullOrEmpty(copyTeachers[i])) {
                    Teacher.AUTO_ID = copyTeachers[i - 1].getId() + 1;
                    break;
                }
            }
        }
    }
}
