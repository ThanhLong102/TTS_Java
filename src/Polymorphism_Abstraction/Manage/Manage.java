package Polymorphism_Abstraction.Manage;

import Polymorphism_Abstraction.Model.GiangVien;
import Polymorphism_Abstraction.Model.KeKhaiGiangDay;
import Polymorphism_Abstraction.Model.MonHoc;

import java.util.Scanner;

public class Manage implements IManage {
    private final Scanner sc = new Scanner(System.in);
    private int sgv = 0;
    private int sm = 0;
    private int sql = 0;
    private GiangVien[] giangViens;
    private MonHoc[] monHocs;
    private KeKhaiGiangDay[] keKhaiGiangDays;

    private static Manage Instance;

    private Manage() {
    }

    public static Manage getInstance() {
        if (Instance == null) {
            Instance = new Manage();
        }
        return Instance;
    }

    @Override
    public void nhapMonHoc() {
        System.out.println("Nhap ten mon:");
        String ten = sc.nextLine();
        System.out.println("Nhap tong so tiet:");
        int st = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so tiet ly thuyet:");
        int stlt = Integer.parseInt(sc.nextLine());
        System.out.println("Muc kinh phi:");
        int kp = Integer.parseInt(sc.nextLine());
        if (stlt > st) {
            System.out.println("So tiet ly thuyet k lon hon tong so tiet");
            return;
        }
        MonHoc monHoc = new MonHoc(ten, st, stlt, kp);
        MonHoc[] temptMonHocs = new MonHoc[sm + 1];
        if (monHocs != null) {
            System.arraycopy(monHocs, 0, temptMonHocs, 0, sm);
        }
        monHocs = temptMonHocs;
        monHocs[sm] = monHoc;
        sm++;

        for (int i = 0; i < sm; i++) {
            System.out.println(monHocs[i].toString());
        }
    }

    @Override
    public void nhapGiangVien() {
        System.out.println("Nhap Ho va ten:");
        String ten = sc.nextLine();
        System.out.println("Nhap dia chi:");
        String diachi = sc.nextLine();
        System.out.println("Nhap so dien thoai (chi nhap so):");
        String sdt = sc.nextLine();
        System.out.println("Nhap trinh do (GS-TS, PGS-TS, Giảng viên chính, Thạc sỹ):");
        String td = sc.nextLine();
        GiangVien giangVien = new GiangVien(ten, diachi, sdt, td);
        GiangVien[] temptGvs = new GiangVien[sgv + 1];
        if (giangViens != null) {
            System.arraycopy(giangViens, 0, temptGvs, 0, sgv);
        }
        giangViens = temptGvs;
        giangViens[sgv] = giangVien;
        sgv++;

        for (int i = 0; i < sgv; i++) {
            System.out.println(giangViens[i].toString());
        }
    }

    public MonHoc getMonHocByMa(int ma) {
        for (int i = 0; i < sm; i++) {
            if (monHocs[i].getMa() == ma) {
                return monHocs[i];
            }
        }
        return null;
    }

    public GiangVien getGvByMa(int ma) {
        for (int i = 0; i < sgv; i++) {
            if (giangViens[i].getMa() == ma) {
                return giangViens[i];
            }
        }
        return null;
    }

    public boolean trungMa(int magv, int mam) {
        for (int i = 0; i < sql; i++) {
            if (keKhaiGiangDays[i].getGiangVien().getMa() == magv && keKhaiGiangDays[i].getMonHoc().getMa() == mam) {
                return true;
            }
        }
        return false;
    }

    public KeKhaiGiangDay getKeKhaiByMaGvAndMaM(int maGv, int maM) {
        for (int i = 0; i < sql; i++) {
            if (keKhaiGiangDays[i].getGiangVien().getMa() == maGv && keKhaiGiangDays[i].getMonHoc().getMa() == maM) {
                return keKhaiGiangDays[i];
            }
        }
        return null;
    }

    public int demSoTiet(int maB) {
        int sum = 0;
        for (int i = 0; i < sql; i++) {
            if (keKhaiGiangDays[i].getGiangVien().getMa() == maB) {
                sum = sum + keKhaiGiangDays[i].getSoLop() * keKhaiGiangDays[i].getMonHoc().getTongSoTiet();
            }
        }
        return sum;
    }

