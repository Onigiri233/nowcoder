package 校招19.滴滴;

import java.util.Scanner;

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
//        找到
        for (int result=gemNum;result>0;result--){
            if (cost * gemNum + costCurr < total) {
                return gemNum;
            }else {
                // TODO: 2019/8/28 cost的回溯判断 
                costCurr+=0;
            }
            
        }
        

        return gemNum;
    }

    private static int preCount(String sa, String sb) {
        for (int i = 0; i < sa.length(); i = i + 2) {
//            System.out.println(sa.charAt(i));
            if (sb.contains(sa.charAt(i) + "")) {
                // TODO: 2019/8/28 如果存在就找到它出现的位置,不存在就不存.用arraylist.
            }
            // TODO: 2019/8/28 写一个返回最长增序子序列长度的函数,返回值即为宝石数 
        }
        return 3;
    }

}
