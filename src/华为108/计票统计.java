package 华为108;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 计票统计 {
    /**
     * 题目描述
     * <p>
     * 输入描述:
     * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
     * 输出描述:
     * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nName = sc.nextLine();
            int n = Integer.parseInt(nName);
            String[] name = sc.nextLine().split(" ");

            String s = sc.nextLine();
            int nPiao = Integer.parseInt(s);
            String[] piao = sc.nextLine().split(" ");

            jipiao(name,piao);

        }
        sc.close();
    }

    private static void jipiao(String[] name, String[] piao) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String na : name) {
            map.put(na,0);
        }
        map.put("Invalid",0);

        for (String pia:piao){
            if (map.containsKey(pia)){
                map.put(pia,map.get(pia)+1);
            }else {
                map.put("Invalid",map.get("Invalid")+1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
