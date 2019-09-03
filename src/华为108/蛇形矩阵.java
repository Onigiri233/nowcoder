package 华为108;


import java.util.Arrays;
import java.util.Scanner;

public class 蛇形矩阵 {
    /**
     * 题目描述
     * 题目说明
     * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
     * 样例输入
     * 样例输出
     * 1 3 6 10 15
     * 2 5 9 14
     * 4 8 13
     * 7 12
     * 11
     * 输入描述:
     * 输入正整数N（N不大于100）
     * <p>
     * 输出描述:
     * 输出一个N行的蛇形矩阵。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            int n = sc.nextInt();
            soutMartix( n );
        }
    }

    private static void soutMartix(int n) {
        int[][] martix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill( martix[i], 0 );
        }
        int natural = 1;
        for (int sum = 0; sum < n; sum++) {
            for (int i = 0; i <= sum; i++) {
                int j = sum - i;
                martix[j][i] = natural++;
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < n; j++) {
                if (martix[i][j] != 0) {
                    stringBuffer.append( martix[i][j] + " " );
                }
            }
            System.out.println( stringBuffer.toString().trim() );
        }
    }
}

