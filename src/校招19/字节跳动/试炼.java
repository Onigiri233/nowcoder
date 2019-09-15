package 校招19.字节跳动;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/15.
 */
public class 试炼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nNums = new int[n];
            for (int i = 0; i < n; i++) {
                nNums[i] = sc.nextInt();
            }
            System.out.println(faction(nNums));

        }
        sc.close();
    }

    private static int faction(int[] nNums) {
//        List jilist=new ArrayList<>();
//        List oulist=new ArrayList<>();
        int ji=0;
        int ou=0;
        for (int i = 0; i < nNums.length; i++) {
            if (i%2==0){
//                oulist.add(nNums[i]);
                ou+=nNums[i];
            }else {
//                jilist.add(nNums[i]);
                ji+=nNums[i];
            }
        }

        return ji>ou?ji:ou;
    }
}
