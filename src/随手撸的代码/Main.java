package 随手撸的代码;

public class Main {
//    经典硬币问题
//    有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱(n<10000)，有多少中组合可以组成n分钱？

    public static void main(String[] args) {
        int n=13;
        int coins[]=new int[]{1,2,5,10};
        printCombination(n,coins);
    }



    private static int combination(int n,int[] coins,int cur) {
        if (cur == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i * coins[cur] <= n; i++) {
            ans += combination(n - i * coins[cur], coins, cur - 1);
        }
        return ans;
    }
    private static void printCombination(int n,int[] coins) {
        if (n<=0){
            return;
        }
        System.out.println(combination(n,coins,coins.length-1));
    }
}
