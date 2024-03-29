package 华为108;

import java.util.*;

/**
 * Created by fantuan on 2019/8/21.
 */
public class mingmRandom {
    /**
     * 题目描述
     * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），
     * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
     * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
     * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
     * <p>
     * Input Param
     * n               输入随机数的个数
     * inputArray      n个随机整数组成的数组
     * <p>
     * Return Value
     * OutputArray    输出处理后的随机整数
     * <p>
     * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
     * <p>
     * 输入描述:
     * 输入多行，先输入随机整数的个数，再输入相应个数的整数
     * 输出描述:
     * 返回多行，处理后的结果
     */
    public static void main(String[] args) {
        // TODO: 2019/8/20  本地测试用例
//        int n = 11;
//        int nArray[] = new int[]{10,20,40,32,67,40,20,89,300,400,15};
//        TreeSet<Integer> treeset=new TreeSet<>();
//        for (int i = 0; i <nArray.length ; i++) {
//            treeset.add(nArray[i]);
//        }
//        System.out.println(treeset);

// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            TreeSet<Integer> treeset = new TreeSet<>();
            for (int i = 0; i < 1000; i++) {
                int randomNumber = sc.nextInt();
                treeset.add(randomNumber);
            }
            for (Integer i : treeset) {
                System.out.println(i);
            }

        }
    }


}
