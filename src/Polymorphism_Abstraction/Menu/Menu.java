package Polymorphism_Abstraction.Menu;


import Polymorphism_Abstraction.Manage.IManage;
import Polymorphism_Abstraction.Manage.Manage;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        IManage manage= Manage.getInstance();
        boolean check=true;
        while (check){
            while (check) {
                System.out.println("------MENU-------");
                System.out.println("0:Thoát");
                System.out.println("1:Nhap mon hoc moi");
                System.out.println("2:Nhap giang vien moi");
                System.out.println("3:Nhap ql giang day");
                System.out.println("4:Sap xep theo ten giang vien");
                System.out.println("5:Sap xep so tiet giang day");
                System.out.println("6:Tinh tien Cong");
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
                        manage.nhapGiangVien();
                        break;
                    case 3:
                        manage.nhapQlGiangDay();
                        break;
                    case 4:
                        manage.sapXepTenGv();
                        break;
                    case 5:
                        manage.sapXepSoTietGiangDay();
                        break;
                    case 6:
                        manage.tinhTienCongChoMoiGiangVien();
                        break;
                    default:
                        System.out.println("chi chon 0->6");
                        break;

                }
            }
        }
    }
}
