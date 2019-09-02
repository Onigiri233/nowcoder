package 校招19.腾讯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 咖啡满意值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        String nInt = sc.nextLine();
        int n = Integer.parseInt( nInt );
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add( sc.nextLine().split( " " ) );
        }
        sc.close();
        System.out.println( getValue( list ) );
    }

    private static long getValue(List<String[]> list) {
//        ai⋅(j−1)+bi⋅(n−j)=(ai−bi)⋅j+(−ai+bi⋅n)
//        后面的 (−ai+bi⋅n)是定值，只需令(ai−bi)⋅j 最小即可。
//        也就是按照 (ai−bi)排序分配位置
        long result = 0;
        List<Long> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            long a = Long.parseLong( list.get( i )[0] );
            long b = Long.parseLong( list.get( i )[1] );
            list1.add( a - b );
            result += b * list.size() - a;
        }
        Collections.sort( list1 );
        for (int i = 0; i < list.size(); i++) {
            result += list1.get( i ) * (list.size() - i);

        }
        return result;
    }
}
