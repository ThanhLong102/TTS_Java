package Exception_JavaIO.Service;

import Exception_JavaIO.Entity.Student;
import Exception_JavaIO.Menu.Menu;
import Exception_JavaIO.Util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentService {

    public static final String STUDENT_DATA_FILE = "src/Exception_JavaIO/Util/File/student.dat";

    public void showStudent() {
        for (int i = 0; i < Menu.students.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.students[i])) {
                break;
            }
            System.out.println(Menu.students[i]);
        }
    }

    public void addNewStudent() {
        System.out.print("Nhập số sinh viên muốn thêm mới: ");
        int studentNumber = -1;
        do {
            try {
                studentNumber = new Scanner(System.in).nextInt();
                if (studentNumber > 0) {
                    break;
                }
                System.out.print("Số sinh viên muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số sinh viên muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < studentNumber; i++) {
            Student student = new Student();
            student.inputInfo();
            addStudentToArray(student);
        }
        Menu.fileUtil.writeDataToFile(Menu.students, STUDENT_DATA_FILE);
    }

    public void addStudentToArray(Student student) {
        for (int i = 0; i < Menu.students.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.students[i])) {
                Menu.students[i] = student;
                return;
            }
        }
    }

    public Student findStudentById(int studentId) {
        for (int i = 0; i < Menu.students.length; i++) {
            if (DataUtil.isNullOrEmpty(Menu.students[i]))
                return null;
            if (studentId == Menu.students[i].getId()) {
                return Menu.students[i];
            }
        }
        return null;
    }

    public void initializeStudentData() {
        Object studentFromFile = Menu.fileUtil.readDataFromFile(StudentService.STUDENT_DATA_FILE);
        if (!DataUtil.isNullOrEmpty(studentFromFile)) {
            Student[] copyStudents = (Student[]) studentFromFile;
            System.arraycopy(copyStudents, 0, Menu.students, 0, copyStudents.length);
            for (int i = 0; i < copyStudents.length; i++) {
                if (DataUtil.isNullOrEmpty(copyStudents[i])) {
                    Student.AUTO_ID = copyStudents[i - 1].getId() + 1;
                    break;
                }
            }

        }
    }
}
