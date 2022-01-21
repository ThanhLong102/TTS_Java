package Collection_Generic_Java8.Model;

import java.io.Serializable;

public class PhanCong implements Serializable {

    private LaiXe laiXe;

    private Tuyen tuyen;

    private int luot;

    public PhanCong(LaiXe laiXe, Tuyen tuyen, int luot) {
        this.laiXe = laiXe;
        this.tuyen = tuyen;
        this.luot = luot;
    }

    public LaiXe getLaiXe() {
        return laiXe;
    }

    public void setLaiXe(LaiXe laiXe) {
        this.laiXe = laiXe;
    }

    public Tuyen getTuyen() {
        return tuyen;
    }

    public void setTuyen(Tuyen tuyen) {
        this.tuyen = tuyen;
    }

    public int getLuot() {
        return luot;
    }

    public void setLuot(int luot) {
        this.luot = luot;
    }

    public String getMaAndTenLaiXe() {
        return laiXe.getMa() + "\t" + laiXe.getTen();
    }

    public int tinhKhoangCach() {
        return luot * tuyen.getKhoangCach();
    }

    @Override
    public String toString() {
        return "PhanCong{" +
                "laiXe=" + laiXe +
                ", tuyen=" + tuyen +
                ", luot=" + luot +
                '}';
    }
}
