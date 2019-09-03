package 华为108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 查找兄弟单词 {

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()){
            String s = sc.nextLine();
            serachBro( s );
        }
        sc.close();

    }

    private static void serachBro(String s) {
        int n = Integer.parseInt( s.split( " " )[0] );
        int k = Integer.parseInt( s.split( " " )[n + 2] );
        String addWord = s.split( " " )[n + 1];
        ArrayList<String> broWordS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String theWord = s.split( " " )[i + 1];
            if (isBor( theWord, addWord )) {
                broWordS.add( theWord );
            }
        }
        Collections.sort(  broWordS);
        System.out.println(broWordS.size());
        System.out.println(broWordS.get( k-1 ));
    }

    private static Boolean isBor(String s1, String s2) {
        if (s1.length() != s2.length() || s1.equals( s2 )) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort( str1 );
        Arrays.sort( str2 );
        return Arrays.equals( str1, str2 );
    }
}
