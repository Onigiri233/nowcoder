package 华为108;

import java.util.*;

public class 砝码称重 {
    /**
     * 题目描述
     * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
     * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
     * 注：
     * 称重重量包括0
     * <p>
     * 输入描述:
     * 输入包含多组测试数据。
     * 对于每组测试数据：
     * 第一行：n --- 砝码数(范围[1,10])
     * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
     * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
     * <p>
     * 输出描述:
     * 利用给定的砝码可以称出的不同的重量数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = Integer.parseInt( s );
            int[] weight = new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println( fama( n, weight, nums ) );

        }
    }

    private static int fama(int n, int[] weight, int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list;
        for (int i = 0; i < n; i++) {
            list = new ArrayList<>( set );
            for (int j = 0; j <= nums[i]; j++) {
                System.out.println( i + "--" + weight[i] + "|" + j + "|" + list.size() );
                set.add( weight[i] * j );
                for (int k = 0; k < list.size(); k++) {
                    set.add( weight[i] * j + list.get( k ) );
                }
            }
        }
        return set.size();
    }
}
