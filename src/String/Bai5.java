package String;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split("\\s+");
        System.out.print(arr[arr.length-1]+" "+ arr[0]);
        for (int i = 1; i< arr.length-1; i++){
            System.out.print(" "+arr[i]);
        }
    }
}
