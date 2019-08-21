package 校招19.华为;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/21.
 */
public class converseMessage {
    /**
     * 将给定的报文按规则转换成另一个报文后输出。
     * 转换规则如下：
     * 报文中如果出现0x0A，转义成为2个字节0x12 0x34，如果出现0x0B，转义成为2个字节0xAB 0xCD。
     */
    public static void main(String[] args) {
//        TODO:  网页端测试接口
//        Scanner sc = new Scanner(System.in);
//        String message = sc.nextLine();
//        String message = "8 1 2 3 4 5 6 A";
        String message = "9 1 1 2 3 4 5 6 A";

        System.out.println(messageReplace(message));
    }

    private static String messageReplace(String message) {
        String body=message.substring(2);
        String[] bodyS=body.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bodyS.length; i++) {
            if (Integer.valueOf(bodyS[i],16).equals(Integer.valueOf("A",16))){
                sb.append("12 34 ");
            }else if (Integer.valueOf(bodyS[i],16).equals(Integer.valueOf("B",16))){
                sb.append("AB CD ");
            }
            else{
                sb.append(bodyS[i]+" ");
            }
        }
        String messageRe= Integer.toString(sb.toString().split(" ").length+1, 16).toUpperCase() +" "+sb;
        return messageRe.trim();
    }
}
