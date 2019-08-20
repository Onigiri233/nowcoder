package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class primeFactor {
    /**
     * 题目描述
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
     * 最后一个数后面也要有空格
     * <p>
     * 详细描述：
     * <p>
     * 函数接口说明：
     * public String getResult(long ulDataInput)
     * 输入参数：
     * long ulDataInput：输入的正整数
     * 返回值：
     * String
     * <p>
     * <p>
     * 输入描述:
     * 输入一个long型整数
     * 输出描述:
     * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
     */
    public static void main(String[] args) {
        // TODO: 2019/8/20  本地测试用例
//        long l = 180;
//        System.out.println(getResult(l));


// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long l = sc.nextLong();
            System.out.println(getResult(l));
        }
    }

    public static String getResult(long ulDataInput) {
        long longg = ulDataInput;
        int i = 2;
        String result = "";
        while(longg!=1){
            while(longg%i==0){
                longg/=i;
                result = result + i+" ";
            }
            i++;
        }
        return result;
    }

}


