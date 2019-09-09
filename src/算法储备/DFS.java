package 算法储备;

import java.util.*;

public class DFS {
    public static void main(String[] args) {

    }

    private void DFS() {
//        递归

    }
    private void BFS() {
//        图
        Queue<String> queue = new PriorityQueue<>();
        HashSet<String> visitedSet = new HashSet<>();

        List<List<String>> personList = new ArrayList<>();
        HashSet<String> findPerson = new HashSet<>();

        queue.add( " " );
        while (!queue.isEmpty()) {
            String person = queue.poll();
//            处理遍历的节点
            findPerson.add( person );
            for (int i = 0; i < personList.size(); i++) {
                for (int j = 0; j < personList.get( i ).size(); j++) {
                    if (person.equals( personList.get( i ).get( j ) )) {
                        // 将这个list内的值全部加入set中
                        for (String s : personList.get( i )) {
                            visitedSet.add( s );
                        }
                        // 将这个群里面的所有值放入队列中
                        for (String personName : personList.get( i )) {
                            boolean isFind = false;
                            for (String findPer : findPerson) {
                                if (findPer.equals( personName )) {
                                    isFind = true;
                                }
                            }
                            if (!isFind) {
                                queue.add( personName );
                            }
                        }
                    }
                }
            }
        }
    }

}
