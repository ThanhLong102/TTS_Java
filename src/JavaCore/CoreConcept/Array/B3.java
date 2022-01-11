package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B3 {
    static int max= (int) 1e6;
    static int[] cnt=new int[max];

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];

        for(int i=0;i<max;i++){
            cnt[i]=0;
        }

        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
            cnt[a[i]]++;
        }

        int slXHLN=0;
        int ptuXHLN=0;
        for(int i=0;i<n;i++) {
            if(cnt[a[i]]>slXHLN){
                ptuXHLN=i;
                slXHLN=cnt[a[i]];
            }
        }

        for(int i=0;i<max;i++) {
            if(cnt[i]>0){
                System.out.println("So "+i+" xuat hien:"+cnt[i]);
            }
        }
        System.out.println("So "+a[ptuXHLN]+" xuat hien nhieu nhat");
    }
}
