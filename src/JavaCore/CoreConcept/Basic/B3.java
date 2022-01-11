package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int m=a;
        int n=b;
        while(n!=m){
            if(n>m){
                n=n-m;
            }
            else{
                m=m-n;
            }
        }
        long boi=(long) a*b/n;
        System.out.println("UCLN:"+n+", BCNN:"+boi);
    }
}
