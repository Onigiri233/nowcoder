package 华为108;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class 字符串加密黎明攻击 {
    /**
     * 题目描述
     * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
     * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
     * 请实现下述接口，通过指定的密匙和明文得到密文。
     * 详细描述：
     * <p>
     * 输入描述:
     * 先输入key和要加密的字符串
     * <p>
     * 输出描述
     * 返回加密后的字符串
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        while (sc.hasNext()) {
            String key = sc.nextLine();
            String text = sc.nextLine();
            System.out.println( encrypt( key, text ) );
        }
    }

    private static String encrypt(String key, String text) {
        StringBuffer stringBuffer = new StringBuffer();
        String codebook_text = "abcdefghijklmnopqrstuvwxyz";
        HashSet<String> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < key.length(); i++) {
            hashSet.add( key.charAt( i ) + "" );
        }
        for (int i = 0; i < 26; i++) {
            hashSet.add( codebook_text.charAt( i ) + "" );
        }
        for (int i = 0; i < text.length(); i++) {
            String theLetter = text.charAt( i ) + "";
            String upCase = "[A-Z]";

            if (theLetter.matches( upCase )) {
                int index = codebook_text.indexOf( theLetter.toLowerCase() );
                stringBuffer.append( (hashSet.toArray()[index] + "").toUpperCase());
            } else {
                int index = codebook_text.indexOf( theLetter );
                stringBuffer.append( hashSet.toArray()[index] + "" );
            }
        }
        return stringBuffer.toString();
    }
}
