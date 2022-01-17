package String;


import java.util.Scanner;

public class Bai2 {
    static String chuyenDangXenKe(String s){
        StringBuilder newS= new StringBuilder();
        for (int i=0;i<s.length();i++){
            if(i%2==0){
                newS.append((s.charAt(i) + "").toUpperCase());
            }
            else {
                newS.append((s.charAt(i) + "").toLowerCase());
            }
        }
        return newS.toString();
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println(chuyenDangXenKe(sc.next()));
    }
}
