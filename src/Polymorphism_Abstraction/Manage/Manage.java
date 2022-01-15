package Polymorphism_Abstraction.Manage;

import Polymorphism_Abstraction.Model.GiangVien;
import Polymorphism_Abstraction.Model.KeKhaiGiangDay;
import Polymorphism_Abstraction.Model.MonHoc;

import java.util.Arrays;
import java.util.Scanner;

public class Manage implements IManage{
    private final Scanner sc = new Scanner(System.in);
    private int sgv=0;
    private int sm=0;
    private int sql=0;
    private GiangVien[] giangViens;
    private MonHoc[] monHocs;
    private KeKhaiGiangDay[] keKhaiGiangDays;

    private static Manage Instance;

    private Manage(){
    }

    public static Manage getInstance(){
        if(Instance==null){
            Instance= new Manage();
        }
        return Instance;
    }

    @Override
    public void nhapMonHoc(){
        System.out.println("Nhap ten mon:");
        String ten=sc.nextLine();
        System.out.println("Nhap so tiet:");
        int st=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so tiet ly thuyet:");
        int stlt=Integer.parseInt(sc.nextLine());
        System.out.println("Muc kinh phi:");
        int kp=Integer.parseInt(sc.nextLine());
        MonHoc monHoc = new MonHoc(ten,st,stlt,kp);
        MonHoc[] temptMonHocs=new MonHoc[sm+1];
        if(monHocs!=null){
            System.arraycopy(monHocs, 0, temptMonHocs, 0, sm);
        }
        monHocs=temptMonHocs;
        monHocs[sm]=monHoc;
        sm++;

        for(int i=0;i<sm;i++){
            System.out.println(monHocs[i].toString());
        }
    }

    @Override
    public void nhapGiangVien(){
        System.out.println("Nhap Ho va ten:");
        String ten=sc.nextLine();
        System.out.println("Nhap dia chi:");
        String diachi=sc.nextLine();
        System.out.println("Nhap so dien thoai:");
        String sdt=sc.nextLine();
        System.out.println("Nhap trinh do (GS-TS, PGS-TS, Giảng viên chính, Thạc sỹ):");
        String td=sc.nextLine();
        GiangVien giangVien=new GiangVien(ten,diachi,sdt,td);
        GiangVien[] temptGvs=new GiangVien[sgv+1];
        if(giangViens!=null){
            System.arraycopy(giangViens, 0, temptGvs, 0, sgv);
        }
        giangViens=temptGvs;
        giangViens[sgv]=giangVien;
        sgv++;

        for(int i=0;i<sgv;i++){
            System.out.println(giangViens[i].toString());
        }
    }

    public MonHoc getMonHocByMa(int ma){
        for(int i=0;i<sm;i++) {
            if (monHocs[i].getMa() == ma) {
                return monHocs[i];
            }
        }
        return null;
    }

    public GiangVien getGvByMa(int ma){
        for(int i=0;i<sgv;i++) {
            if (giangViens[i].getMa() == ma) {
                return giangViens[i];
            }
        }
        return null;
    }

    public boolean trungMa(int magv,int mam){
        for (int i=0;i<sql;i++){
            if(keKhaiGiangDays[i].getGiangVien().getMa() == magv && keKhaiGiangDays[i].getMonHoc().getMa()==mam){
                return true;
            }
        }
        return false;
    }

    public int demSoTiet(int maB){
        int sum=0;
        for (int i=0;i<sql;i++){
            if(keKhaiGiangDays[i].getGiangVien().getMa()==maB){
                sum=sum+keKhaiGiangDays[i].getSoLop()*keKhaiGiangDays[i].getMonHoc().getTongSoTiet();
            }
        }
        return sum;
    }

    @Override
    public void nhapQlGiangDay(){
        System.out.println("Nhap ma Giang Vien:");
        int maGv=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ma Mon:");
        int maM=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so lop:");
        int sl=Integer.parseInt(sc.nextLine());
        if(trungMa(maGv,maM)){
            System.out.println("Trung mon da day");
            return;
        }
        if(sl>3){
            System.out.println("Day qua 3 lop");
            return;
        }
        if(demSoTiet(maGv)+sl*getMonHocByMa(maM).getTongSoTiet()>200){
            System.out.println("Day qua 200 tiet");
            return;
        }
        if(getGvByMa(maGv)==null || getMonHocByMa(maM)==null){
            System.out.println("Kiem tra lai ma Gv(ma mon hoc)");
            return;
        }
        KeKhaiGiangDay ql=new KeKhaiGiangDay(getGvByMa(maGv),getMonHocByMa(maM),sl);
        KeKhaiGiangDay[] temptQl=new KeKhaiGiangDay[sql+1];
        if(keKhaiGiangDays!=null){
            System.arraycopy(keKhaiGiangDays, 0, temptQl, 0, sql);
        }
        keKhaiGiangDays=temptQl;
        keKhaiGiangDays[sql]=ql;
        sql++;
        for(int i=0;i<sql;i++){
            System.out.println(keKhaiGiangDays[i].toString());
        }
    }

    @Override
    public void sapXepTenGv(){
        Arrays.sort(keKhaiGiangDays, (o1, o2) -> {
            String[] ten1=o1.getGiangVien().getTen().split("\\s+");
            String[] ten2=o2.getGiangVien().getTen().split("\\s+");
            if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                return o1.getGiangVien().getTen().compareToIgnoreCase(o2.getGiangVien().getTen());
            }else{
                return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
            }
        });
        for(int i=0;i<sql;i++){
            System.out.println(keKhaiGiangDays[i].toString());
        }
    }

    @Override
    public void sapXepSoTietGiangDay(){
        Arrays.sort(keKhaiGiangDays, (o1, o2) -> Integer.compare(o2.getMonHoc().getTongSoTiet(), o1.getMonHoc().getTongSoTiet()));
        for(int i=0;i<sql;i++){
            System.out.println(keKhaiGiangDays[i].toString());
        }
    }

    @Override
    public void tinhTienCongChoMoiGiangVien(){
        System.out.println("Ma\tGiang Vien \t\t\t Tong so tien cong");
        int[] ma = new int[sql];
        int soGv=0;
        float[] tienLuong= new float[sql];
        for(int i=0;i<sql;i++){
            boolean check=true;
            for(int j=0;j<soGv;j++){
                if(ma[j] == keKhaiGiangDays[i].getGiangVien().getMa()){
                    check=false;
                    break;
                }
            }
            if(check){
                ma[soGv++]=keKhaiGiangDays[i].getGiangVien().getMa();
            }
        }

        for (int i=0;i<soGv;i++){
            float tien=0;
            for (int j=0;j<sql;j++){
                if(keKhaiGiangDays[j].getGiangVien().getMa() == ma[i]){
                    tien+=(float) (keKhaiGiangDays[j].getSoLop()*keKhaiGiangDays[j].getMonHoc().getMucKinhPhi()
                            *(keKhaiGiangDays[j].getMonHoc().getSoTietLyThuyet()
                            +(keKhaiGiangDays[j].getMonHoc().getTongSoTiet()-keKhaiGiangDays[j].getMonHoc().getSoTietLyThuyet())*0.7));
                }
                tienLuong[i]=tien;
            }
        }
        for(int i=0;i<soGv;i++){
            System.out.println(ma[i]+"  "+getGvByMa(ma[i]).getTen()+"\t"+tienLuong[i]);
        }
    }
}