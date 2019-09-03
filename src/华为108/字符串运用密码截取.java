package 华为108;


import java.util.Scanner;

public class 字符串运用密码截取 {


    /**
     * 题目描述
     * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，
     * 比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
     * 比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
     * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
     * Cathcer的工作量实在是太大了，他只能向电脑高手求助，
     * 你能帮Catcher找出最长的有效密码串吗？
     * 输入描述:
     * 输入一个字符串
     * 输出描述:
     * 返回有效密码串的最大长度
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println( manacher( s ) );
        }
    }

    //  Manachar算法主要是处理字符串中关于回文串的问题的，
    // 它可以在 O（n） 的时间处理出以字符串中每一个字符为中心的回文串半径，
    // 由于将原字符串处理成两倍长度的新串，在每两个字符之间加入一个特定的特殊字符，
    // 因此原本长度为偶数的回文串就成了以中间特殊字符为中心的奇数长度的回文串了。
    // Manacher算法提供了一种巧妙的办法，将长度为奇数的回文串和长度为偶数的回文串一起考虑，
    // 具体做法是，在原字符串的每个相邻两个字符中间插入一个分隔符，
    // 同时在首尾也要添加一个分隔符，分隔符的要求是不在原串中出现，一般情况下可以用#号。
    private static int manacher(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append( "#" );
            sb.append( s.charAt( i ) );
        }
        sb.append( "#" );
        char[] charArr = sb.toString().toCharArray();
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min( radius[2 * c - i], R - i + 1 ) : 1;
            while (i + radius[i] < charArr.length && i - radius[i] > -1) {
                if (charArr[i - radius[i]] == charArr[i + radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (i + radius[i] > R) {
                R = i + radius[i] - 1;
                c = i;
            }
            max = Math.max( max, radius[i] );
        }
        return max - 1;

    }

    private static boolean isSymmetricStr(String s) {
        StringBuffer stringBuffer = new StringBuffer( s );
        return stringBuffer.equals( stringBuffer.reverse() );
    }
}
