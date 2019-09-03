package 华为108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 字符串合并处理 {
    /*
    *题目描述
    * 按照指定规则对输入的字符串进行处理。
    * 详细描述：
    * 将输入的两个字符串合并。
    * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
    * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
    * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
    *

    输入描述:
    输入两个字符串

    输出描述:
    输出转化后的结果
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println( stringMerge( s.split( " " )[0], s.split( " " )[1] ) );
        }
    }

    private static String stringMerge(String s1, String s2) {
        StringBuffer stringBuffer = new StringBuffer();
        String sMer = s1 + s2;
        ArrayList<String> strEven = new ArrayList<>();
        ArrayList<String> strOdd = new ArrayList<>();

        for (int i = 0; i < sMer.length(); i++) {
            if (i % 2 == 0) {
                strOdd.add( sMer.charAt( i ) + "" );
            } else {
                strEven.add( sMer.charAt( i ) + "" );
            }
        }
        Collections.sort( strOdd );
        Collections.sort( strEven );
        for (int i = 0; i < strOdd.size(); i++) {
            stringBuffer.append( strOdd.get( i ) );
            stringBuffer.append( strEven.get( i ) );
        }
        sMer = stringBuffer.toString();
        return BITString( sMer );
    }

    private static String BITString(String sMer) {
        String codebook_text = "0123456789abcdefABCDEF";
        String codebook_encode = "084C2A6E195D3B7F5D3B7F";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < sMer.length(); i++) {
            int index=codebook_text.indexOf( sMer.charAt( i ) );
            stringBuffer.append( codebook_encode.charAt( index ) );
        }
        return stringBuffer.toString();
    }

}
