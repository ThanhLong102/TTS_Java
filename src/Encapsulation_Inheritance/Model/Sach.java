package Encapsulation_Inheritance.Model;


public class Sach {
    private int ma;

    private String ten,tacGia,chuyenNganh;

    private int nam;

    private static int sma=10000;

    public Sach(String ten, String tacGia, String chuyenNganh, int nam) {
        this.ma = sma++;
        this.ten = ten;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.nam = nam;
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

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Sach.sma = sma;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                ", nam=" + nam +
                '}';
    }
}
