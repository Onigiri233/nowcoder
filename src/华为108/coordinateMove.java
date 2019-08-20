package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class coordinateMove {

    /**
     * 题目描述
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     * <p>
     * 输入：
     * <p>
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     * <p>
     * 坐标之间以;分隔。
     * <p>
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     * 输入描述:
     * 一行字符串
     * 输出描述:
     * 最终坐标，以,分隔
     */
    public static void main(String[] args) {
// TODO: 2019/8/20  本地测试用例
//        String s = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
//        System.out.println(xyOfMove(s));

// TODO: 2019/8/20 网页端测试接口
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String  s = sc.nextLine();
            System.out.println(xyOfMove(s));
        }
    }

    private static String xyOfMove(String s) {
        int x=0,y=0;
        String []ss=s.split(";");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].matches("[wasdWASD]\\d{0,2}")){
                int move=Integer.valueOf(ss[i].substring(1));
                if (ss[i].startsWith("W")){
                    y+=move;
                }
                if (ss[i].startsWith("A")){
                    x-=move;
                }
                if (ss[i].startsWith("S")){
                    y-=move;
                }
                if (ss[i].startsWith("D")){
                    x+=move;
                }
            }
        }
        return x+","+y;
    }
}
