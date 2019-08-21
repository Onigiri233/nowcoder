package 校招19.华为;

import java.util.*;

/**
 * Created by fantuan on 2019/8/21.
 */
public class messageForward {
    /**
     * 输入
     * 第一个发消息的人
     * 群组个数m   十进制最大不超过100
     * 群成员1-m的人名列表 字符串 最大不超过100字符
     * <p>
     * 输出
     * 十进制最后能收到消息的人数,包括第一个人,重复至统计一次.
     * <p>
     * <p>
     * Jack
     * 3
     * Jack,Tom,Anny,Licy
     * Tom,Danny
     * Jack,Lily
     * <p>
     * 输出
     * 6
     */


    static HashSet<String> visitedSet = new HashSet<>();
    static Queue<String> queue = new PriorityQueue<>();

    public static void main(String[] args) {
//        String input = "Jack\n" +
//                "     3\n" +
//                "     Jack,Tom,Anny,Licy\n" +
//                "     Tom,Danny\n" +
//                "     Jack,Lily";

//        String openName = "Jack";
//        int n = 3;
//        String[] s = new String[]{"Jack,Tom,Anny,Licy", "Tom,Danny", "Jack,Lily"};


        Scanner sc = new Scanner(System.in);
        String openName = sc.nextLine();
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextLine();
        }

        List<List<String>> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp = s[i];
            String[] tempArr = temp.split(",");
            List<String> tempList = new ArrayList<>();
            for (int j = 0; j < tempArr.length; j++) {
                tempList.add(tempArr[j]);
            }
            personList.add(tempList);
        }
        System.out.println(forwarmessage(openName, personList));
    }


    public static int forwarmessage(String openName, List<List<String>> personList) {
//        初始化
        queue.add(openName);
        // BFS
        HashSet<String> findPerson = new HashSet<>();
        while (queue.size() > 0) {
            String person = queue.poll();
            findPerson.add(person);
            for (int i = 0; i < personList.size(); i++) {
                for (int j = 0; j < personList.get(i).size(); j++) {
                    if (person.equals(personList.get(i).get(j))) {
                        // 将这个list内的值全部加入set中
                        for (String s : personList.get(i)) {
                            visitedSet.add(s);
                        }
                        // 将这个群里面的所有值放入队列中
                        for (String personName : personList.get(i)) {
                            boolean isFind = false;
                            for (String findPer : findPerson) {
                                if (findPer.equals(personName)) {
                                    isFind = true;
                                }
                            }
                            if (!isFind) {
                                queue.add(personName);
                            }
                        }
                    }
                }
            }
        }
        return visitedSet.size();
    }
}
