package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 分割字符串 {
    /**
     * 前面有道很像的题
     * <p>
     * <p>
     * 题目描述
     * 连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
     * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 输入描述:
     * 首先输入数字n，表示要输入多少个字符串。连续输入字符串(输出次数为N,字符串长度小于100)。
     * 输出描述:
     * 按长度为8拆分每个字符串后输出到新的字符串数组，长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nInt = sc.nextLine();
            int n = Integer.parseInt(nInt);
            for (int i = 0; i < n; i++) {
                printString8(sc.nextLine());
            }
        }
        sc.close();
    }


    private static void printString8(String s) {
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
        for (String sss : string8) {
            System.out.println(sss);
        }
    }
}
