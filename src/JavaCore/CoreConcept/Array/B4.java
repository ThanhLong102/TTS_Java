package JavaCore.CoreConcept.Array;

import java.util.Scanner;

public class B4 {
    static boolean isPrime(int n) {
        if(n<2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int X=sc.nextInt();
        int[] a=new int[n];
        int min=10000000;
        int index=0;
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
            if(isPrime(a[i]) && Math.abs(X-a[i])<min){
                min=Math.abs(X-a[i]);
                index=i;
            }
        }
        System.out.println(index);

    }
}
