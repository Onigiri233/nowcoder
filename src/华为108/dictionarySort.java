package 华为108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class dictionarySort {
    /**
     * 题目描述
     * 给定n个字符串，请对n个字符串按照字典序排列。
     * 输入描述:
     * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
     * 输出描述:
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例

// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.valueOf(sc.nextLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String word = sc.nextLine();
                list.add(word);
            }
            Collections.sort(list);
            for (String s:list
                    ) {
                System.out.println(s);
            }
        }
    }
}
