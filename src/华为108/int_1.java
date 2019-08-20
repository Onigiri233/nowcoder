package 华为108;


import com.sun.tools.javac.util.Convert;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/20.
 */
public class int_1 {
    /*
    *题目描述
    * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
    * 输入描述:
    * 输入一个整数（int类型） 有负数
    * 输出描述:
    * 这个数转换成2进制后，输出1的个数
    *
    * */
    public static void main(String[] args) {
//        int n = 5;
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
//        System.out.println("十进制" + n + "转为二进制" + Integer.toString(n, 2));
//        System.out.println(intToBin_1(n));
//        System.out.println(intToBin_2(n));
            System.out.println(intToBin_3(n));
        }
    }

    //    把一个整数和它减去1的结果做位与运算，相当于把它最右边的1变成0
    private static int intToBin_1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    //    使用标志位判断循环左移
    private static int intToBin_2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;

            flag = flag << 1;
        }
        return count;
    }

    //用字符串操作
    private static int intToBin_3(int n) {
        //用法：string valueString = Integer.toString( value, radix );
        //value 整数值，
        //radix 为2,8,10,16 分别代表进制。
        return Integer.toString(n, 2).replace("0", "").length();
    }

}
