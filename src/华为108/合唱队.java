package 华为108;

/**
 * Created by fantuan on 2019/8/27.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 合唱队 {
    /*题目描述
     *计算最少出列多少位同学，使得剩下的同学排成合唱队形
     *
     * 说明：
     * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
     * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2⋯，K，他们的身高分别为T1，T2，⋯，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
     * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
     *
     * 输入描述:
     * 整数N
     * N个人身高的字符串
     *
     * 输出描述:
     * 最少需要几位同学出列*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] heightS = new int[n];
            for (int i = 0; i < n; i++) {
                heightS[i] = sc.nextInt();
            }
            System.out.println(outList(n, heightS));
        }
        sc.close();

    }

    private static int outList(int n, int[] heightS) {
        if (n <= 2) {
            return 0;
        }
        int[] increSeq = new int[n];
        int[] decreSeq = new int[n];
        for (int i = 0; i < n; i++) {
            increSeq[i] = 1;
            decreSeq[i] = 1;
        }
//        两次动规
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(heightS[i]>heightS[j]&&increSeq[j]+1>increSeq[i])
                    increSeq[i]=increSeq[j]+1;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(heightS[i]>heightS[j]&&decreSeq[j]+1>decreSeq[i])
                    decreSeq[i]=decreSeq[j]+1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(increSeq[i] + decreSeq[i], max);
        }
//        ArrayList<Integer> outNum=new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            outNum.add(increSeq[i]+decreSeq[i]-1);
//        }
//        System.out.println(outNum);
//        return n-Collections.max(outNum);
        return n-max+1;
    }
}

