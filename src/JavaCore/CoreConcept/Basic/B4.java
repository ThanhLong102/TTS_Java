package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B4 {
    static boolean isCoprime(int n, int m){
        while(n!=m){
            if(n>m){
                n=n-m;
            }
            else{
                m=m-n;
            }
        }
        if(m==1) {
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        for(int i=a;i<b;i++){
            for(int j=i+1;j<=b;j++){
                if(isCoprime(i,j)){
                    System.out.print("("+i+","+j+") ");
                }
            }
        }
    }
}
