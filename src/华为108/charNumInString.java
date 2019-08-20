package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/20.
 */
public class charNumInString {
    /*
    * 题目描述
    * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
    * 输入描述:
    * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
    * 输出描述:
    * 输出输入字符串中含有该字符的个数。
    *
    * */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例
//        String s = "ABCDEF";
//        String c = "A";
//        System.out.println(charOfString(s, c));

// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String c = sc.next();


            System.out.println(charOfString(s, c));
        }


    }

    private static int charOfString(String s, String c) {
//        要求不区分大小写,那就用正则搞一下
        String pattern="(?i)"+c;
        return s.length()-s.replaceAll(pattern, "").length();
    }
}
