package 校招19.滴滴;

import java.util.*;

/**
 * Created by fantuan on 2019/8/28.
 */
public class gem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nInt = sc.nextLine();
        String stringa = sc.nextLine();
        String stringb = sc.nextLine();
        System.out.println(getGemNum(nInt, stringa, stringb));
        sc.close();
    }

    private static int getGemNum(String nInt, String stringa, String stringb) {
        int n = Integer.parseInt(nInt.split(" ")[0]);
        int total = Integer.parseInt(nInt.split(" ")[1]);
        int cost = Integer.parseInt(nInt.split(" ")[2]);

        int costCurr = 0;
        String sa = stringa;
        String sb = stringb;

        while (sa.charAt(sa.length() - 1) != sb.charAt(sb.length() - 1)) {
            if (sa.charAt(sa.length() - 1) > sb.charAt(sb.length() - 1)) {
                costCurr += Integer.parseInt(sb.charAt(sb.length() - 1) + "");
                sb = sb.substring(0, sb.length() - 2);
            } else {
                costCurr += Integer.parseInt(sa.charAt(sa.length() - 1) + "");
                sa = sa.substring(0, sa.length() - 2);
            }
        }

//        System.out.println(sa + "||" + sb);
        int gemNum = preCount(sa, sb);

        ArrayList<Integer> arrayListA = new ArrayList<>();
        ArrayList<Integer> arrayListB = new ArrayList<>();
        for (int i = 0; i < sa.length(); i = i + 2) {
            if (sb.contains(sa.charAt(i) + "")) {
                //如果存在就找到它出现的位置,不存在就不存.
                arrayListA.add(i);
                arrayListB.add(sb.indexOf(sa.charAt(i) + ""));
            }
        }

//        System.out.println(arrayListA);
//        System.out.println(arrayListB);

//        找到
        for (int resultNum = gemNum; resultNum > 0; resultNum--) {
            if (cost * resultNum + costCurr <= total) {
                return resultNum;
            } else if (resultNum==1){
                return 0;
            }
            else{
                // cost的回溯判断
                costCurr += Integer.parseInt(sa.charAt(resultNum * 2) + "");
                int starA, starB, endA, endB;
                starA = arrayListA.get(resultNum - 2);
                endA = arrayListA.get(resultNum - 1);
                starB = arrayListB.get(resultNum - 2);
                endB = arrayListB.get(resultNum - 1);
                for (int i = starA; i <=endA; i++) {
                    costCurr+=Integer.parseInt(sa.charAt(i)+"");
                }
                for (int i = starB; i <=endB; i++) {
                    costCurr+=Integer.parseInt(sb.charAt(i)+"");
                }
            }
        }
        return gemNum;
    }

    private static int preCount(String sa, String sb) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < sa.length(); i = i + 2) {
            if (sb.contains(sa.charAt(i) + "")) {
                //如果存在就找到它出现的位置,不存在就不存.
                arrayList.add(sb.indexOf(sa.charAt(i) + ""));
                hashMap.put(i, sb.indexOf(sa.charAt(i) + ""));
            }
        }
//        System.out.println(arrayList);
        //写一个返回最长增序子序列长度的函数,返回值即为宝石数
        int n = arrayList.size();
        int[] number = new int[n];
        int[] increSeq = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = arrayList.get(i);
            increSeq[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (number[i] > number[j] && increSeq[j] + 1 > increSeq[i])
                    increSeq[i] = increSeq[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(increSeq[i], max);
        }
        return max;
    }

}
