package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B7 {
    static void duongdainhat(int[] a, int n){
        int[] b= new int[100];
        int max=0;
        int index=0;
        for(int i=0;i<n;i++) {
            b[i]=1;
            for(int j=i;j<n-1;j++) {
                if(a[j]<=a[j+1]) {
                    b[i]++;
                }
                if(a[j]>a[j+1]) break;
            }
            if(b[i]>max){
                index=i;
                max=b[i];
            }
        }
        System.out.println("Do dai nhat o vi tri "+index+" la "+b[index]);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        duongdainhat(a,n);
    }
}
