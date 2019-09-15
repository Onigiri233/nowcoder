package 华为108;

import java.util.*;

public class 字符统计 {
    /**
     * 题目描述
     * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
     * 实现以下接口：
     * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
     * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASII码由小到大排序输出
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(tongji(s));
        }
    }

    private static String tongji(String s) {
        StringBuffer sb=new StringBuffer();
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }
        System.out.println(map);
        ArrayList<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o2.getValue().compareTo(o1.getValue())==0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());

            }
        });
        System.out.println(list);
        for (Map.Entry<Character, Integer> mapp:
                list ) {
            sb.append(mapp.getKey()+"");
        }
        return sb.toString();

    }
}