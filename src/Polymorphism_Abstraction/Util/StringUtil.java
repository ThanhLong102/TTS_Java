package Polymorphism_Abstraction.Util;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return DataUtil.isNullOrEmpty(str) && str.trim().isEmpty();
    }
}
