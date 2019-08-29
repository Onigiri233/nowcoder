package 校招19.顺丰;


import java.util.Scanner;

public class zengxuzixulie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nInt = sc.nextLine();
        int n =Integer.parseInt(nInt);
        String string = sc.nextLine();
        System.out.println(getNum(n, string));
        sc.close();
    }

    private static int getNum(int n, String string) {
        int[] number = new int[n];
        int[] increSeq = new int[n];
        String[] ss=string.split(" ");
        for (int i = 0; i < ss.length; i++) {
            number[i] = Integer.parseInt(ss[i]);
            increSeq[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (number[i] >= number[j] && increSeq[j] + 1 > increSeq[i])
                    increSeq[i] = increSeq[j] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(increSeq[i]);
            max = Math.max(increSeq[i], max);
        }
        return max;
    }
}
