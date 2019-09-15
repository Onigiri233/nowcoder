package 算法储备;

/**
 * Created by fantuan on 2019/9/15.
 */
public class 年月日类型 {

    public static void main(String[] args) {
        int year=2020,month=9,day=15;
        int[] mons = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeap(year)) mons[2] = 29;
        int ans = 0;
        for (int i = 1; i < month; i++) {
            ans += mons[i];
        }
        ans += day;
        System.out.println(ans);
    }

    static boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        return false;
    }
}
