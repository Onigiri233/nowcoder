package 华为108;

import java.util.Arrays;
import java.util.Scanner;

public class 名字漂亮度 {
    /**
     * 题目描述
     * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
     * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
     * 给出多个名字，计算每个名字最大可能的“漂亮度”。
     *
     * 输入描述:
     * 整数N，后续N个名字
     *
     * 输出描述:
     * 每个名称可能的最大漂亮程度
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String nInt=sc.nextLine();
            int n=Integer.parseInt( nInt );
            for (int i = 0; i <n ; i++) {
                String name=sc.nextLine();
                System.out.println(getBeautifulValue(name));
            }
        }
    }

    private static int getBeautifulValue(String name) {
        int[] count = new int[26];
        int beautifulValue=0;
        int len = name.length();
        for(int j=0;j<len;j++){
            count[name.charAt(j)-97]++;
        }
        Arrays.sort(count);
        for(int k =0;k<26;k++){
            beautifulValue+=count[k]*(k+1);
        }
        return beautifulValue;
    }

}
