package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B5 {
    static int tongChuSo(String s){
        int sum=0;
        for (int i=0;i<s.length();i++){
            sum+= Integer.parseInt(s.charAt(i)+"") ;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        System.out.println(tongChuSo(s));
    }
}
