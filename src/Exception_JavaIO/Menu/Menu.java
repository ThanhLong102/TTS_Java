package Exception_JavaIO.Menu;


import Exception_JavaIO.Manage.Manage;
import Exception_JavaIO.Manage.Manageable;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Manageable manage= Manage.getInstance();
        boolean check=true;
        while (check){
            while (check) {
                System.out.println("------MENU-------");
                System.out.println("0:Thoát");
                System.out.println("1:Nhap mon hoc moi");
                System.out.println("2:Nhap Sinh vien moi");
                System.out.println("3:Nhap Bang Diem");
                System.out.println("4:Sap xep theo ten sinh vien");
                System.out.println("5:Sap xep theo ten sinh mon");
                System.out.println("6:Tinh diem");
                System.out.println("Chon 0-->6:");
                int chon;
                Scanner in = new Scanner(System.in);
                chon = Integer.parseInt(in.nextLine());
                switch (chon) {
                    case 0:check=false;
                        break;
                    case 1: manage.nhapMonHoc();
                        break;
                    case 2:
                        manage.nhapSinhVien();
                        break;
                    case 3:
                        manage.nhapQlGiangDay();
                        break;
                    case 4:
                        manage.sapXepTenSv();
                        break;
                    case 5:
                        manage.sapXepTenMon();
                        break;
                    case 6:
                        manage.tinhDiemChoSinhVien();
                        break;
                    default:
                        System.out.println("chi chon 0->6");
                        break;

                }
            }
        }
    }
}
