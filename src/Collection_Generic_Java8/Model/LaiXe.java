package Collection_Generic_Java8.Model;

import Collection_Generic_Java8.Exception_File.DienThoaiException;
import Collection_Generic_Java8.Exception_File.LoaiException;
import Collection_Generic_Java8.Exception_File.TrongException;

import java.io.Serializable;

public class LaiXe implements Serializable {
    private int ma;

    private String ten, diaChi;

    private String sdt;

    private String trinhDo;

    private static int sma = 10000;

    public LaiXe(String ten, String diaChi, String sdt, String trinhDo) throws TrongException, DienThoaiException, LoaiException {
        if (ten.isEmpty() || diaChi.isEmpty()) throw new TrongException();
        if (!sdt.matches("\\d{10}")) throw new DienThoaiException();
        if (!trinhDo.matches("[A-Fa-f]")) throw new LoaiException();
        this.ma = sma++;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.trinhDo = trinhDo.toUpperCase();
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

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        LaiXe.sma = sma;
    }

    @Override
    public String toString() {
        return "LaiXe{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", trinhDo='" + trinhDo + '\'' +
                '}';
    }
}
