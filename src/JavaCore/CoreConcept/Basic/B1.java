package JavaCore.CoreConcept.Basic;

import java.util.Scanner;

public class B1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();

        //a
        int sum=0;
        if(n%2 == 1){
            for (int i=1;i<=n;i++){
                sum+=i++;
            }
        }
        else {
            for (int i=2;i<=n;i++){
                sum+=i++;
            }
        }
        System.out.println("Bai 1:a. "+sum);

        //b
        float s=0;
        for(int i=1;i<=n;i++){
            s+=(float)1/i;
        }
        System.out.println("Bai 1:b. "+s);
    }
}
