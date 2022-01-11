package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int temp=n;
        int i=2;
        System.out.print(n+"=");
        while (i<=n){
            if(temp%i==0){
                temp/=i;
                if(temp!=1){
                    System.out.print(i+"x");
                }
                else {
                    System.out.print(i);
                }
            }
            else {
                i++;
            }
        }
    }
}
