package 华为108;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 统计每个月兔子的总数 {
    /**
     * 题目描述
     * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * 输入描述:
     * 输入int型表示month
     * 输出描述:
     * 输出兔子总数int型
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println( getTotalCount( n) );
//            System.out.println(getTotalCount_Formula(n));
        }
    }

    public static int getTotalCount(int monthCount) {
        List<Integer> list=new ArrayList(  );
        if (monthCount==0){
            return 0;
        }
        if (monthCount==1 ||monthCount==2){
            return 1;
        }
        list.add( 0 );
        list.add( 1 );
        list.add( 1 );
        for(int i=3;i<=monthCount;i++){
            list.add(list.get( i-1 )+list.get( i-2 )  );
        }
        return list.get( monthCount );
    }
    public static int getTotalCount_Formula(int monthCount) {
        double m=monthCount;
        return (int)(1/Math.sqrt( 5 )*(Math.pow((1+Math.sqrt( 5 ))/2 ,m )-Math.pow((1-Math.sqrt( 5 ))/2 ,m )));
    }
}
