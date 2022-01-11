package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B8 {
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

        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] a = new int[m][n];
        int[][] b = new int[n][k];
        int[][] c = new int[m][k];
        nhap(m, n, a);
        nhap(n, k, b);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                c[i][j] = 0;
                for (int l = 0; l < n; l++) {
                    c[i][j] = c[i][j] + a[i][l] * b[l][j];
                }
            }
        }
        show(m,k,c);
    }
}
