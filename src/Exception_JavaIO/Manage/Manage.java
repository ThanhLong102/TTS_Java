package Exception_JavaIO.Manage;

import Exception_JavaIO.Exception.*;
import Exception_JavaIO.Model.BangDiem;
import Exception_JavaIO.Model.MonHoc;
import Exception_JavaIO.Model.SinhVien;

import java.util.Arrays;
import java.util.Scanner;

public class Manage implements Manageable {
    private final Scanner sc = new Scanner(System.in);
    private int sSv=0;
    private int sm=0;
    private int sql=0;
    private final String fm = "MON.dat";
    private final String fsv = "SV.dat";
    private final String fbD = "BD.dat";

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
        MonHoc[] arrMonHoc=new MonHoc[sm+1];
        try{
            System.out.println("Nhap ten mon:");
            String ten=sc.nextLine();
            System.out.println("Nhap so don vi hoc trinh:");
            int st=Integer.parseInt(sc.nextLine());
            System.out.println("Nhap loai mon (chi nhap: Dai cuong,Co so nganh,Chuyen Nganh)");
            String loai=sc.nextLine();

            MonHoc monHoc = new MonHoc(ten,st,loai);
            MonHoc[] tempMonHocs=new MonHoc[sm];

            if(sm>0) tempMonHocs = (MonHoc[]) IOFile.doc(fm, sm);
            System.arraycopy(tempMonHocs, 0, arrMonHoc, 0, sm);
            arrMonHoc[sm]=monHoc;
            sm++;
            IOFile.viet(fm,arrMonHoc);

        } catch (LoaiException e) {
            System.out.println("Nhap sai loai mon");
        } catch (TrongException e) {
            System.out.println("Vui long khong de trong");
        }catch (NumberFormatException e){
            System.out.println("Chi nhap so");
        }

