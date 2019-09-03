package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class 单词倒排 {


    /**
     * 题目描述
     * 对字符串中的所有单词进行倒排。
     * 说明：
     * 1、每个单词是以26个大写或小写英文字母构成；
     * 2、非构成单词的字符均视为单词间隔符；
     * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
     * 4、每个单词最长20个字母；
     */
    public static void main(String[] args) {
//        String s="$bo*y gi!r#l #";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(reverse(s));
        }
    }

    private static String reverse(String sentence) {
        String replace="[^a-z|A-Z]";
        sentence=sentence.replaceAll( replace," " );
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
