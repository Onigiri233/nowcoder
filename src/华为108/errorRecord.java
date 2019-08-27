package 华为108;

/**
 * Created by fantuan on 2019/8/27.
 */
import java.util.*;

/**
 * Created by fantuan on 2019/8/22.
 */
public class errorRecord {
    /*
     * 题目描述
     * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     * 处理：
     * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
     * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * 3、 输入的文件可能带路径，记录文件名称不能带路径。
     * 输入描述:
     * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
     * 输出描述:
     * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
     *
     */

    static LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();

    public static void main(String[] args) {
//        String s="E:\\V1R2\\product\\fpgadrive.c 1325";
//        recordErr(s);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            recordErr(s);
        }
        sc.close();

        int count=0;
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            count++;
            if (count > (hashMap.size() -8)){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    private static void recordErr(String s) {
        String filePath = s.split(" ")[0];
        String lineNum = s.split(" ")[1];
        String[] path = filePath.split("\\\\");
        String relativeFilePath = path[path.length - 1];
        if (relativeFilePath.length() > 16) {
            relativeFilePath = relativeFilePath.substring(relativeFilePath.length() - 16);
        }
        String key = relativeFilePath + " " + lineNum;

        if (hashMap.containsKey(key)) {
            hashMap.put(key, hashMap.get(key) + 1);
        }
        else {
            hashMap.put(key, 1);
        }
    }
}
