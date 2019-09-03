package 华为108;

import java.util.Scanner;


public class 小球落地 {
    /**
     * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半;
     * 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
     * 输入描述:
     * 输入起始高度，int型
     * <p>
     * 输出描述:
     * 分别输出第5次落地时，共经过多少米第5次反弹多高
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            int high = sc.nextInt();
            System.out.println(getJourney( high ));
            System.out.println( getTenthHigh( high ) );
        }
    }

    private static double getJourney(int high) {
        return high*(3-Math.pow( 0.5,3 ));
    }

    private static double getTenthHigh(int high) {
        return high*(Math.pow( 0.5,5 ));
    }
}
