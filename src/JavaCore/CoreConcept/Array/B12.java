package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B12 {
    static Scanner sc= new Scanner(System.in);
    static void nhap(int m,int n,int[][] a){
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
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
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        nhap(n,n,a);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                b[n-1-j][i]=a[i][j];
            }
        }
        show(n,n,b);
    }
}
