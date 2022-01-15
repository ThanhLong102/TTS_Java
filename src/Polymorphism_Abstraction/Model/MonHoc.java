package Polymorphism_Abstraction.Model;

public class MonHoc {
    private int ma;

    private String ten;

    private int tongSoTiet,soTietLyThuyet,mucKinhPhi;

    private static int sma=10000;

    public MonHoc( String ten, int tongSoTiet, int soTietLyThuyet, int mucKinhPhi) {
        this.ma = sma++;
        this.ten = ten;
        this.tongSoTiet = tongSoTiet;
        this.soTietLyThuyet = soTietLyThuyet;
        this.mucKinhPhi = mucKinhPhi;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getMucKinhPhi() {
        return mucKinhPhi;
    }

    public void setMucKinhPhi(int mucKinhPhi) {
        this.mucKinhPhi = mucKinhPhi;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        MonHoc.sma = sma;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", tongSoTiet=" + tongSoTiet +
                ", soTietLyThuyet=" + soTietLyThuyet +
                ", mucKinhPhi=" + mucKinhPhi +
                '}';
    }
}
