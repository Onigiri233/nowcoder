package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class converseSec {


    /**
     * 题目描述
     * 题目描述
     * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     * 输入描述:
     * 将一个英文语句以单词为单位逆序排放。
     * 输出描述:
     * 得到逆序的句子
     */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例
//        String s="I am a boy";
//        System.out.println(reverse(s));


// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(reverse(s));
        }
    }

    private static String reverse(String sentence) {
        String[] ss = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ss.length; i++) {
            sb.append(reverseString(ss[i]) + " ");
        }
        return reverseString(sb.toString()).trim();
    }

    private static String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
