package 校招19.爱奇艺;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/8.
 */
public class 排列计数 {
    /**
     * 题目描述：
     * 给定一个长度为N-1且只包含0和1的序列A1到AN-1，如果一个1到N的排列P1到PN满足对于1≤i<N，当Ai=0时Pi<Pi+1，当Ai=1时Pi>Pi+1，则称该排列符合要求，那么有多少个符合要求的排列？
     * <p>
     * 输入
     * 第一行包含一个整数N，1<N≤1000。
     * <p>
     * 第二行包含N-1个空格隔开的整数A1到AN-1，0≤Ai≤1
     * <p>
     * 输出
     * 输出符合要求的排列个数对109+7取模后的结果。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String nInt = sc.nextLine();
            int n = Integer.parseInt(nInt);
            int[] numS = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                numS[i] = sc.nextInt();
            }
            System.out.println(getNum(n, numS));

        }
        sc.close();
    }

    private static int getNum(int n, int[] numS) {
        double mod = 1e9 + 7;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (numS[i - 1] == 1) {
                    dp[i][j] = (j == 0 ? 0 : dp[i][j - 1] - dp[i - 1][j - 1]) + dp[i - 1][i - 1];
                } else {
                    dp[i][j] = j == 0 ? 0 : dp[i][j - 1] + dp[i - 1][j - 1];
                }
                if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
                dp[i][j] %= mod;
            }
        }
        return (int) (dp[n-1][n-1] % mod);
    }
}