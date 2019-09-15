package 校招19.字节跳动;

import java.util.*;

/**
 * Created by fantuan on 2019/9/15.
 */
public class 夏季特惠 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[][] nNums = new int[n][3];
            for (int i = 0; i < n; i++) {
                nNums[i][0] = sc.nextInt();
                nNums[i][1] = sc.nextInt();
                nNums[i][2] = sc.nextInt();
            }
            System.out.println(faction(nNums,x));

        }
        sc.close();
    }

    private static int faction(int[][] nNums,int x) {
        int dp[]=new int[nNums.length];


        Map<Integer,Double> map=new LinkedHashMap<>();
        for (int i = 0; i < nNums.length  ; i++) {
            map.put(i,(double)nNums[i][2]/(double) nNums[i][0]);
        }
        ArrayList<Map.Entry<Integer,Double>> list=new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer,Double>>() {
            @Override
            public int compare(Map.Entry<Integer,Double> o1, Map.Entry<Integer,Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(list);
        int kuaile=0;
        int zongyouhui=0;
        int zongzhifu=0;
        for (int i = 0; i < list.size(); i++) {
            int index=list.get(i).getKey();
            zongyouhui+=nNums[index][0]-nNums[index][1];
            zongzhifu+=nNums[index][1];
            if (zongzhifu<=x || zongyouhui>zongzhifu-x){
                kuaile+=nNums[index][2];
            }else {
                zongyouhui-=nNums[index][0]-nNums[index][1];
                zongzhifu-=nNums[index][1];
            }
        }
        return kuaile;

    }
}
