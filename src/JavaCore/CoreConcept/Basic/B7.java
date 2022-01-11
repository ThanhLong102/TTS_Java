package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B7 {
    static boolean checkLe(int n){
        while (n>0){
            if(n%10%2==0){
                return false;
            }
            n/=10;
        }
        return true;
    }

    static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=100000;i<999999;i++){
            if(checkLe(i) && isPrime(i)){
                System.out.println(i+" ");
            }
        }
    }
}
