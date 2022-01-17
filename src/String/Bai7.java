package String;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s1=sc.nextLine().toLowerCase();
        String s2=sc.nextLine().toLowerCase();
        if(s1.contains(s2)){
            s1=s1.replaceAll(s2,"");
            System.out.println(s1);
        }
        else {
            System.out.println("K tim thay");
        }
    }
}
