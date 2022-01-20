package Exception_JavaIO.Manage;

import Exception_JavaIO.Model.BangDiem;

@FunctionalInterface
public interface Diem<T> {
    float tinhDiem(int ma, T[] arr);

    default int[] groupingByMa(BangDiem[] arr, int sql){
        int[] ma = new int[sql];
        int soSv=0;
        for(int i=0;i<sql;i++){
            boolean check=true;
            for(int j=0;j<soSv;j++){
                if(ma[j] == arr[i].getSinhVien().getMa()){
                    check=false;
                    break;
                }
            }
            if(check){
                ma[soSv++]=arr[i].getSinhVien().getMa();
            }
        }
        int[] maTempt = new int[soSv];
        System.arraycopy(ma,0,maTempt,0,soSv);
        ma=maTempt;
        return ma;
    }
}
