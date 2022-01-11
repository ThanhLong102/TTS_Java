package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B10 {
    static Scanner sc= new Scanner(System.in);
    static void nhap(int m,int n,int[][] a){
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        nhap(n,n,a);
        int tongChinh=0;
        int tongPhu=0;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(i==j){
                    tongChinh+=a[i][j];
                }
                if(j==n-i-1){
                    tongPhu+=a[i][j];
                }
            }
        }
        System.out.println("Tong phan tu duong cheo chinh:"+tongChinh +" ,Tong phan tu duong cheo phu:"+tongPhu);
    }
}
