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
        System.out.println("---------QUẢN LÝ Bảng điểm sinh viên---------");
        System.out.println("1. Nhập danh sách sinh viên mới và in ra danh sách sinh viên trong trường");
        System.out.println("2. Nhập danh sách môn học mới và in ra danh sách môn học trong trường");
        System.out.println("3. Bảng điểm của sinh viên và in ra danh sách bảng điểm");
        System.out.println("4. Sắp xếp họ tên sinh viên");
        System.out.println("5. Sắp xếp họ tên môn học");
        System.out.println("6. Tính điểm và lập bảng điểm");
        System.out.println("7. Thoát");
        System.out.println("----------------------------------------------");
        System.out.print("Chọn chức năng: ");
        do {
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 7) {
                    return choice;
                }
                System.out.print("Chức năng khả dụng là một số nguyên từ 1 tới 7, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Chức năng chọn phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
    }
}
