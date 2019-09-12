package 华为108;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 计负数均正数2 {
    /**
     * 题目描述
     * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值
     * 输入描述:
     * 输入任意个整数
     * 输出描述:
     * 输出负数个数以及所有非负数的平均值
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            list.add(n);
        }
        sc.close();
        jishu(list);

    }

    private static void jishu(ArrayList<Integer> list) {
        int fushu = 0;
        double pingjun = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                fushu++;
            } else {
                pingjun += list.get(i);
            }
        }
        pingjun=pingjun/(list.size()-fushu);

        System.out.println(fushu);
        System.out.println(String.format("%.1f",pingjun));
    }
}
