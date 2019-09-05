package 华为108;


import java.util.Scanner;

public class 按字节截取字符串 {
    /**
     * 题目描述
     * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
     * 输入描述:
     * 输入待截取的字符串及长度
     * 输出描述:
     * 截取后的字符串
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s=sc.nextLine();
            String nInt=sc.nextLine();
            int n=Integer.parseInt( nInt );
            System.out.println(subString(s,n));
        }
        sc.close();
    }

    private static String subString(String s, int n) {
        StringBuffer stringBuffer=new StringBuffer(  );
        int length=0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt( i ) + "").matches("[^\\x00-\\xff]" )) {
                if (length<n-2){
                    stringBuffer.append( s.charAt( i ) );
                    length=length+2;
                }else {
                    break;
                }
            }else {
                stringBuffer.append( s.charAt( i ) );
                length++;
            }
            if (length>=n){
                break;
            }
        }
        return stringBuffer.toString();
    }
}