    public void swapKeKhai(int i, int j) {
        KeKhaiGiangDay tempKeKhaiGiangDay = keKhaiGiangDays[i];
        keKhaiGiangDays[i] = keKhaiGiangDays[j];
        keKhaiGiangDays[j] = tempKeKhaiGiangDay;
    }

    @Override
    public void nhapQlGiangDay() {
        System.out.println("Nhap ma Giang Vien:");
        int maGv = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ma Mon:");
        int maM = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap so lop:");
        int sl = Integer.parseInt(sc.nextLine());
        if (getGvByMa(maGv) == null || getMonHocByMa(maM) == null) {
            System.out.println("Kiem tra lai ma Gv(ma mon hoc)");
            return;
        }
        if (trungMa(maGv, maM)) {
            if (getKeKhaiByMaGvAndMaM(maGv, maM).getSoLop() + sl > 3) {
                System.out.println("Trung mon da day(da day du lop)");
                return;
            }
            else {
                getKeKhaiByMaGvAndMaM(maGv, maM).setSoLop(getKeKhaiByMaGvAndMaM(maGv, maM).getSoLop()+sl);
                System.out.println("Da cap nhat them lop day");
                return;
            }
        }
        if (sl > 3) {
            System.out.println("Day qua 3 lop");
            return;
        }
        if (demSoTiet(maGv) + sl * getMonHocByMa(maM).getTongSoTiet() > 200) {
            System.out.println("Day qua 200 tiet");
            return;
        }

        KeKhaiGiangDay ql = new KeKhaiGiangDay(getGvByMa(maGv), getMonHocByMa(maM), sl);
        KeKhaiGiangDay[] temptQl = new KeKhaiGiangDay[sql + 1];
        if (keKhaiGiangDays != null) {
            System.arraycopy(keKhaiGiangDays, 0, temptQl, 0, sql);
        }
        keKhaiGiangDays = temptQl;
        keKhaiGiangDays[sql] = ql;
        sql++;
        for (int i = 0; i < sql; i++) {
            System.out.println(keKhaiGiangDays[i].toString());
        }
    }

    @Override
    public void sapXepTenGv() {
        for (int i = 0; i < sql - 1; i++) {
            for (int j = i + 1; j < sql; j++) {
                if (keKhaiGiangDays[i].getGiangVien().getTen().compareToIgnoreCase(
                        keKhaiGiangDays[j].getGiangVien().getTen()) > 0) {
                    swapKeKhai(i, j);
                }
            }
        }

        for (int i = 0; i < sql; i++) {
            System.out.println(keKhaiGiangDays[i].toString());
        }
    }

    @Override
    public void sapXepSoTietGiangDay() {
        for (int i = 0; i < sql - 1; i++) {
            for (int j = i + 1; j < sql; j++) {
                if (keKhaiGiangDays[j].getMonHoc().getTongSoTiet() -
                        keKhaiGiangDays[i].getMonHoc().getTongSoTiet() > 0) {
                    swapKeKhai(i, j);
                }
            }
        }

        for (int i = 0; i < sql; i++) {
            System.out.println(keKhaiGiangDays[i].toString());
        }
    }

    @Override
    public void tinhTienCongChoMoiGiangVien() {
        System.out.println("Ma\tGiang Vien \t\t\t Tong so tien cong");

        TienCong<KeKhaiGiangDay> tienCong = (ma1, arr) -> {
            float tien = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].getGiangVien().getMa() == ma1) {
                    tien += (float) (keKhaiGiangDays[i].getSoLop() * keKhaiGiangDays[i].getMonHoc().getMucKinhPhi()
                            * (keKhaiGiangDays[i].getMonHoc().getSoTietLyThuyet()
                            + (keKhaiGiangDays[i].getMonHoc().getTongSoTiet() - keKhaiGiangDays[i].getMonHoc().getSoTietLyThuyet()) * 0.7));
                }
            }
            return tien;
        };
        int[] ma = tienCong.groupingByMa(keKhaiGiangDays, sql);

        float[] tienLuong = new float[ma.length];

        for (int i = 0; i < ma.length; i++) {
            tienLuong[i] = tienCong.tinhTien(ma[i], keKhaiGiangDays);
        }

        for (int i = 0; i < ma.length; i++) {
            System.out.println(ma[i] + "  " + getGvByMa(ma[i]).getTen() + "\t" + tienLuong[i]);
        }
    }
}
