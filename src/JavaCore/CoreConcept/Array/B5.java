package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n+m];
        int[] b= new int[m];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }

        int p= sc.nextInt();

        for (int i=n-1;i>=p;i--){
            a[i+m]=a[i];
        }

        int j=0;
        for(int i=p;i<p+m;i++){
            a[i]=b[j++];
        }
        for(int i=0;i<m+n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
