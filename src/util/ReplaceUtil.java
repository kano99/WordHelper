package util;

/**
 * @author Kano
 * @createTime 24 16:20
 * @description
 */
public class ReplaceUtil {

    public static String doReplace(String input, String origin, String replace) {
        //String.replace()方法不会改变原字符串，而是返回一个新的字符串
        return input.replace(origin,replace);
    }
}
