package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class converseInt {
    /**
     * 题目描述
     * 描述：
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     * <p>
     * 输入描述:
     * 输入一个int整数
     * 输出描述:
     * 将这个整数以字符串的形式逆序输出
     */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例
//        int n=1516000;
//        System.out.println(reverseInt(n));


// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(reverseInt(n));
        }
    }

    private static String reverseInt(int n) {
        String s=String.valueOf(n);
        StringBuffer sb = new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
