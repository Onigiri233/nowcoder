package 校招19.顺丰;


import java.util.Arrays;
import java.util.Scanner;

public class xuexiji {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nInt = sc.nextLine();
        int n =Integer.parseInt(nInt.split(" ")[0]);
        int m =Integer.parseInt(nInt.split(" ")[1]);
        int[][] peoToLangu=new int[n][m];

        int k =Integer.parseInt(nInt.split(" ")[2]);
        for (int i = 0; i < k; i++) {
            String utov = sc.nextLine();
            int peo=Integer.parseInt(utov.split(" ")[0]);
            int langu=Integer.parseInt(utov.split(" ")[1]);
            peoToLangu[peo-1][langu-1]=1;
        }
        sc.close();
        System.out.println(getXuexiji(peoToLangu));
    }

    private static int getXuexiji(int[][] peoToLangu) {
        int n =peoToLangu.length;
        int m =peoToLangu[0].length;
        int hasBridge=0;
        for (int i = 0; i <n ; i++) {
            int count=0;
            for (int j = 0; j <m ; j++) {

                if (peoToLangu[i][j]==1){
                    count++;
                }
                if (count>=2){
                    hasBridge=1;
                }
            }

        }

        return n-1;
    }
}
