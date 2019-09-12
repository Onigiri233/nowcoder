package 华为108;

import java.util.*;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 数组升降序 {
    /**
     * 题目描述
     * <p>
     * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nInt = sc.nextLine();
            int n = Integer.parseInt(nInt);

            Numberr[] numberrs = new Numberr[n];
            for (int i = 0; i < n; i++) {
                numberrs[i]=new Numberr(sc.nextInt());
            }
            int model = sc.nextInt();
            paixu(model, numberrs);
        }
        sc.close();
    }

    private static void paixu(int model, Numberr[] numberrs) {
        StringBuffer sb=new StringBuffer();
        Numberr.flag = model;
//        底层是归并,仍然具有稳定性
        Arrays.sort(numberrs);
        for (Numberr n : numberrs) {
            sb.append(n+" ");
        }
        System.out.println(sb.toString().trim());
    }
}

class Numberr implements Comparable<Numberr> {
    int num;
    public static int flag;

    public Numberr(int num) {
        this.num = num;
    }

    public int compareTo(Numberr other) {
        if (flag == 1)
            return other.num - num;
        return num - other.num;
    }

    public String toString() {
        return num+"";
    }
}

