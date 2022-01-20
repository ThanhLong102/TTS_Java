package Exception_JavaIO.Model;

import Exception_JavaIO.Exception.DiemException;

import java.io.Serializable;

public class BangDiem implements Serializable {

    private SinhVien sinhVien;

    private MonHoc monHoc;

    private float diem;

    public BangDiem(SinhVien sinhVien, MonHoc monHoc, float diem)throws DiemException {
        if(diem>10 && diem<0) throw new DiemException();
        this.sinhVien = sinhVien;
        this.monHoc = monHoc;
        this.diem = diem;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "BangDiem{" +
                "sinhVien=" + sinhVien +
                ", monHoc=" + monHoc +
                ", diem=" + diem +
                '}';
    }
}
