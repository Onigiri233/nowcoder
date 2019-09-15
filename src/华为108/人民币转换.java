package 华为108;

import java.util.Scanner;

/**
 * Created by fantuan on 2019/9/13.
 */
public class 人民币转换 {
    /**
     * 题目描述
     * 考试题目和要点：
     * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
     * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
     * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（
     * 输入描述:
     * 输入一个double数
     * 输出描述:
     * 输出人民币格式
     */
    static String[] aa = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    static String[] bb = new String[]{"", "拾", "佰", "仟"};
    static String[] cc = new String[]{"", "万", "亿", "万亿"};
    static String[] dd = new String[]{"角", "分"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(renmingbi(s));
        }
    }

    private static String renmingbi(String s) {
        String zhengshubufen = "";
        String xiaoshubufen = "";
        if (s.contains(".")) {
            zhengshubufen = s.split("\\.")[0];
            xiaoshubufen = s.split("\\.")[1];
        } else {
            zhengshubufen = s;
        }
        System.out.println(zhengshubufen);
        StringBuffer sb = new StringBuffer("人民币");
        int length = zhengshubufen.length() / 4;
        int yu = zhengshubufen.length() % 4;
        if (yu != 0) {
            length += 1;
        }
        String[] zhengshu4 = new String[length];
        for (int i = 0; i < length; i++) {
            if (zhengshubufen.length() > 4) {
                zhengshu4[i] = zhengshubufen.substring(zhengshubufen.length() - 4, zhengshubufen.length());
                zhengshubufen = zhengshubufen.substring(0, zhengshubufen.length() - 4);
            } else {
                zhengshu4[i] = zhengshubufen;
            }
        }

        for (int i = zhengshu4.length - 1; i >= 0; i--) {
            String zs = zhengshu4[i];
            for (int j = 0; j < zs.length(); j++) {
                sb.append(aa[Integer.parseInt(zs.charAt(j) + "")]);
                sb.append(bb[zs.length() - 1 - j]);
            }
            sb.append(cc[i]);
        }

        sb.append("元");

        if (!xiaoshubufen.isEmpty()) {
            for (int i = 0; i < xiaoshubufen.length(); i++) {
                sb.append(aa[Integer.parseInt(xiaoshubufen.charAt(i) + "")]);
                sb.append(dd[i]);
            }

        } else {
            sb.append("整");
        }
        return sb.toString();
    }


}
