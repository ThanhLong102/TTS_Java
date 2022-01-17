package String;


public class Bai1 {
    static boolean ktSoThuanNghich(String s){
        for (int i=0;i<=s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i=100000;i<=999999;i++){
            if(ktSoThuanNghich(i+"")){
                System.out.println(i);
            }
        }
    }
}
