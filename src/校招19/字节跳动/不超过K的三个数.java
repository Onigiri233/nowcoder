package 校招19.字节跳动;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/15.
 */
public class 不超过K的三个数 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] nNums=new int[n];
            for (int i = 0; i < n; i++) {
                nNums[i]=sc.nextInt();
            }
            int k=sc.nextInt();
            System.out.println(faction(nNums, k));

        }
        sc.close();
    }

    private static int faction(int[] nNums, int k) {
        HashSet<String> set=new HashSet<>();
        if (nNums.length<3){
            return 0;
        }
        Arrays.sort(nNums);

        for (int i = 1; i < nNums.length-1; i++) {
            int first=0;
            int last=nNums.length-1;
            while (first<last){
                if (first==i ||last==i){
                    continue;
                }
                int resu=nNums[i]+nNums[first]+nNums[last];
                while (resu<k){
                    if (first!=i &&last!=i){
                        set.add(nNums[i]+","+nNums[first]+","+nNums[last]);
                    }
                    first++;
                    resu=nNums[i]+nNums[first]+nNums[last];
                }
                if (resu>=k){
                    last--;
                    resu=nNums[i]+nNums[first]+nNums[last];
                }
            }

        }
        System.out.println(set);
        return set.size();
//        5.56
    }
}
