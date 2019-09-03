package 华为108;

import java.util.ArrayList;
import java.util.Scanner;

public class 字符串排序 {
    /*
     * 题目描述
     * 编写一个程序，将输入字符串中的字符按如下规则排序。
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 如，输入： Type   输出： epTy
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 如，输入： BabA   输出： aABb
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     * 如，输入： By?e   输出： Be?y
     *  样例：
     *  输入：
     *  A Famous Saying: Much Ado About Nothing(2012/8).
     *  输出：
     *  A  aaAAbc   dFgghh :  iimM   nNn   oooos   Sttuuuy  (2012/8).
     * */


    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println( stringSort( s ) );
        }
        sc.close();
    }

    private static String stringSort(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        String isLetter = "[a-z]|[A-Z]";
        ArrayList<ArrayList> isLetterListList = new ArrayList();
        for (int i = 0; i < 26; i++) {
            isLetterListList.add( new ArrayList() );
        }
        ArrayList<Integer> noLetterList = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            String si = (s.charAt( i ) + "");
            if (si.matches( isLetter )) {
                ArrayList list = isLetterListList.get( s.toLowerCase().charAt( i ) - 'a' );
                list.add( i );
            } else {
                noLetterList.add( i );
            }
        }

        for (int i = 0; i < isLetterListList.size(); i++) {
            ArrayList<Integer> arrayList = isLetterListList.get( i );
            for (int j = 0; j < arrayList.size(); j++) {
                int index=arrayList.get( j );
                stringBuffer.append( s.charAt( index )+"");
            }
        }
        for (int i = 0; i <noLetterList.size() ; i++) {
            int index=noLetterList.get( i );
            stringBuffer.insert(index ,s.charAt( index )+"");
        }
        return stringBuffer.toString();
    }
}
