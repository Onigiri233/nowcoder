package 华为108;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by fantuan on 2019/8/21.
 */
public class diffCharInString {
    /**
     * 题目描述
     * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
     * 输入描述:
     * 输入N个字符，字符在ACSII码范围内。
     * 输出描述:
     * 输出范围在(0~127)字符的个数。
     */
    public static void main(String[] args) {
        // TODO: 2019/8/20  本地测试用例
//        String s = "abc";
//        System.out.println(getDiffCharNum(s));

// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(getDiffCharNum(s));
        }
    }

    private static int getDiffCharNum(String s) {
        Set set = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 0 && s.charAt(i) <= 127) {
                set.add(s.charAt(i));
            }

        }
        return set.size();
    }
}
