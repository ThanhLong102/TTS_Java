package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B1 {
    static boolean mangdoixung(int n,int[] a){
        for(int i=0;i<=n/2;i++){
            if(a[i]!=a[n-1-i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        if(mangdoixung(n,a)){
            System.out.println("Co");
        }
        else {
            System.out.println("Khong");
        }

    }
}
