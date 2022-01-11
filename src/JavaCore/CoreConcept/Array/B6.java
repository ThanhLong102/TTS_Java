package JavaCore.CoreConcept.Array;

import java.util.Arrays;
import java.util.Scanner;

public class B6 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n+1];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int x= sc.nextInt();


        //Sap xep
        Arrays.sort(a);
        for(int i=1;i<=n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

        //Sau khi chen
        a[0]=x;
        Arrays.sort(a);
        for(int i=0;i<=n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
