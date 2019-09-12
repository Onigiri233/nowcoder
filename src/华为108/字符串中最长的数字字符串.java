package 华为108;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 字符串中最长的数字字符串 {
    /**
     * 题目描述
     * 样例输出
     * 输出123058789，函数返回值9
     * 输出54761，函数返回值5
     * 连续最长的数字串，如果连续最长的数字串的长度为0，应该返回空字符串；如果输入字符串是空，也应该返回空字符串；
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(longestNumString(s));
        }
        sc.close();
    }

    private static String longestNumString(String s) {
        StringBuffer sb = new StringBuffer();
//        DP
//        int[] dp = new int[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            if ((s.charAt(i) + "").matches("[0-9]")) {
//                dp[i] = 1;
//            } else {
//                dp[i] = 0;
//            }
//        }
//        for (int i = 1; i < s.length(); i++) {
//            if (dp[i] == 1) {
//                dp[i] = dp[i - 1] + 1;
//            }
//        }
//        System.out.println(Arrays.toString(dp));

        String[] ss = s.replaceAll("[^0-9]", " ").split(" ");
        int maxLength = 0;
        for (String x : ss) {
            if (x.length() > maxLength) {
                maxLength = x.length();
            }
        }
        for (String x : ss) {
            if (x.length() == maxLength) {
                sb.append(x);
            }
        }
        sb.append("," + maxLength);
        return sb.toString();
    }
}
