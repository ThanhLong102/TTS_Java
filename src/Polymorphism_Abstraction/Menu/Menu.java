package Polymorphism_Abstraction.Menu;

import Polymorphism_Abstraction.Entity.Subject;
import Polymorphism_Abstraction.Entity.Teacher;
import Polymorphism_Abstraction.Entity.teaching.Teaching;
import Polymorphism_Abstraction.Service.SubjectService;
import Polymorphism_Abstraction.Service.TeacherService;
import Polymorphism_Abstraction.Service.TeachingService;
import Polymorphism_Abstraction.Util.File.FileUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static Subject[] subjects = new Subject[100];
    public static Teacher[] teachers = new Teacher[100];
    public static Teaching[] teachings = new Teaching[100];


    public static TeacherService teacherService = new TeacherService();
    public static SubjectService subjectService = new SubjectService();
    public static TeachingService teachingService = new TeachingService();

    public static FileUtil fileUtil = new FileUtil();


    public static void main(String[] args) {
        initializeData();
        menu();
    }

    private static void initializeData() {
        subjectService.initializeSubjectData();
        teacherService.initializeTeacherData();
        teachingService.initializePointTableData();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    subjectService.addNewSubject();
                    subjectService.showSubjects();
                    break;
                case 2:
                    teacherService.addNewTeacher();
                    teacherService.showTeachers();
                    break;
                case 3:
                    teachingService.createTeaching();
                    teachingService.showTeachings();
                    break;
                case 4:
                    teachingService.sortByNameTeacher();
                    teachingService.showTeachings();
                    break;
                case 5:
                    teachingService.sortByTotalLessonEachSubject();
                    teachingService.showTeachings();
                    break;
                case 6:
                    teachingService.salaryCalculation();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }


    public static int functionChoice() {
        System.out.println("------------QUẢN LÝ TRẢ LƯƠNG CHO GIẢNG VIÊN THỈNH GIẢNG--------------");
        System.out.println("1. Nhập danh sách môn học mới và in ra danh sách môn học trong trường");
        System.out.println("2. Nhập danh sách giảng viên mới và in ra danh sách giảng viên trong trường");
        System.out.println("3. Phân công giảng dạy cho giảng viên và in ra danh sách giảng dạy");
        System.out.println("4. Sắp xếp danh sách tên giảng viên");
        System.out.println("5. Sắp xếp danh sách số tiết giảng dạy mỗi môn");
        System.out.println("6. Tính toán và lập bảng lương");
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
