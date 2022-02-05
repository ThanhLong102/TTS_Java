package Exception_JavaIO.Service;

import Exception_JavaIO.Entity.Subject;
import Exception_JavaIO.Menu.Menu;
import Exception_JavaIO.Util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubjectService {

    public static final String SUBJECT_DATA_FILE = "src/Exception_JavaIO/Util/File/subject.dat";

    public void showSubjects() {
        for (int i = 0; i < Menu.subjects.length; i++) {
            Subject subject = Menu.subjects[i];
            if (DataUtil.isNullOrEmpty(subject)) {
                break;
            }
            System.out.println(subject);
        }
    }

    public void addNewSubject() {
        System.out.print("Nhập số môn học muốn thêm mới: ");
        int subjectNumber = -1;
        do {
            try {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber > 0) {
                    break;
                }
                System.out.print("Số môn học muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số môn học muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = new Subject();
            subject.inputInfo();
            addSubjectToArray(subject);
        }
        Menu.fileUtil.writeDataToFile(Menu.subjects, SUBJECT_DATA_FILE);
    }

    public void addSubjectToArray(Subject subject) {
        for (int i = 0; i < Menu.subjects.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.subjects[i])) {
                Menu.subjects[i] = subject;
                return;
            }
        }
    }

    public Subject findSubjectById(int subjectId) {
        for (int i = 0; i < Menu.subjects.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.subjects[i]))
                return null;
            if (subjectId == Menu.subjects[i].getId()) {
                return Menu.subjects[i];
            }
        }
        return null;
    }

    public void initializeSubjectData() {
        Object subjectFromFile = Menu.fileUtil.readDataFromFile(SubjectService.SUBJECT_DATA_FILE);
        if (!DataUtil.isNullOrEmpty(subjectFromFile)) {
            Subject[] copySubjects = (Subject[]) subjectFromFile;
            System.arraycopy(copySubjects, 0, Menu.subjects, 0, copySubjects.length);
            for (int i = 0; i < copySubjects.length; i++) {
                if (DataUtil.isNullOrEmpty(copySubjects[i])) {
                    Subject.AUTO_ID = copySubjects[i - 1].getId() + 1;
                    break;
                }
            }
        }
    }
}
