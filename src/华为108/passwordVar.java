package 华为108;

/**
 * Created by fantuan on 2019/8/27.
 */
import java.util.Scanner;
import java.util.regex.Pattern;

public class passwordVar {
    /*
     * 题目描述
     * 密码要求:
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有相同长度超2的子串重复
     * 说明:长度超过2的子串
     * 输入描述:
     * 一组或多组长度超过2的子符串。每组占一行
     * 输出描述:
     * 如果符合要求输出：OK，否则输出NG
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(varPassword(s));
        }
        sc.close();
    }

    private static String varPassword(String s) {
        if (s == null || s.length() <= 8) {
            return "NG";
        } else if (hasThreeKinds(s) && !hasSubString(s)){
            return "OK";
        }else {
            return "NG";
        }
    }

    private static boolean hasSubString(String s) {
        for(int i=0;i<s.length()-3;i++){
            if(s.substring(i+3).contains(s.substring(i,i+3)))
                return true;
        }
        return false;
    }

    private static boolean hasThreeKinds(String s) {
        int count = 0;
        String[] patten = {"[a-z]", "[A-Z]", "[0-9]", "[^a-zA-Z0-9]"};
        for (int i = 0; i < patten.length; i++) {
            if (Pattern.compile(patten[i]).matcher(s).find()) {
                count++;
            }
        }
        return count >= 3;
    }
}

