package Encapsulation_Inheritance.Model;


public class QLMuonSach {
    private BanDoc banDoc;

    private Sach sach;

    private int soluong;

    private String tinhTrang;

    public QLMuonSach(BanDoc banDoc, Sach sach, int soluong, String tinhTrang) {
        this.banDoc = banDoc;
        this.sach = sach;
        this.soluong = soluong;
        this.tinhTrang = tinhTrang;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "QLMuonSach{" +
                "banDoc=" + banDoc +
                ", sach=" + sach +
                ", soluong=" + soluong +
                ", tinhTrang='" + tinhTrang + '\'' +
                '}';
    }
}
