package Exception_JavaIO.Model;

import Exception_JavaIO.Exception.LoaiException;
import Exception_JavaIO.Exception.TrongException;

import java.io.Serializable;

public class MonHoc implements Serializable {
    private int ma;

    private String ten;

    private int soDv;

    private String loai;

    private static int sma=100;

    public MonHoc(String ten, int soDv, String loai) throws TrongException,LoaiException{
        if(ten.isEmpty()) throw new TrongException();
        loai=loai.toLowerCase();
        if(!loai.equalsIgnoreCase("dai cuong") && !loai.equalsIgnoreCase("co so nganh")
                && !loai.equalsIgnoreCase("chuyen nganh") ) throw new LoaiException();
        this.ma = sma++;
        this.ten = ten;
        this.soDv = soDv;
        this.loai = loai;
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

    public int getSoDv() {
        return soDv;
    }

    public void setSoDv(int soDv) {
        this.soDv = soDv;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
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
                ", soDv=" + soDv +
                ", loai='" + loai + '\'' +
                '}';
    }
}
