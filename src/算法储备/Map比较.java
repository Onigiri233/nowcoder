package 算法储备;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fantuan on 2019/9/13.
 */
public class Map比较 {
    public static void main(String[] args) {
//        按照value值比较,相同时再比较key
        Map<Character,Integer> map=new HashMap<>();
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
    }
}
