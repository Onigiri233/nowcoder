package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/20.
 */
public class lastWordLength {
    /*
    * 题目描述
    * 计算字符串最后一个单词的长度，单词以空格隔开。
    * 输入描述:
    * 一行字符串，非空，长度小于5000。
    * 输出描述:
    * 整数N，最后一个单词的长度。
    * */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例
//        String s = "ABSIB T";
//        System.out.println(lastWordLength(s));

// TODO: 2019/8/20 网页端测试接口
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();

            System.out.println(lastWordLength(s));
        }


    }

    private static int lastWordLength(String string) {
        String s[] = string.split(" ");
        return s[s.length - 1].length();
    }
}
