package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B9 {
    static boolean check(int n){
        while (n>0){
            if(n%10!=0 && n%10!=6 && n%10!=8){
                return false;
            }
            n/=10;
        }
        return true;
    }

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
        for (int i=1000000;i<999999999;i++){
            if(soThuanNghich(i+"") && tongChuSo(i+"")%10==0 && check(i)){
                System.out.print(i+" ");
            }
        }
    }
}
