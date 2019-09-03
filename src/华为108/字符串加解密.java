package 华为108;

import java.util.Scanner;

public class 字符串加解密 {
    /*
     *
     * 题目描述
     * 1、对输入的字符串进行加解密，并输出。
     * 2加密方法为：
     * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
     * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
     * 其他字符不做变化。
     * 3、解密方法为加密的逆过程。
     * 接口描述：
     * 实现接口，每个接口实现1个基本操作：
     * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
     * 说明：
     * 1、字符串以\0结尾。
     * 2、字符串最长100个字符。
     * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
     * 说明：
     * 1、字符串以\0结尾。
     * 2、字符串最长100个字符。
     *
     * 输入描述:
     * 输入一串要加密的密码
     * 输入一串加过密的密码
     *
     * 输出描述:
     * 输出加密后的字符
     * 输出解密后的字符

     *
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            System.out.println(encrypt(s1));
            System.out.println(decrypt(s2));
        }
    }

    private static String decrypt(String s) {
        StringBuffer stringBuffer=new StringBuffer(  );
        String codebook_encode = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza2345678901";
        String codebook_text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < s.length(); i++) {
            int index=codebook_encode.indexOf( s.charAt( i ) );
            stringBuffer.append( codebook_text.charAt( index ) );
        }
        return stringBuffer.toString();
    }

    private static String encrypt (String s) {
        StringBuffer stringBuffer=new StringBuffer(  );
        String codebook_text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String codebook_encode = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza2345678901";
        for (int i = 0; i < s.length(); i++) {
            int index=codebook_text.indexOf( s.charAt( i ) );
            stringBuffer.append( codebook_encode.charAt( index ) );
        }
        return stringBuffer.toString();
    }
}
