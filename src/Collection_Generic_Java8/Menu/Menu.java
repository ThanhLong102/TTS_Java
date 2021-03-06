package Collection_Generic_Java8.Menu;


import Collection_Generic_Java8.Entity.Driver;
import Collection_Generic_Java8.Entity.Line;
import Collection_Generic_Java8.Entity.Point.AssignmentTable;
import Collection_Generic_Java8.Service.AssigmentService;
import Collection_Generic_Java8.Service.DriverService;
import Collection_Generic_Java8.Service.LineService;
import Collection_Generic_Java8.Util.File.FileUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static List<Driver> driverList;
    public static List<Line> lineList;
    public static List<AssignmentTable> assignmentTableList;
    public static FileUtil fileUtil = new FileUtil();

    public static DriverService driverService = new DriverService();
    public static LineService lineService = new LineService();
    public static AssigmentService assigmentService = new AssigmentService();


    public static void main(String[] args) {
        initializeData();
        menu();
    }

    public static void initializeData() {
        driverService.initializeDriverData();
        lineService.initializeLineData();
        assigmentService.initializeAssignmentTableData();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    driverService.addNewDriver();
                    driverService.showDriver();
                    break;
                case 2:
                    lineService.addNewLine();
                    lineService.showLine();
                    break;
                case 3:
                    assigmentService.creatAssignmentTable();
                    assigmentService.showAssignmentTable();
                    break;
                case 4:
                    assigmentService.sortByNameDriver();
                    assigmentService.showAssignmentTable();
                    break;
                case 5:
                    assigmentService.sortByTurnNumber();
                    assigmentService.showAssignmentTable();
                    break;
                case 6:
                    assigmentService.distanceStatistics();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }


    public static int functionChoice() {
        System.out.println("---------QU???N L?? B???ng ??i???m sinh vi??n---------");
        System.out.println("1. Nh???p danh s??ch l??i xe m???i v?? in ra danh s??ch l??i xe trong tr?????ng");
        System.out.println("2. Nh???p danh s??ch tuy???n m???i v?? in ra danh s??ch tuy???n trong tr?????ng");
        System.out.println("3. B???ng ph??n c??ng c???a l??i xe v?? in ra danh s??ch b???ng ph??n c??ng");
        System.out.println("4. S???p x???p h??? t??n l??i xe");
        System.out.println("5. S???p x???p s??? l?????ng tuy???n trong ng??y(Gi???m d???n)");
        System.out.println("6. B???ng k?? t???ng kho???ng c??ch ch???y xe trong ng??y c???a m???i l??i xe");
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
