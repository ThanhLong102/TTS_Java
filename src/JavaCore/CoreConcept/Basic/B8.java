package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B8 {
    static boolean soThuanNghich(String n){
        for(int i=0;i<=n.length()/2;i++){
            if(n.charAt(i) != n.charAt(n.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    static int tongChuSo(String s){
        int sum=0;
        for (int i=0;i<s.length();i++){
            sum+= Integer.parseInt(s.charAt(i)+"") ;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //a
        for (int i=100000;i<999999;i++){
            if(soThuanNghich(i+"")){
                System.out.print(i+" ");
            }
        }

        System.out.println();
        System.out.println("So co sau chu so la nguyen to chia het cho 10:");
        //b
        for (int i=100000;i<999999;i++){
            if(soThuanNghich(i+"") && tongChuSo(i+"")%10==0){
                System.out.print(i+" ");
            }
        }
    }
}
