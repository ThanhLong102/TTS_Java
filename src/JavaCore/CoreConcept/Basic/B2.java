package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int soUoc=2;
        int i=2;
        System.out.print("Cac uoc cua "+n+":1 ");
        while(i<=n/2){
            if(n%i==0){
                System.out.print(i+" ");
                soUoc+=1;
            }
            i++;
        }
        System.out.println(n);
        System.out.println("So uoc cua "+n+":"+soUoc);
    }
}
