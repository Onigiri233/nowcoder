package 华为108;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by fantuan on 2019/8/21.
 */
public class mapMerge {
    /**
     * 题目描述
     * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     * 输入描述:
     * 先输入键值对的个数
     * 然后输入成对的index和value值，以空格隔开
     * 输出描述:
     * 输出合并后的键值对（多行）
     */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例


// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
//        输出有顺序,用treemap
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String kv = sc.nextLine();
            int k = Integer.valueOf(kv.split(" ")[0]);
            int v = Integer.valueOf(kv.split(" ")[1]);
            if (!map.containsKey(k)) {
                map.put(k, v);
            } else {
                map.put(k, map.get(k) + v);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
