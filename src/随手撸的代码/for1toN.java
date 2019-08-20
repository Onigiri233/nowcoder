package 随手撸的代码;

/**
 * Created by fantuan on 2019/8/20.
 */
public class for1toN {
    public static void main(String[] args) {


        int sum=0;
        for(int i=1;i<=1234;i++){
            int temp = i%10;
            sum+=temp;
            temp = i/10%10;
            sum+=temp;
            temp = i/100%10;
            sum+=temp;
            temp = i/1000%10;
            sum+=temp;
        }
        System.out.println("sum:"+sum);
    }
}
