package String;

import java.util.Arrays;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split("\\s+");
        Arrays.sort(arr, String::compareTo);
        for (String i: arr) {
            System.out.println(i);
        }
    }
}
