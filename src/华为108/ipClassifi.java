package 华为108;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by fantuan on 2019/8/22.
 */
public class ipClassifi {
    /*
    *题目描述
    * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
    所有的IP地址划分为 A,B,C,D,E五类
    A类地址1.0.0.0~126.255.255.255;
    B类地址128.0.0.0~191.255.255.255;
    C类地址192.0.0.0~223.255.255.255;
    D类地址224.0.0.0~239.255.255.255；
    E类地址240.0.0.0~255.255.255.255

    私网IP范围是：
    10.0.0.0～10.255.255.255
    172.16.0.0～172.31.255.255
    192.168.0.0～192.168.255.255

    子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）

    输入描述:
    多行字符串。每行一个IP地址和掩码，用~隔开。
    输出描述:
    统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
    *
    *
    * */
    static int aIP = 0, bIP = 0, cIP = 0, dIP = 0, eIP = 0, personIP = 0, errIPMask = 0;

    public static void main(String[] args) throws IOException {
//        String s = "10.70.44.68~255.254.255.0";
//        System.out.println(ipClassed(s));

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            ipClassed(s);
//            System.out.println(ipClassed(s));
        }
        System.out.println(aIP + " " + bIP + " " + cIP + " " + dIP + " " + eIP + " " + errIPMask + " " + personIP);

    }

    private static String ipClassed(String s) {
        String ip = s.split("~")[0];
        String mask = s.split("~")[1];

        if ((checkIP(ip) && checkMask(mask))) {
            switch (ipCategory(ip)) {
                case 1:
                    aIP++;
                    break;
                case 2:
                    bIP++;
                    break;
                case 3:
                    cIP++;
                    break;
                case 4:
                    dIP++;
                    break;
                case 5:
                    eIP++;
                    break;
            }
            if (checkPersonIP(ip)) {
                personIP++;
            }
        } else {
//            System.out.println(ip+"-"+checkIP(ip)+"||"+mask+"-"+checkMask(mask));
            errIPMask++;
        }
        return aIP + " " + bIP + " " + cIP + " " + dIP + " " + eIP + " " + errIPMask + " " + personIP;
    }

    private static int ipCategory(String ip) {
        //        A类地址1.0.0.0~126.255.255.255;
        String ipA_Pattern = "^(1[01]\\d|12[0-6]|\\d{2}|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        //            B类地址128.0.0.0~191.255.255.255;
        String ipB_Pattern = "^(12[89]|1[3-8]\\d|19[01])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        //        C类地址192.0.0.0~223.255.255.255;
        String ipC_Pattern = "^(19[2-9]|2[01]\\d|22[123])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        //        D类地址224.0.0.0~239.255.255.255；
        String ipD_Pattern = "^(22[4-9]|23\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        //        E类地址240.0.0.0~255.255.255.255
        String ipE_Pattern = "^(24\\d|25[0-5])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        if (ip.matches(ipA_Pattern)) {
            return 1;
        } else if (ip.matches(ipB_Pattern)) {
            return 2;
        } else if (ip.matches(ipC_Pattern)) {
            return 3;
        } else if (ip.matches(ipD_Pattern)) {
            return 4;
        } else if (ip.matches(ipE_Pattern)) {
            return 5;
        }
        return -1;
    }

    private static boolean checkIP(String ipStr) {
//        0.0.0.0是合法的!!!
//        String ipPattern = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
//                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
//                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
//                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        String ipPattern ="^((1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.){3}" +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        return ipStr.matches(ipPattern);
    }

    private static boolean checkPersonIP(String ip) {
//        私网IP范围是：
//        10.0.0.0～10.255.255.255
//        172.16.0.0～172.31.255.255
//        192.168.0.0～192.168.255.255
        String ipPersonPattern_1 = "^10\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        String ipPersonPattern_2 = "^172\\."
                + "(1[6-9]|2\\d|3[01])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        String ipPersonPattern_3 = "^192\\."
                + "168\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        return ip.matches(ipPersonPattern_1) || ip.matches(ipPersonPattern_2) || ip.matches(ipPersonPattern_3);
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
