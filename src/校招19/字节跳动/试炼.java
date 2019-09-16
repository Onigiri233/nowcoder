package 校招19.字节跳动;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/15.
 */
public class 试炼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nNums = new int[n];
            for (int i = 0; i < n; i++) {
                nNums[i] = sc.nextInt();
            }
            System.out.println( faction( nNums ) );
        }
        sc.close();
    }

    private static int faction(int[] nNums) {

        if (nNums.length % 2 == 0) {
            int ji = 0;
            int ou = 0;
            for (int i = 0; i < nNums.length; i++) {
                if (i % 2 == 0) {
                    ou += nNums[i];
                } else {
                    ji += nNums[i];
                }
            }
            return ji > ou ? ji : ou;
        } else {
            int ji = 0;
            int ou = 0;
            int a=nNums[0];
            for (int i = 1; i < nNums.length; i++) {
                if (i % 2 == 0) {
                    ou += nNums[i];
                } else {
                    ji += nNums[i];
                }
            }
            a+=ji < ou ? ji : ou;

            ji = 0;
            ou = 0;
            int b=nNums[nNums.length-1];
            for (int i = 0; i < nNums.length-1; i++) {
                if (i % 2 == 0) {
                    ou += nNums[i];
                } else {
                    ji += nNums[i];
                }
            }
            b+=ji < ou ? ji : ou;
            return a < b ? b : a;
        }
    }
}
