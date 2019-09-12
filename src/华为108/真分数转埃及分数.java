package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 真分数转埃及分数 {
    /**
     * 题目描述
     * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(zhuanhuan(s));

        }
    }

    private static String zhuanhuan(String s) {
        /**
         * 设a、b为互质正整数，a<b 分数a/b 可用以下的步骤分解成若干个单位分数之和：
         * 步骤一：用b除以a，得商数q及余数r（r=b-a*q）
         * 步骤二：a/b = 1/(q+1) + (a-r)/b(q+1）
         * 步骤三：对于(a-r)/b(q+1),重复一和二，直到分解完毕
         * */
        StringBuffer sb = new StringBuffer();
        int fenzi = Integer.parseInt(s.split("/")[0]);
        int fenmu = Integer.parseInt(s.split("/")[1]);
        int gcd = GCD(fenzi, fenmu);
        fenzi /= gcd;
        fenmu /= gcd;
        while (fenzi!=1){
//            System.out.println("前:"+fenzi+"/"+fenmu);
            if (fenmu % (fenzi - 1) == 0) {
                sb.append("1/"+(fenmu / (fenzi - 1)+"+"));
                fenzi = 1;
            }
            else {
                int q = fenmu / fenzi;
                int r = fenmu % fenzi;
//                System.out.println("前:"+fenzi+"/"+fenmu+"商"+q+",余"+r);
                fenzi=fenzi-r;
                fenmu=fenmu *(q+1);
                gcd = GCD(fenzi, fenmu);
                fenzi /= gcd;
                fenmu /= gcd;
                sb.append("1/"+(q+1)+"+");
//                System.out.println("后:"+fenzi+"/"+fenmu);
            }
            System.out.println(sb.toString());

        }
        sb.append("1/"+fenmu);




        return sb.toString();
    }

    private static int GCD(int a, int b) {
        int tmp = 1;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }


}