        for(int i=0;i<sm;i++){
            System.out.println(arrMonHoc[i].toString());
        }
    }

    @Override
    public void nhapSinhVien(){
        SinhVien[] arrSv=new SinhVien[sSv+1];
        try {
            System.out.println("Nhap Ho va ten:");
            String ten=sc.nextLine();
            System.out.println("Nhap dia chi:");
            String diachi=sc.nextLine();
            System.out.println("Nhap so dien thoai:");
            String sdt=sc.nextLine();
            System.out.println("Nhap lop");
            String lop=sc.nextLine();

            SinhVien sinhVien=new SinhVien(ten,diachi,sdt,lop);
            SinhVien[] temptSinhViens=new SinhVien[sSv];

            if(sSv>0) temptSinhViens = (SinhVien[]) IOFile.doc(fsv, sSv);
            System.arraycopy(temptSinhViens, 0, arrSv, 0, sSv);
            arrSv[sSv]=sinhVien;
            IOFile.viet(fsv,arrSv);
            sSv++;

        } catch (DienThoaiException e) {
            System.out.println("Nhap dung 11 so");
        } catch (TrongException e) {
            System.out.println("Vui long k de trong");
        }

        for(int i=0;i<sSv;i++){
            System.out.println(arrSv[i].toString());
        }
    }

    public MonHoc getMonHocByMa(int ma){
        MonHoc[] arrMon= (MonHoc[]) IOFile.doc(fm,sm);
        for(int i=0;i<sm;i++) {
            if (arrMon[i].getMa() == ma) {
                return arrMon[i];
            }
        }
        return null;
    }

    public SinhVien getSvByMa(int ma){
        SinhVien[] arrSv= (SinhVien[]) IOFile.doc(fsv,sSv);
        for(int i=0;i<sSv;i++) {
            if (arrSv[i].getMa() == ma) {
                return arrSv[i];
            }
        }
        return null;
    }

    public boolean trungMa(int masv,int mam){
        if(sql==0) {
            return false;
        }
        BangDiem[] arrBangDiem = (BangDiem []) IOFile.doc(fbD,sql);

        for (int i=0;i<sql;i++){
            if(arrBangDiem[i].getSinhVien().getMa() == masv && arrBangDiem[i].getMonHoc().getMa()==mam){
                return true;
            }
        }
        return false;
    }


    @Override
    public void nhapQlGiangDay(){
        BangDiem[] arrBd=new BangDiem[sql+1];
        try{
            System.out.println("Nhap ma Sinh Vien:");
            int maSv=Integer.parseInt(sc.nextLine());
            System.out.println("Nhap ma Mon:");
            int maM=Integer.parseInt(sc.nextLine());
            System.out.println("Nhap diem:");
            float diem=Float.parseFloat(sc.nextLine());
            if(trungMa(maSv,maM)){
                System.out.println("Trung mon da day");
                return;
            }
            if(getSvByMa(maSv)==null || getMonHocByMa(maM)==null){
                System.out.println("Kiem tra lai ma Sv(ma mon hoc)");
                return;
            }

            BangDiem ql=new BangDiem(getSvByMa(maSv),getMonHocByMa(maM),diem);
            BangDiem[] temptBds=new BangDiem[sql];

            if(sql>0) temptBds = (BangDiem[]) IOFile.doc(fbD, sql);
            System.arraycopy(temptBds, 0, arrBd, 0, sql);
            arrBd[sql]=ql;
            IOFile.viet(fbD,arrBd);
            sql++;

        } catch (DiemException e) {
            System.out.println("Nhap  0<= diem <=10 ");
        }catch (NumberFormatException e){
            System.out.println("Chi nhap so");
        }


        for(int i=0;i<sql;i++){
            System.out.println(arrBd[i].toString());
        }
    }

    @Override
    public void sapXepTenSv(){
        if(sql==0) {
            return ;
        }
        BangDiem[] arrBangDiem= (BangDiem[]) IOFile.doc(fbD,sql);
        Arrays.sort(arrBangDiem, (o1, o2) -> {
            String[] ten1=o1.getSinhVien().getTen().split("\\s+");
            String[] ten2=o2.getSinhVien().getTen().split("\\s+");
            if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                return o1.getSinhVien().getTen().compareToIgnoreCase(o2.getSinhVien().getTen());
            }else{
                return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
            }
        });
        for(int i=0;i<sql;i++){
            System.out.println(arrBangDiem[i].toString());
        }
    }

    @Override
    public void sapXepTenMon(){
        if(sql==0) {
            return ;
        }
        BangDiem[] arrBangDiem= (BangDiem[]) IOFile.doc(fbD,sql);
        Arrays.sort(arrBangDiem, (o1, o2) -> {
            String[] ten1=o1.getMonHoc().getTen().split("\\s+");
            String[] ten2=o2.getMonHoc().getTen().split("\\s+");
            if(ten1[ten1.length-1].equalsIgnoreCase(ten2[ten2.length-1])){
                return o1.getMonHoc().getTen().compareToIgnoreCase(o2.getMonHoc().getTen());
            }else{
                return ten1[ten1.length-1].compareToIgnoreCase(ten2[ten2.length-1]);
            }
        });
        for(int i=0;i<sql;i++){
            System.out.println(arrBangDiem[i].toString());
        }
    }

    @Override
    public void tinhDiemChoSinhVien(){
        if(sql==0) {
            return ;
        }
        BangDiem[] arrBangDiem= (BangDiem[]) IOFile.doc(fbD,sql);
        System.out.println("Ma\tSinh Vien \t\t\t Diem tong ket");

        Diem<BangDiem> diem= (ma1, arr) -> {
            float point=0;
            int stt=0;
            for (BangDiem bangDiem : arr) {
                if (bangDiem.getSinhVien().getMa() == ma1) {
                    point += bangDiem.getDiem()*bangDiem.getMonHoc().getSoDv();
                    stt += bangDiem.getMonHoc().getSoDv();
                }
            }
            if(stt==0){
                return 0;
            }
            return point/stt;
        };
        int[] ma=diem.groupingByMa(arrBangDiem,sql);

        float[] arrDiem= new float[ma.length];

        for (int i=0;i<ma.length;i++){
            arrDiem[i]=diem.tinhDiem(ma[i],arrBangDiem);
        }

        for(int i=0;i<ma.length;i++){
            System.out.println(ma[i]+"  "+getSvByMa(ma[i]).getTen()+"\t"+arrDiem[i]);
        }
    }
}
