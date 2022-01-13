package Encapsulation_Inheritance.Menu;

import Encapsulation_Inheritance.Manage.Manage;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Manage manage= Manage.getInstance();
        boolean check=true;
        while (check){
            while (check) {
                System.out.println("------MENU-------");
                System.out.println("0:Thoát");
                System.out.println("1:Nhap Danh sach");
                System.out.println("2:Nhap  Ban Doc");
                System.out.println("3:Nhap ql muon");
                System.out.println("4:Sap xep theo ten ban doc");
                System.out.println("5:Sap xep theo so luong cuon sach muon");
                System.out.println("6:tim kiem theo ten ban doc");
                System.out.println("Chon 0-->6:");
                int chon;
                Scanner in = new Scanner(System.in);
                chon = Integer.parseInt(in.nextLine());
                switch (chon) {
                    case 0:check=false;
                        break;
                    case 1: manage.nhapDanhSach();
                        break;
                    case 2:
                        manage.nhapBanDoc();
                        break;
                    case 3:
                        manage.nhapQlMuon();
                        break;
                    case 4:
                        manage.sapXepTenBanDoc();
                        break;
                    case 5:
                        manage.sapXepSoLuongCuonMuon();
                        break;
                    case 6:
                        manage.timKiemTheoTenBanDoc();
                        break;
                    default:
                        System.out.println("chi chon 0->6");
                        break;

                }
            }
        }
    }
}
