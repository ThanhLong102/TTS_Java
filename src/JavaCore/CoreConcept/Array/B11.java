package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B11 {
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
        int m= sc.nextInt();
        int[][] a = new int[n][m];
        nhap(n,m,a);
        int min=1000000;
        int index=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for (int j=0;j<m;j++){
                sum+=a[i][j];
            }
            if(sum<min){
                min=sum;
                index=i;
            }
        }

        for(int i=index+1;i<n;i++){
            for (int j = 0; j < m; j++){
                a[i - 1][j] = a[i][j];
            }
        }

        show(n-1,m,a);
    }
}
