package 华为108;


import java.util.ArrayList;
import java.util.Scanner;

public class 素数伴侣 {
    /*
     *题目描述
     * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
     * 输入:
     * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
     * 输出:
     * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
     * 输入描述:
     * 输入说明
     * 1 输入一个正偶数n
     * 2 输入n个整数
     * 输出描述:
     * 求得的“最佳方案”组成“素数伴侣”的对数。
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String nInt = sc.nextLine();
            int n = Integer.parseInt( nInt );
            int[] nNum = new int[n];
            for (int i = 0; i < n; i++) {
                nNum[i] = sc.nextInt();
            }
            System.out.println( getPrimeNum( nNum ) );
        }

        sc.close();
    }

    private static int getPrimeNum(int[] nNum) {

//      素数绝对不是偶数；
//      奇数加奇数一定是偶数，和一定不是素数，两个奇数不是素数伴侣；
//      偶数加偶数一定是偶数，和一定不是素数，两个偶数不是素数伴侣；
//      我们可以先处理一下原始数据：把偶数个数据按奇偶分成两分，素数伴侣只有可能从一边取一个得到。
//      这样就变成了二分图最大匹配问题了。
        int n = nNum.length;

        ArrayList<Integer> evenS = new ArrayList<>();
        ArrayList<Integer> oddS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nNum[i] % 2 == 0) {
                evenS.add( nNum[i] );
            } else {
                oddS.add( nNum[i] );
            }
        }
        int[] evensMatch = new int[evenS.size()];
        int result = 0;
        for (int i = 0; i < oddS.size(); i++) {
            int[] used = new int[evenS.size()];
            if (hungaryAlgo(oddS.get(i), evenS, used, evensMatch)) {
                result++;
            }
        }
        return result;
    }

    private static boolean hungaryAlgo(int integer, ArrayList<Integer> evenS, int[] used, int[] evensMatch) {

        int j;
        for (j = 0; j < evenS.size(); j++) {
            if (isPrime(integer + evenS.get(j)) && used[j] == 0) {
                used[j] = 1;
                if (evensMatch[j] == 0 || hungaryAlgo(evensMatch[j], evenS, used, evensMatch)) {
                    evensMatch[j] = integer;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

