package 算法储备;

/**
 * Created by fantuan on 2019/9/13.
 */
public class String格式化输出 {
    public static void main(String[] args) {

        /*
        * %x    整数类型（十六进制）10->a
        * %o    整数类型（八进制）10->12
        * %f    浮点类型
        * %a    十六进制浮点类型 10->0x1.4p3
        * %e    指数类型
        * %g    通用浮点类型（f和e类型中较短的）
        *
        * %04d    补0
        *
        *


        * */
        System.out.println(String.format("%.1f", (double) 10));
        System.out.println(String.format("%04d", 10));
        System.out.println(String.format("%x", 10).toUpperCase());
        System.out.println(String.format("%o", 10));
        System.out.println(String.format("%a", 10.0));
        System.out.println(String.format("%e", 10.0));
        System.out.println(String.format("%g", 10.0));

        System.out.println("-————————————————————————————————————");

        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toString(10,2));
        System.out.println(Integer.toString(10,8));
        System.out.println(Integer.toString(10,16));

        System.out.println(        Integer.reverseBytes(2));
    }
}
