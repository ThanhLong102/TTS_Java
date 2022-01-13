package Encapsulation_Inheritance.Model;

public class BanDoc {
    private int ma;

    private String ten,diaChi,sdt,loaiBanDoc;

    private static int sma=10000;

    public BanDoc(String ten, String diaChi, String sdt, String loaiBanDoc) {
        this.ma = sma++;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.loaiBanDoc = loaiBanDoc;
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

    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    public void setLoaiBanDoc(String loaiBanDoc) {
        this.loaiBanDoc = loaiBanDoc;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        BanDoc.sma = sma;
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", loaiBanDoc='" + loaiBanDoc + '\'' +
                '}';
    }
}
