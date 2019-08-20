package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class converseBin {
    /**
     * 题目描述
     * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
     * 输入描述:
     * 输入一个十六进制的数值字符串。
     * 输出描述:
     * 输出该数值的十进制字符串。
     */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例
//        String s = "0xA";
//        System.out.println(OxtoDe(s));


// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(OxtoDe(s));
        }
    }

    private static String OxtoDe(String s) {
        if(s.startsWith("0x")){
            s=s.substring(2);
        }
        return Integer.valueOf(s,16).toString();
    }
}
