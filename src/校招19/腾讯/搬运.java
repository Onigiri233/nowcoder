package 校招19.腾讯;

import java.util.Scanner;

public class 搬运 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String nInt = sc.nextLine();
        int n = Integer.parseInt( nInt.split( " " )[0] );
        int m = Integer.parseInt( nInt.split( " " )[1] );
        int nToChestNum[] = new int[n];
        for (int i = 0; i < n; i++) {
            nToChestNum[i] = sc.nextInt();
        }
        sc.close();
        System.out.println( getCostTime( m, nToChestNum ) );
    }


    private static int getCostTime(int m, int[] nToChestNum) {


//        对于一个特定的时间x，如果m个搬运工能在x时间内完成搬运，
//        则在y( y >= x ) 时间内一定能完成搬运，所以这个时间x具有二分的性质。
//        因此我们二分这个时间值，关键问题是如何判断在给定的时间x内能否完成搬运。
//        显然，对于单个搬运工的最优策略，显然是去搬运离他最近的箱子，也就是最左边的箱子，
//        所以我们可以利用这个性质，计算出在x的时间内搬完n个地方的箱子最少需要多少搬运工，
//        然后如果计算出的搬运工的数目小于等于m，说明这个时间x可行，否则不可行。
//        总体时间复杂度O( nlogn )

        int maxPeo = 0;
        for (int i = 0; i < nToChestNum.length; i++) {
            maxPeo += nToChestNum[i];
        }
        if (m >= maxPeo) {
            return nToChestNum.length + 1;
        } else {
//            使用二分查找优化
            int low = 2, high = maxPeo + nToChestNum.length;
            while (low < high) {
                int mid = low + (high - low) / 2;
//                System.out.println( "l:" + low + "|h:" + high + "|m:" + mid + "|" + check( mid, m, nToChestNum ) );
                if (check( mid, m, nToChestNum )) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return high;
        }
    }

    private static boolean check(int mid, int m, int[] nToChestNum) {
        int cnt = 0, p = 0;
        for (int i = 0; i < nToChestNum.length; i++) {
            cnt += nToChestNum[i];
            if (i + 1 > mid) {
                return false;
            }

            while (i + 1 + cnt > mid) {
                cnt -= mid - i - 1;
                p += 1;
                if (p > m) {
                    return false;
                }
            }
        }
        if (p == m) {
            return cnt <= 0;
        }
        return true;

    }
}
