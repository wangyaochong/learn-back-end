package util;

public class UtilLog {
    private static final String prefix = ":::";

    /**
     * 这个方法主要是用于给日志加前缀，结合使用grep console，可以更快定位日志打印
     *
     * @param logString
     * @return
     */
    public static String prefixLog(String logString) {
        return prefix + logString;
    }
}
