package 校招19.字节跳动;

import java.util.*;

/**
 * Created by fantuan on 2019/9/15.
 */
public class 文件传输 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] nNums=new int[n][2];
            for (int i = 0; i < n; i++) {
                nNums[i][0]=sc.nextInt();
                nNums[i][1]=sc.nextInt();
            }

           faction(nNums);

        }
        sc.close();
    }

    private static void faction(int[][] nNums) {
        List<Integer> list=new ArrayList<>();
        int[] dp=new int[nNums.length];
        dp[0]=0;
        for (int i = 1; i < nNums.length; i++) {
            if (nNums[i][0]-nNums[i-1][0]>=dp[i-1]+nNums[i-1][1]) {
                dp[i]=0;
            }else {
                dp[i]=dp[i-1]+nNums[i-1][1]-(nNums[i][0]-nNums[i-1][0]);
            }
        }
        for (int i = 0; i < nNums.length; i++) {
            list.add(dp[i]+nNums[i][1]);
        }
        System.out.print(nNums.length+dp[nNums.length-1]+nNums[nNums.length-1][1]+" ");
        int max=Collections.max(list);
        System.out.println(max);
    }
}
