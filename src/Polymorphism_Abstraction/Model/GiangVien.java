package Polymorphism_Abstraction.Model;

public class GiangVien {
    private int ma;

    private String ten,diaChi,sdt,trinhdo;

    private static int sma=100;

    public GiangVien(String ten, String diaChi, String sdt, String trinhdo) {
        this.ma = sma++;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trinhdo = trinhdo;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        GiangVien.sma = sma;
    }

    @Override
    public String toString() {
        return "GiangVien{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", trinhdo='" + trinhdo + '\'' +
                '}';
    }
}
