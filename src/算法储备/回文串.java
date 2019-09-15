package 算法储备;

/**
 * Created by fantuan on 2019/9/15.
 */
public class 回文串 {
    public static void main(String[] args) {

    }

//    回文子串个数的DP解法
    private static int dp(String s) {
        int n = s.length(), ans = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }

    //最长回文子串的DP解法
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        int maxLen = 1;
        String res = s.substring(0, 1);
        boolean[][] dp = new boolean[n][n];
        //左边界一定小于右边界，因此从右边界开始
        for (int r = 1; r < n; r++) { //表示右边界
            for (int l = 0; l < r; l++) { //表示左边界
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                if (s.charAt(l) == s.charAt(r) && ((r - l) <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                }
            }
        }
        return res;
    }

    //  Manachar算法主要是处理字符串中关于回文串的问题的，
    // 它可以在 O（n） 的时间处理出以字符串中每一个字符为中心的回文串半径，
    // 由于将原字符串处理成两倍长度的新串，在每两个字符之间加入一个特定的特殊字符，
    // 因此原本长度为偶数的回文串就成了以中间特殊字符为中心的奇数长度的回文串了。
    // Manacher算法提供了一种巧妙的办法，将长度为奇数的回文串和长度为偶数的回文串一起考虑，
    // 具体做法是，在原字符串的每个相邻两个字符中间插入一个分隔符，
    // 同时在首尾也要添加一个分隔符，分隔符的要求是不在原串中出现，一般情况下可以用#号。
    private static int manacher(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append( "#" );
            sb.append( s.charAt( i ) );
        }
        sb.append( "#" );
        char[] charArr = sb.toString().toCharArray();
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = R > i ? Math.min( radius[2 * c - i], R - i + 1 ) : 1;
            while (i + radius[i] < charArr.length && i - radius[i] > -1) {
                if (charArr[i - radius[i]] == charArr[i + radius[i]]) {
                    radius[i]++;
                } else {
                    break;
                }
            }
            if (i + radius[i] > R) {
                R = i + radius[i] - 1;
                c = i;
            }
            max = Math.max( max, radius[i] );
        }
        return max - 1;
    }
//    最长不连续回文子串
    public int longestPalindrome_discrete(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];//dp[l][r]表示l-r中的最长回文串
        for (int r = 0; r < n; r++) {
            dp[r][r] = 1;
            for (int l = r - 1; l >= 0; l--) {
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = dp[l + 1][r - 1] + 2;
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    private static boolean isSymmetricStr(String s) {
        StringBuffer stringBuffer = new StringBuffer( s );
        return stringBuffer.equals( stringBuffer.reverse() );
    }
}
