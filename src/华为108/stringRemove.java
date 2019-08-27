package 华为108;

/**
 * Created by fantuan on 2019/8/27.
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class stringRemove {
    /*题目描述
     *实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     *输入描述:
     *字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
     *
     *输出描述:
     *删除字符串中出现次数最少的字符后的字符串。*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(getString(s));
        }
        sc.close();
    }

    private static String getString(String s) {
        HashMap <String,Integer>hashMap=new HashMap();


        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)+"") ){
                hashMap.put(s.charAt(i)+"",hashMap.get(s.charAt(i)+"")+1);
            }else {
                hashMap.put(s.charAt(i)+"",1);
            }
        }
        int min=Collections.min(hashMap.values());
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)+"")!=min){
                stringBuffer.append(s.charAt(i)+"");
            }
        }

        return stringBuffer.toString();
    }
}

