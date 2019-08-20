package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class floatToInt {
    /**
     * 题目描述
     * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
     * 输入描述:
     * 输入一个正浮点数值
     * 输出描述:
     * 输出该数值的近似整数值
     */
    public static void main(String[] args) {
        // TODO: 2019/8/20  本地测试用例
//        double d = 5.5;
//        System.out.println(doubleTrim(d));


// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double d = sc.nextDouble();
            System.out.println(doubleTrim(d));
        }
    }

    private static int doubleTrim(double d) {
               double decimal=d-Math.floor(d);
        if (decimal>=0.5){
            return (int)Math.ceil(d);
        }else {
            return (int)Math.floor(d);
        }
    }

}
