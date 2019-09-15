package 算法储备;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 公约数判断 {
    public static void main(String[] args) {
        System.out.println(GCD(2,4));
        System.out.println(GCD(2,3));
    }
    private static int GCD(int a, int b) {
        int tmp = 1;
        while (b != 0) {
            tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
