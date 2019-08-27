package 华为108;

/**
 * Created by fantuan on 2019/8/27.
 */
import java.util.Scanner;

public class simplePassword {
    /*
     * 题目描述
     *  1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
     *  小写字母都变成对应的数字，数字和其他的符号都不做变换，
     *  声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位
     */
    public static void main(String[] args) {
//        String s = "YUANzhi1987";
//        System.out.println(passwordChange(s));
//
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(passwordChange(s));
        }
        sc.close();
    }

    private static String passwordChange(String s) {
        String oldPassword = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String newPassword = "22233344455566677778889999bcdefghijklmnopqrstuvwxyza1234567890";

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < oldPassword.length(); j++) {
                if (oldPassword.charAt(j) == s.charAt(i)) {
//                    System.out.println(s.charAt(i)+":"+newPassword.charAt(j));
                    stringBuffer.append(newPassword.charAt(j));
                    break;
                }
            }
        }
        return stringBuffer.toString();

    }
}

