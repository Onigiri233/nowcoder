package 算法储备;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 正则表达式 {
    public static void main(String[] args) {
        String isOther = "[^0-9|a-z|A-Z|\\s]";
        String isNumber = "[0-9]";
        String isEnglish = "[a-z|A-Z]";
        String ipPattern ="^((1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.){3}" +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

    }
}
