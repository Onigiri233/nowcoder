package 校招19.腾讯;

import java.util.Scanner;

public class 宝箱 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nInt = sc.nextLine();
        int n =Integer.parseInt(nInt.split(" ")[0]);
        int m =Integer.parseInt(nInt.split(" ")[1]);
        int chestNum[]=new int[n];
        int keyNum[]=new int[m];
        for (int i = 0; i < n; i++) {
            chestNum[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            keyNum[i]=sc.nextInt();
        }
        sc.close();
        System.out.println(getChest(chestNum,keyNum));
    }

    private static int getChest(int[] chestNum, int[] keyNum) {
        int oddOfChest=0,evenOfChest=0,oddOfKey=0,evenOfKey=0;
        for (int n:chestNum){
            if (n%2==0){
                oddOfChest++;
            }else {
                evenOfChest++;
            }
        }
        for (int n:keyNum){
            if (n%2==0){
                oddOfKey++;
            }else {
                evenOfKey++;
            }
        }
        return Math.min(oddOfKey,evenOfChest)+Math.max(evenOfKey,oddOfChest);
    }
}
