package Collection_Generic_Java8.Util;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        return DataUtil.isNullOrEmpty(str) && str.trim().isEmpty();
    }
}
