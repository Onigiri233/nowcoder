package 校招19.华为;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class primeNum_x {
    /**
     * 找出[LOW,HIGH)的所有素数,
     * 输出这些数十位数之和与个位数之和的较小值
     * 转换规则如下：
     * 报文中如果出现0x0A，转义成为2个字节0x12 0x34，如果出现0x0B，转义成为2个字节0xAB 0xCD。
     */
    public static void main(String[] args) {
//        int low = 151;
//        int high = 160;
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        System.out.println(faction(low, high));
    }

    private static int faction(int low, int high) {
        int x = 0, y = 0;
        for (int i = low; i < high; i++) {
            int isPrime = 1;
            for (int j = 2; j < (int) Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    isPrime = 0;
                    break;
                }
            }
            if (isPrime == 1) {
                if (i > 10) {
                    x += i % 100 / 10;
                    y += i % 10;
                } else {
                    y += i;
                }
            }
        }
        return x > y ? y : x;
    }


}
