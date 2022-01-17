package String;

import java.util.Scanner;

public class Bai3 {
    static String chuanHoaXau(String s){
        s = s.trim();
        s = s.replaceAll("\\s+"," ");
        return (s.charAt(0) + "").toUpperCase() +
                s.substring(1).toLowerCase();
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println(chuanHoaXau(sc.nextLine()));
    }
}
