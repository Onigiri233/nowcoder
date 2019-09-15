package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 计负数均正数 {
    /**
     * 题目描述
     * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
     * 输入描述:
     * 首先输入一个正整数n，
     * 然后输入n个整数。
     * 输出描述:
     * 输出负数的个数，和所有正整数的平均值。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nInt = sc.nextLine();
            int n = Integer.parseInt(nInt);
            int[] nNums = new int[n];
            for (int i = 0; i < n; i++) {
                nNums[i] = sc.nextInt();
            }
            jishu(nNums);

        }
        sc.close();
    }

    private static void jishu(int[] nNums) {
        int fushu = 0;
        int zero = 0;
        double pingjun = 0;
        for (int i = 0; i < nNums.length; i++) {
            if (nNums[i] < 0) {
                fushu++;
            } else if (nNums[i] >0){
                pingjun += nNums[i];
            }else {
                zero++;
            }
        }
        pingjun=pingjun/(nNums.length-fushu-zero);

        System.out.println(fushu+" "+String.format("%.1f",pingjun));
    }
}
