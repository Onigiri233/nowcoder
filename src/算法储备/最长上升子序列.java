package 算法储备;

import java.util.Arrays;

public class 最长上升子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS( new int[]{11, 12, 13, 14, 1, 2, 3, 4, 5} ));
        System.out.println(lengthOfLIS_( new int[]{11, 12, 13, 14, 1, 2, 3, 4, 5} ));

    }

    private static int lengthOfLIS(int[] nums) {
        //        DP O(n^2)

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max( dp[i], dp[j] + 1 );
                }
            }
            res = Math.max( res, dp[i] );
        }
        return res;
    }

    private static int lengthOfLIS_(int[] nums) {
//        二分查找 O(nlongn)
        int[] LIS = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch( LIS, 0, length, num );
            if (index < 0) {
                index = -(index + 1);
            }
            LIS[index] = num;
            if (index == length) {
                length++;
            }
        }
        return length;
    }

}
