package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class newReveInt {
    /**
     * 题目描述
     * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 输入描述:
     * 输入一个int型整数
     * 输出描述:
     * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
     */
    public static void main(String[] args) {
        // TODO: 2019/8/20  本地测试用例
//        int n = 9876673;
//        System.out.println(getNewReveInt(n));

// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(getNewReveInt(n));
        }
    }

    private static int getNewReveInt(int n) {
        String oldInt,newInt="";
        oldInt=Integer.valueOf(n).toString();
        for (int i = oldInt.length(); i >0 ; i--) {
            if (!newInt.contains(oldInt.subSequence(i-1,i))){
                newInt=newInt+oldInt.charAt(i-1);
            }
        }
        return Integer.valueOf(newInt);
    }
}
