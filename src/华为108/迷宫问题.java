package 华为108;

import java.util.Scanner;

public class 迷宫问题 {
    /**
     * 题目描述
     * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
     * int maze[5][5] = {
     * 0, 1, 0, 0, 0,
     * 0, 1, 0, 1, 0,
     * 0, 0, 0, 0, 0,
     * 0, 1, 1, 1, 0,
     * 0, 0, 0, 1, 0,};
     * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
     * Input
     * 一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
     * Output
     * 左上角到右下角的最短路径，格式如样例所示。
     * Sample Input
     * 0 1 0 0 0
     * 0 1 0 1 0
     * 0 0 0 0 0
     * 0 1 1 1 0
     * 0 0 0 1 0
     * Sample Output
     * (0, 0)
     * (1, 0)
     * (2, 0)
     * (2, 1)
     * (2, 2)
     * (2, 3)
     * (2, 4)
     * (3, 4)
     * (4, 4)
     * <p>
     * 输入描述:
     * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
     * 输出描述:
     * 左上角到右下角的最短路径，格式如样例所示。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = Integer.parseInt( s.split( " " )[0] );
            int m = Integer.parseInt( s.split( " " )[1] );
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            getPath( matrix );
        }
    }

    private static void getPath(int[][] matrix) {
        checkPath( matrix, 0, 0 );
        printPath( matrix );
    }

    public static int checkPath(int[][] matrix, int x, int y) {
        int n = matrix[0].length;
        int m = matrix.length;
        if (x == m - 1 && y == n - 1) return 1;
        if (x < m && y < n && matrix[x][y] == 0) {
            if (checkPath( matrix, x + 1, y ) == -1 && checkPath( matrix, x, y + 1 ) == -1) {
                matrix[x][y] = 1;
                return -1;
            } else return 1;
        } else return -1;
    }

    private static void printPath(int[][] path) {
        int n = path[0].length;
        int m = path.length;

        int curI = 0, curJ = 0;
        while (curI != n - 1 || curJ != m - 1) {
            System.out.println( "(" + curI + "," + curJ + ")" );
            if (curJ == m - 1 || curI != n - 1 && path[curI + 1][curJ] == 0) {
                //向下
                curI++;
            } else if (curI == n - 1 || curJ != m - 1 && path[curI][curJ + 1] == 0) {
                //向右
                curJ++;
            }
        }
        System.out.println( "(" + curI + "," + curJ + ")" );
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print( matrix[i][j] + " " );
            }
            System.out.println();
        }
    }
}
