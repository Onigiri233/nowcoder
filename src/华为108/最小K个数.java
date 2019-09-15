package 华为108;

import java.util.*;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 最小K个数 {
    /**
     * 题目描述
     * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String s = sc.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int k = Integer.parseInt(s.split(" ")[1]);
            int[] nNums = new int[n];
            for (int i = 0; i < n; i++) {
                nNums[i] = sc.nextInt();
            }
            getTopK_sort(nNums, k);
            getTopK_dui(nNums, k);
            getMinK_dui(nNums, k);
            getMinK_dui(nNums, k);
        }
    }


    private static void getMinK_sort(int[] nNums, int k) {
//       全局排序，O(n*lg(n))
        StringBuffer sb = new StringBuffer();
        Arrays.sort(nNums);
        if (k > nNums.length) k = nNums.length;
        for (int i = 0; i < k; i++) {
            sb.append(nNums[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void getMinK_jubusort(int[] nNums, int k) {
//        局部排序，只排序TopK个数，O(n*k)
    }

    private static void getMinK_dui(int[] nNums, int k) {
//        堆，TopK个数也不排序了，O(n*lg(k))
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
        for (int num :
                nNums) {
            if (minQueue.size() < k || minQueue.peek() > num){
//                offer比put好
                minQueue.offer(num);
            }if (minQueue.size()>k){
                minQueue.poll();
            }
        }
        for (int topk :
                minQueue) {
            sb.append(topk+ " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void getTopK_sort(int[] nNums, int k) {
//       全局排序，O(n*lg(n))
        StringBuffer sb = new StringBuffer();
        Arrays.sort(nNums);
        if (k > nNums.length) k = nNums.length;
        for (int i = nNums.length-1; i > nNums.length-1-k; i--) {
            sb.append(nNums[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void getTopK_jubusort(int[] nNums, int k) {
//        局部排序，只排序TopK个数，O(n*k)
    }

    private static void getTopK_dui(int[] nNums, int k) {
//        堆，TopK个数也不排序了，O(n*lg(k))
        StringBuffer sb = new StringBuffer();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(k);
        for (int num :
                nNums) {
            if (minQueue.size() < k || minQueue.peek() < num){
//                offer比put好
                minQueue.offer(num);
            }if (minQueue.size()>k){
                minQueue.poll();
            }
        }
        for (int topk :
                minQueue) {
            sb.append(topk+ " ");
        }
        System.out.println(sb.toString().trim());
    }
}
