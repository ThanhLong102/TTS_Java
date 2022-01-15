package Polymorphism_Abstraction.Model;


public class KeKhaiGiangDay {
    private GiangVien giangVien;

    private MonHoc monHoc;

    private int soLop;

    public KeKhaiGiangDay(GiangVien giangVien, MonHoc monHoc, int soLop) {
        this.giangVien = giangVien;
        this.monHoc = monHoc;
        this.soLop = soLop;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public int getSoLop() {
        return soLop;
    }

    public void setSoLop(int soLop) {
        this.soLop = soLop;
    }

    @Override
    public String toString() {
        return "KeKhaiGiangDay{" +
                "giangVien=" + giangVien +
                ", monHoc=" + monHoc +
                ", soLop=" + soLop +
                '}';
    }
}

