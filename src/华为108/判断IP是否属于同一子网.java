package 华为108;


import java.util.Scanner;

public class 判断IP是否属于同一子网 {
    /**
     *
     * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
     * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
     * 示例
     * I P 地址　 192.168.0.1
     * 子网掩码　 255.255.255.0
     * 转化为二进制进行运算：
     * I P 地址　11010000.10101000.00000000.00000001
     * 子网掩码　11111111.11111111.11111111.00000000
     * AND运算   11000000.10101000.00000000.00000000
     * 转化为十进制后为：192.168.0.0
     *
     * I P 地址　 192.168.0.254
     * 子网掩码　 255.255.255.0
     * 化为二进制进行运算：
     * I P 地址　11010000.10101000.00000000.11111110
     * 子网掩码　11111111.11111111.11111111.00000000
     * AND运算    11000000.10101000.00000000.00000000
     * 转化为十进制后为：192.168.0.0
     * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。

     /*
     * 功能: 判断两台计算机IP地址是同一子网络。
     * 输入参数：    String Mask: 子网掩码，格式：“255.255.255.0”；
     *               String ip1: 计算机1的IP地址，格式：“192.168.0.254”；
     *               String ip2: 计算机2的IP地址，格式：“192.168.0.1”；
     *

     * 返回值：      0：IP1与IP2属于同一子网络；     1：IP地址或子网掩码格式非法；    2：IP1与IP2不属于同一子网络
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String s=sc.nextLine();
            String mask=s.split( " " )[0];
            String ip1=s.split( " " )[1];
            String ip2=s.split( " " )[2];
            System.out.println(checkNetSegment( mask,ip1,ip2 ));
        }
    }

    private static int checkNetSegment(String mask, String ip1, String ip2) {
        if (!(checkIP( ip1 ) &&checkIP( ip2 )&&checkMask( mask ))){
            return 1;
        }
        StringBuffer sb_ip1 = new StringBuffer();
        StringBuffer sb_ip2 = new StringBuffer();
        String[] ip1S = ip1.split( "\\." );
        String[] ip2S = ip2.split( "\\." );
        String[] maskS = mask.split( "\\." );
        for (int i = 0; i < 4; i++) {
            int ip1I=Integer.parseInt( ip1S[i]);
            int ip2I=Integer.parseInt( ip2S[i]);
            int maskI=Integer.parseInt( maskS[i]);
            sb_ip1.append( ip1I&maskI );
            sb_ip2.append( ip2I&maskI );

            if (i!=3){
                sb_ip1.append( "." );
                sb_ip2.append( "." );
            }
        }
        if (sb_ip1.toString().equals( sb_ip2.toString() )){
            return 0;
        }else {
            return 2;
        }
    }
    private static boolean checkIP(String ipStr) {

        String ipPattern ="^((1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.){3}" +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        return ipStr.matches(ipPattern);
    }
    private static boolean checkMask(String maskStr) {
        if (!maskStr.matches("^((1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.){3}" +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")){
            return false;
        }else {
            String[] maskStrS = maskStr.split("\\.");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < maskStrS.length; i++) {
                String tempStr = Integer.toString(Integer.parseInt(maskStrS[i]), 2);
                if (tempStr.length() != 8) {
                    int length = tempStr.length();
                    for (int j = 0; j < 8 - length; j++) {
                        tempStr = "0" + tempStr;
                    }
                }
                sb.append(tempStr);
            }
//            255.255.255.255 是非法的!!!!!!!
            String maskPattern = "1*0+";
            return sb.toString().matches(maskPattern);
        }
    }
}
