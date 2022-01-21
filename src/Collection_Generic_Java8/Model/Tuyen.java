package Collection_Generic_Java8.Model;

import java.io.Serializable;

public class Tuyen implements Serializable {

    private int ma;

    private int khoangCach;

    private int soDiemDung;

    private static int sma = 100;

    public Tuyen(int khoangCach, int soDiemDung) {
        this.ma = sma++;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(int khoangCach) {
        this.khoangCach = khoangCach;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Tuyen.sma = sma;
    }

    @Override
    public String toString() {
        return "Tuyen{" +
                "ma=" + ma +
                ", khoangCach=" + khoangCach +
                ", soDiemDung=" + soDiemDung +
                '}';
    }
}
