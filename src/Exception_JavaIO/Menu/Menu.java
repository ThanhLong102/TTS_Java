package Exception_JavaIO.Menu;


import Exception_JavaIO.Entity.Point.PointTable;
import Exception_JavaIO.Entity.Student;
import Exception_JavaIO.Entity.Subject;
import Exception_JavaIO.Service.PointService;
import Exception_JavaIO.Service.StudentService;
import Exception_JavaIO.Service.SubjectService;
import Exception_JavaIO.Util.File.FileUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static Student[] students = new Student[100];
    public static Subject[] subjects = new Subject[100];
    public static PointTable[] pointTables = new PointTable[100];

    public static StudentService studentService = new StudentService();
    public static SubjectService subjectService = new SubjectService();
    public static PointService pointService = new PointService();

    public static FileUtil fileUtil = new FileUtil();

    public static void main(String[] args) {
        initializeData();
        menu();
    }

    private static void initializeData() {
        studentService.initializeStudentData();
        subjectService.initializeSubjectData();
        pointService.initializePointTableData();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    studentService.addNewStudent();
                    studentService.showStudent();
                    break;
                case 2:
                    subjectService.addNewSubject();
                    subjectService.showSubjects();
                    break;
                case 3:
                    pointService.creatPointTable();
                    pointService.showPointTable();
                    break;
                case 4:
                    pointService.sortPointTableToNameStudent();
                    pointService.showPointTable();
                    break;
                case 5:
                    pointService.sortPointTableToNameSubject();
                    pointService.showPointTable();
                    break;
                case 6:
                    pointService.pointCalculation();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }


    public static int functionChoice() {
        System.out.println("---------QU???N L?? B???ng ??i???m sinh vi??n---------");
        System.out.println("1. Nh???p danh s??ch sinh vi??n m???i v?? in ra danh s??ch sinh vi??n trong tr?????ng");
        System.out.println("2. Nh???p danh s??ch m??n h???c m???i v?? in ra danh s??ch m??n h???c trong tr?????ng");
        System.out.println("3. B???ng ??i???m c???a sinh vi??n v?? in ra danh s??ch b???ng ??i???m");
        System.out.println("4. S???p x???p h??? t??n sinh vi??n");
        System.out.println("5. S???p x???p h??? t??n m??n h???c");
        System.out.println("6. T??nh ??i???m v?? l???p b???ng ??i???m");
        System.out.println("7. Tho??t");
        System.out.println("----------------------------------------------");
        System.out.print("Ch???n ch???c n??ng: ");
        do {
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 7) {
                    return choice;
                }
                System.out.print("Ch???c n??ng kh??? d???ng l?? m???t s??? nguy??n t??? 1 t???i 7, vui l??ng ch???n l???i: ");
            } catch (InputMismatchException ex) {
                System.out.print("Ch???c n??ng ch???n ph???i l?? m???t s??? nguy??n, vui l??ng nh???p l???i: ");
            }
        } while (true);
    }
}
