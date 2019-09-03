package 华为108;

import java.util.Scanner;

public class 整数与IP地址的转换 {
    /**
     * 题目描述
     * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。
     * 举例：一个ip地址为10.0.3.193
     * 每段数字             相对应的二进制数
     * 10                   00001010
     * 0                    00000000
     * 3                    00000011
     * 193                  11000001
     * 组合起来即为：00001010 00000000 00000011 11000001,
     * 转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
     * 每段可以看成是一个0-255的整数，需要对IP地址进行校验
     * <p>
     * 输入描述:
     * 1 输入IP地址
     * 2 输入10进制型的IP地址
     * 输出描述:
     * 输出
     * 1 输出转换成10进制的IP地址
     * 2 输出转换后的IP地址
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println( IPToDec( s1 ) );
            System.out.println(decToIP(s2));
        }
    }

    private static String IPToDec(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] ss = s.split( "\\." );
        for (int i = 0; i < ss.length; i++) {
            String intNum = ss[i];
            String binNum = Integer.toString( Integer.parseInt( intNum ), 2 );
            int length = binNum.length();
            for (int j = 0; j < 8 - length; j++) {
                binNum = "0" + binNum;
            }
            stringBuffer.append( binNum );
        }
        return Integer.valueOf( stringBuffer.toString(), 2 ) + "";
    }

    private static String decToIP(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        String binStr = Integer.toString( Integer.parseInt( s ), 2 );
        int length = binStr.length();
        for (int j = 0; j < 32 - length; j++) {
            binStr = "0" + binStr;
        }
        String[] ipS = new String[4];
        for (int i = 0; i < ipS.length; i++) {
            ipS[i] = binStr.substring( 0, 8 );
            binStr = binStr.substring( 8, binStr.length() );
        }
        for (int i = 0; i < ipS.length; i++) {
            stringBuffer.append( Integer.valueOf( ipS[i], 2 ) );
            if (i!=ipS.length-1){
                stringBuffer.append( "." );
            }
        }
        return stringBuffer.toString();
    }
    private static boolean checkIP(String ipStr) {
        String ipPattern ="^((1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.){3}" +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        return ipStr.matches(ipPattern);
    }
}
