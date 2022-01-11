package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B10 {
    static boolean isPrime(int n) {
        if(n<2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean check(int n){
        while (n>0){
            if(!isPrime(n%10)){
                return false;
            }
            n/=10;
        }
        return true;
    }
    static int dao(String n){
        String s="";
        for (int i=n.length()-1;i>=0;i--){
            s+=n.charAt(i);
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=1000000;i<9999999;i++){
            if(isPrime(i) && check(i) && isPrime(dao(i+""))){
                System.out.print(i+" ");
            }
        }
    }
}
