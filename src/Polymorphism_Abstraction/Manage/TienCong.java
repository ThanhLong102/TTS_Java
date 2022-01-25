package Polymorphism_Abstraction.Manage;

import Polymorphism_Abstraction.Model.KeKhaiGiangDay;

@FunctionalInterface
public interface TienCong<T> {
    float tinhTien(int ma, T[] arr);

    default int[] groupingByMa(KeKhaiGiangDay[] arr, int sql) {
        int[] ma = new int[sql];
        int soGv = 0;
        for (int i = 0; i < sql; i++) {
            boolean check = true;
            for (int j = 0; j < soGv; j++) {
                if (ma[j] == arr[i].getGiangVien().getMa()) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ma[soGv++] = arr[i].getGiangVien().getMa();
            }
        }
        int[] maTempt = new int[soGv];
        System.arraycopy(ma, 0, maTempt, 0, soGv);
        ma = maTempt;
        return ma;
    }


}
