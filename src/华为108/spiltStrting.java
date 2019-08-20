package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class spiltStrting {
    /**
     * 题目描述
     * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 输入描述:
     * 连续输入字符串(输入2次,每个字符串长度小于100)
     * 输出描述:
     * 输出到长度为8的新字符串数组
     */
    public static void main(String[] args) {
        // TODO: 2019/8/20  本地测试用例
        String s1 = "abc";
        String s2 = "123456789";
        printString8(string8split(s1), string8split(s2));


// TODO: 2019/8/20 网页端测试接口
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            printString8(string8split(s1), string8split(s2));
//        }
    }


    private static String[] string8split(String s) {
        int length = s.length();
        int lastSize = length % 8;
        int splitSize = length / 8;
        String[] string8;
//        按照是否有空串创建数组大小
        if (lastSize == 0) {
            string8 = new String[splitSize];
        } else {
            string8 = new String[splitSize + 1];
        }


        for (int i = 0; i < splitSize; i++) {
            string8[i] = s.substring(8 * i, 8 * (i + 1));
        }
        String substr = s.substring(8 * splitSize, length);

        for (int i = 0; i < 8 - lastSize; i++) {
            substr = substr + "0";
        }
        if (lastSize != 0) {
            string8[splitSize] = substr;
        }
        return string8;
    }

    private static void printString8(String[] strings1, String[] strings2) {
        for (String s : strings1
                ) {
            System.out.println(s);
        }
        for (String s : strings2
                ) {
            System.out.println(s);
        }
    }
}
