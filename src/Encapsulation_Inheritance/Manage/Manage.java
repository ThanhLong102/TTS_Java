package Encapsulation_Inheritance.Manage;

import Encapsulation_Inheritance.Model.BanDoc;
import Encapsulation_Inheritance.Model.QLMuonSach;
import Encapsulation_Inheritance.Model.Sach;

import java.util.Arrays;
import java.util.Scanner;


public class Manage {

    private final Scanner sc = new Scanner(System.in);
    private int sbd=0;
    private int ss=0;
    private int sql=0;
    private BanDoc[] banDocs;
    private Sach[] sachs;
    private QLMuonSach[] qlMuonSachs;

    private static Manage Instance;

    private Manage(){
    }

    public static Manage getInstance(){
        if(Instance==null){
            Instance= new Manage();
        }
        return Instance;
    }

    public void nhapDanhSach(){
        System.out.println("Nhap ten sach:");
        String ten=sc.nextLine();
        System.out.println("Nhap tac gia:");
        String tacgia=sc.nextLine();
        System.out.println("Nhap chuyen nganh:");
        String chuyenNganh=sc.nextLine();
        System.out.println("Nhap nam xuat:");
        int nam=Integer.parseInt(sc.nextLine());
        Sach sach=new Sach(ten,tacgia,chuyenNganh,nam);
        Sach[] temptSachs=new Sach[ss+1];
        if(sachs!=null){
            System.arraycopy(sachs, 0, temptSachs, 0, ss);
        }
        sachs=temptSachs;
        sachs[ss]=sach;
        ss++;

        for(int i=0;i<ss;i++){
            System.out.println(sachs[i].toString());
        }
    }

    public void nhapBanDoc(){
        System.out.println("Nhap Ho va ten:");
        String ten=sc.nextLine();
        System.out.println("Nhap dia chi:");
        String diachi=sc.nextLine();
        System.out.println("Nhap so dien thoai:");
        String sdt=sc.nextLine();
        System.out.println("Nhap loai ban doc:");
        String loai=sc.nextLine();
        BanDoc banDoc=new BanDoc(ten,diachi,sdt,loai);
        BanDoc[] temptBanDos=new BanDoc[sbd+1];
        if(banDocs!=null){
            System.arraycopy(banDocs, 0, temptBanDos, 0, sbd);
        }
        banDocs=temptBanDos;
        banDocs[sbd]=banDoc;
        sbd++;

        for(int i=0;i<sbd;i++){
            System.out.println(banDocs[i].toString());
        }
    }

    public BanDoc getBanDocByMa(int ma){
        for(int i=0;i<sbd;i++) {
            if (banDocs[i].getMa() == ma) {
                return banDocs[i];
            }
        }
        return null;
    }

    public Sach getSachByMa(int ma){
        for(int i=0;i<ss;i++) {
            if (sachs[i].getMa() == ma) {
                return sachs[i];
            }
        }
        return null;
    }

    public boolean trungMa(int maS,int maB){
        for (int i=0;i<sql;i++){
            if(qlMuonSachs[i].getSach().getMa() == maS && qlMuonSachs[i].getBanDoc().getMa()==maB){
                return true;
            }
        }
        return false;
    }

    public int demDauSach(int maB){
        int sum=0;
        for (int i=0;i<sql;i++){
            if(qlMuonSachs[i].getBanDoc().getMa()==maB){
                sum+=1;
            }
        }
        return sum;
    }
    public void nhapQlMuon(){
        System.out.println("Nhap ma ban doc:");
        int maB=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ma sach:");
        int maS=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so luong sach:");
        int sl=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap tinh trang sach:");
        String tt= sc.nextLine();
        if(trungMa(maS,maB)){
            System.out.println("Trung sach");
            return;
        }
        if(sl>3){
            System.out.println("Muon qua 3 cuon");
            return;
        }
        if(demDauSach(maB)>=5){
            System.out.println("Muon qua 5 dau sach");
            return;
        }
        if(getBanDocByMa(maB)==null || getBanDocByMa(maS)==null){
            System.out.println("Kiem tra lai ma sach(ma ban doc)");
            return;
        }
        QLMuonSach ql=new QLMuonSach(getBanDocByMa(maB),getSachByMa(maS),sl,tt);
        QLMuonSach[] temptQl=new QLMuonSach[sql+1];
        if(qlMuonSachs!=null){
            System.arraycopy(qlMuonSachs, 0, temptQl, 0, sql);
        }
        qlMuonSachs=temptQl;
        qlMuonSachs[sql]=ql;
        sql++;
        for(int i=0;i<sql;i++){
            System.out.println(qlMuonSachs[i].toString());
        }
    }

    public void sapXepTenBanDoc(){
        Arrays.sort(qlMuonSachs, (o1, o2) -> {
            String[] ten1=o1.getBanDoc().getTen().split("\\s+");
            String[] ten2=o2.getBanDoc().getTen().split("\\s+");
            if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                return o1.getBanDoc().getTen().compareToIgnoreCase(o2.getBanDoc().getTen());
            }else{
                return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
            }
        });
        for(int i=0;i<sql;i++){
            System.out.println(qlMuonSachs[i].toString());
        }
    }

    public void sapXepSoLuongCuonMuon(){
        Arrays.sort(qlMuonSachs, (o1, o2) -> Integer.compare(o2.getSoluong(), o1.getSoluong()));
        for(int i=0;i<sql;i++){
            System.out.println(qlMuonSachs[i].toString());
        }
    }

    public void timKiemTheoTenBanDoc(){
        System.out.println("Nhap ten ban doc can tim kiem:");
        String ten=sc.nextLine().toLowerCase();
        for(int i=0;i<sql;i++){
            if(qlMuonSachs[i].getBanDoc().getTen().toLowerCase().contains(ten)){
                System.out.println(qlMuonSachs[i].toString());
            }
        }
    }
}
