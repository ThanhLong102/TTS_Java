package JavaCore.CoreConcept.Array;


import java.util.Arrays;
import java.util.Scanner;

public class B9 {
    static Scanner sc= new Scanner(System.in);
    static void nhap(int m,int n,int[][] a,int[] b){
        int dem=0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
                b[dem++]=a[i][j];
            }
        }
    }

    static void show(int m,int n,int[][] a){
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        int[] b=new int[m*n];
        nhap(m,n,a,b);

        Arrays.sort(b);
        int dem=0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                a[i][j]=b[dem++];
            }
        }
        show(m,n,a);
    }
}
