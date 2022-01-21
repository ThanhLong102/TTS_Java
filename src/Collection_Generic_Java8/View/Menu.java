package Collection_Generic_Java8.View;

import Collection_Generic_Java8.Controller.Manage;
import Collection_Generic_Java8.Controller.Manageable;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Manageable manage = Manage.getInstance();
        boolean check = true;
        while (check) {
            while (check) {
                System.out.println("------MENU-------");
                System.out.println("0:Thoát");
                System.out.println("1:Nhap lai xe moi");
                System.out.println("2:Nhap tuyen moi");
                System.out.println("3:Nhap Bang phan cong");
                System.out.println("4:Sap xep theo ten lai xe");
                System.out.println("5:Sap xep theo luot");
                System.out.println("6:Tinh thong ke khoang cach chay xe cua moi lai xe");
                System.out.println("Chon 0-->6:");
                int chon;
                Scanner in = new Scanner(System.in);
                chon = Integer.parseInt(in.nextLine());
                switch (chon) {
                    case 0:
                        check = false;
                        break;
                    case 1:
                        manage.nhapLaiXe();
                        break;
                    case 2:
                        manage.nhapTuyen();
                        break;
                    case 3:
                        manage.nhapPhanCong();
                        break;
                    case 4:
                        manage.sapXepTenLaiXe();
                        break;
                    case 5:
                        manage.sapXepLuot();
                        break;
                    case 6:
                        manage.thongKeKhoangCachChayXe();
                        break;
                    default:
                        System.out.println("chi chon 0->6");
                        break;

                }
            }
        }
    }
}
