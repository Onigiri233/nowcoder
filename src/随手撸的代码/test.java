package 随手撸的代码;

/**
 * Created by fantuan on 2019/8/20.
 */
public class test {
//    给定n个柱面的高度，表示降雨某地n块区域的海拔高度。
//    计算降雨之后该地最大储水面积。如果低于地平线，也就是小于0，则一定积水。
    public static void main(String[] args) {
        int n[]=new int[]{3,1,-2,-3,-2,4,1,4};
        int pools[]=new int[n.length];
        int poolsSize=0;



            for (int i = 0; i < n.length; i++) {
                //            找一个从i到j的积水区
                for (int j = i+1; j < n.length; j++) {
                    System.out.println(n[j]+"  "+n[i]);
                    if (n[j]<n[i]){
                        System.out.println("继续");
                        continue;
                    }
                    System.out.println("结算");
                    poolsSize+=j-i;
                    i=j;
                    break;
                }
            }
        System.out.println(poolsSize);

    }
}
