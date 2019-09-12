package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 出现一次的字符 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(oncecharOfString(str));
        }
        sc.close();
    }
    private static String oncecharOfString(String s) {
        String result = "-1";
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                result = s.charAt(i) + "";
                break;
            }
        }
        return result;
    }
}
