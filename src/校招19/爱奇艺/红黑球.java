package 校招19.爱奇艺;

import java.util.*;

/**
 * Created by fantuan on 2019/9/8.
 */
public class 红黑球 {
    /**
     * 题目描述：
     有一个非常经典的概率问题，是一个袋子里面有若干个红球和若干个蓝球，两个人轮流取出一个球，谁先取到红球谁就赢了，当人的先后顺序和球的数量确定时，双方的胜率都可以由计算得到，这个问题显然是很简单的。

     现在有一个进阶版的问题，同样是一个袋子里面有n个红球和m个蓝球，共有A，B，C三人参与游戏，三人按照A，B，C的顺序轮流操作，在每一回合中，A，B，C都会随机从袋子里面拿走一个球，然而真正分出胜负的只有A，B两个人，没错，C就是来捣乱的，他除了可以使得袋子里面减少一个球，没有其他任何意义，而A，B谁 先拿到红球就可以获得胜利，但是由于C的存在，两人可能都拿不到红球，此时B获得胜利。

     输入
     输入仅包含两个整数n和m,表示红球和蓝球的数量，中间用空格隔开。(0<=n,m<=1000)

     输出
     请你输出A获胜的概率，结果保留5位小数。（四舍五入）
     */
    static HashSet<String> set=new HashSet();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nInt = sc.nextLine();
            int n=Integer.parseInt(nInt.split(" ")[0]);
            int m=Integer.parseInt(nInt.split(" ")[1]);
            
            System.out.println(getNum(n,m));
        }
        sc.close();
    }

    private static double getNum(int n, int m) {
//
//        红球1 篮球0
        int[] seq=new int[n+m];
        Arrays.fill(seq,0);
        for (int i = 0; i <n ; i++) {
            seq[i]=1;
        }
//        全排列后判断1的位置
        arrange(seq, 0, seq.length - 1);
        System.out.println(set);

        double shengli=set.size();
        double zongshu=cal(n+m)/(cal(n)*cal(m));
        System.out.println(shengli+"|"+zongshu);

        return (double) Math.round(shengli/zongshu * 100000) / 100000;
    }

    private static boolean check(int[] seq) {
        int A_1=-1;
        int B_1=-1;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i]==1){
                if (i%3==0){
                    if (A_1==-1){
                        A_1=i;
                    }
                }else if (i%3==1){
                    if (B_1==-1){
                        B_1=i;
                    }
                }
            }
        }
        if (A_1==-1){
            return false;
        }else
        if (A_1<B_1 ||B_1==-1){
            return true;
        }
        return false;
    }
    private static int cal(int n) {
        if (n == 1) {
            return 1;
        }else {
            return cal(n-1)*n;
        }
    }
    private static void arrange(int a[], int start, int end) {
        if (start == end) {
//            取完了,这里写要做的操作OR判断
            if (check(a)){
                set.add(Arrays.toString(a));
            }
            return;
        }
        for (int i = start; i <= end; i++) {
            if (isSwap(a, i, start)){
                swap(a, i, start);
                arrange(a, start + 1, end);
                swap(a, i, start);
            }
        }
    }
//   剪枝,如果交换是两个重复元素就跳过
    private static boolean isSwap(int[] arr, int begin, int end) {
        for (int i=begin;i<end;i++){
            if (arr[i]==arr[end]){
                return false;
            }
        }
        return true;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
