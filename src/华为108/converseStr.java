package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class converseStr {

    /**
     * 题目描述
     * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
     * 输入描述:
     * 输入N个字符
     * 输出描述:
     * 输出该字符串反转后的字符串
     */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例
//        String s="abcd";
//        System.out.println(reverseString(s));


// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(reverseString(s));
        }
    }

    private static String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
