package 随手撸的代码;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static HashSet<String> set=new HashSet();
    public static void main(String[] args) {
        int n=4;
        int[] seq=new int[n];
        for (int i = 0; i <n ; i++) {
            seq[i]=i+1;
        }
        System.out.println(Arrays.toString(seq));
//        全排列后判断1的位置
        arrange(seq, 0, seq.length - 1);
        System.out.println(set);
        System.out.println(set.size());
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

    private static void arrange(int a[], int start, int end) {
        if (start == end) {
//            取完了,这里写要做的操作OR判断
            if (check(a)){
            }
            set.add(Arrays.toString(a));
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
