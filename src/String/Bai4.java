package String;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai4 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s=sc.nextLine();
        StringTokenizer st= new StringTokenizer(s);
        int maxXau=0;
        String xauDaiNhat="";

        while (st.hasMoreTokens()){
            String tempS= st.nextToken();
            if(tempS.length()>maxXau){
                maxXau=tempS.length();
                xauDaiNhat=tempS;
            }
        }

        System.out.println("Tu dai nhat:"+xauDaiNhat+" xuat hien tai vi tri:"+s.indexOf(xauDaiNhat));

    }
}
