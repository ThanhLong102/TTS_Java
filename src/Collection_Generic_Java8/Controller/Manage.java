package Collection_Generic_Java8.Controller;

import Collection_Generic_Java8.Exception_File.*;
import Collection_Generic_Java8.Model.LaiXe;
import Collection_Generic_Java8.Model.PhanCong;
import Collection_Generic_Java8.Model.Tuyen;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Manage implements Manageable {
    private final Scanner sc = new Scanner(System.in);
    private final String flx = "./src/Collection_Generic_Java8/Exception_File/LAIXE.dat";
    private final String ft = "./src/Collection_Generic_Java8/Exception_File/TUYEB.dat";
    private final String fpc = "./src/Collection_Generic_Java8/Exception_File/PHANCONG.dat";
    private List<LaiXe> laiXeList;
    private List<Tuyen> tuyenList;
    private List<PhanCong> phanCongList;

    private static Manage Instance;

    private Manage() {
    }

    public static Manage getInstance() {
        if (Instance == null) {
            Instance = new Manage();
        }
        return Instance;
    }

    public void loadLaiXe() {
        File f = new File(flx);
        if (f.exists()) {
            laiXeList = IOFile.doc(flx);
        } else {
            laiXeList = new ArrayList<>();
        }
    }

    public void loadTuyen() {
        File f = new File(ft);
        if (f.exists()) {
            tuyenList = IOFile.doc(ft);
        } else {
            tuyenList = new ArrayList<>();
        }
    }

    public void loadPhanCong() {
        File f = new File(fpc);
        if (f.exists()) {
            phanCongList = IOFile.doc(fpc);
        } else {
            phanCongList = new ArrayList<>();
        }
    }

    @Override
    public void nhapLaiXe() {
        try {
            System.out.println("Nhap ho ten:");
            String ten = sc.nextLine();
            System.out.println("Nhap dia chi:");
            String dc = sc.nextLine();
            System.out.println("Nhap so dien thoai");
            String soDt = sc.nextLine();
            System.out.println("Nhap trinh do(Loai A->F)");
            String loai = sc.nextLine();

            loadLaiXe();

            LaiXe laiXe = new LaiXe(ten, dc, soDt, loai);
            laiXeList.add(laiXe);

            IOFile.viet(flx, laiXeList);

        } catch (LoaiException e) {
            System.out.println("Nhap sai loai");
        } catch (TrongException e) {
            System.out.println("Vui long khong de trong");
        } catch (DienThoaiException e) {
            System.out.println("Nhap dien thoai gom 10 so");
        }

        for (LaiXe i : laiXeList) {
            System.out.println(i.toString());
        }
    }

    @Override
    public void nhapTuyen() {
        try {
            System.out.println("Nhap khoang cach:");
            int kc = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap so diem dung:");
            int dd = Integer.parseInt(sc.nextLine());

            loadTuyen();

            Tuyen tuyen = new Tuyen(kc, dd);
            tuyenList.add(tuyen);

            IOFile.viet(ft, tuyenList);

        } catch (NumberFormatException e) {
            System.out.println("Vui long chi nhap so");
        }

        for (Tuyen i : tuyenList) {
            System.out.println(i.toString());
        }
    }

    public LaiXe getLaiXecByMa(int ma) {
        loadLaiXe();
        for (LaiXe i : laiXeList)
            if (i.getMa() == ma) return i;
        return null;
    }

    public Tuyen getTuyenByMa(int ma) {
        loadTuyen();
        for (Tuyen i : tuyenList)
            if (i.getMa() == ma) return i;
        return null;
    }

    public boolean trungMa(int maLx, int maT) {
        loadPhanCong();
        for (PhanCong i : phanCongList)
            if (i.getLaiXe().getMa() == maLx && i.getTuyen().getMa() == maT)
                return true;
        return false;
    }

    public int demLuotByMa(int maLx) {
        loadPhanCong();
        int luot = 0;
        for (PhanCong i : phanCongList)
            if (i.getLaiXe().getMa() == maLx)
                luot += i.getLuot();
        return luot;
    }


    @Override
    public void nhapPhanCong() {
        try {
            System.out.println("Nhap ma Lai Xe:");
            int maLx = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap ma Tuyen:");
            int maT = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap luot:");
            int luot = Integer.parseInt(sc.nextLine());
            if (trungMa(maLx, maT)) {
                System.out.println("Trung mon da day");
                return;
            }
            if (getLaiXecByMa(maLx) == null || getTuyenByMa(maT) == null) {
                System.out.println("Kiem tra lai ma Lai xe(ma tuyen)");
                return;
            }
            if (demLuotByMa(maLx) + luot > 15) {
                System.out.println("Khong vuot qua 15 luot");
                return;
            }

            loadPhanCong();
            PhanCong phanCong = new PhanCong(getLaiXecByMa(maLx), getTuyenByMa(maT), luot);
            phanCongList.add(phanCong);

            IOFile.viet(fpc, phanCongList);

        } catch (NumberFormatException e) {
            System.out.println("Chi nhap so");
        }

        for (PhanCong i : phanCongList)
            System.out.println(i.toString());
    }

    @Override
    public void sapXepTenLaiXe() {
        loadPhanCong();
        phanCongList.sort((o1, o2) -> {
            String[] ten1 = o1.getLaiXe().getTen().split("\\s+");
            String[] ten2 = o2.getLaiXe().getTen().split("\\s+");
            if (ten1[ten1.length - 1].equalsIgnoreCase(ten2[ten2.length - 1])) {
                return o1.getLaiXe().getTen().compareToIgnoreCase(o2.getLaiXe().getTen());
            } else {
                return ten1[ten1.length - 1].compareToIgnoreCase(ten2[ten2.length - 1]);
            }
        });
        for (PhanCong i : phanCongList)
            System.out.println(i.toString());
    }

    @Override
    public void sapXepLuot() {
        loadTuyen();
        phanCongList.sort(Comparator.comparingInt(PhanCong::getLuot));
        for (PhanCong i : phanCongList)
            System.out.println(i.toString());
    }

    @Override
    public void thongKeKhoangCachChayXe() {
        loadPhanCong();
        Map<String, Integer> o = phanCongList.stream().collect(Collectors.
                groupingBy(PhanCong::getMaAndTenLaiXe, Collectors.summingInt(PhanCong::tinhKhoangCach)));
        System.out.println("Ma lai xe-Lai xe\tTong so khoang cach");
        o.forEach((K, V) -> System.out.println(K + "\t" + V));
    }
}
