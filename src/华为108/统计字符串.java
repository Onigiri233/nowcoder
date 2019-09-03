package 华为108;

import java.util.Scanner;

public class 统计字符串 {
    /**
     * 题目描述
     * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println( getEnglishCharCount( s ) );
            System.out.println( getBlankCharCount( s ) );
            System.out.println( getNumberCharCount( s ) );
            System.out.println( getOtherCharCount( s ) );
        }
    }

    private static int getOtherCharCount(String s) {
        String isOther = "[^0-9|a-z|A-Z|\\s]";
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt( i ) + "").matches( isOther )) {
                count++;
            }
        }
        return count;
    }

    private static int getNumberCharCount(String s) {
        String isNumber = "[0-9]";
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt( i ) + "").matches( isNumber )) {
                count++;
            }
        }
        return count;
    }

    private static int getBlankCharCount(String s) {
        return s.split( " " ).length - 1;
    }

    private static int getEnglishCharCount(String s) {
        String isEnglish = "[a-z|A-Z]";
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt( i ) + "").matches( isEnglish )) {
                count++;
            }
        }
        return count;
    }
}
