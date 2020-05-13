package leetcode.dynamicprogramming.sequence;

/**
 * @author onion
 * @date 2020/5/4 -9:38 上午
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 */
public class _5最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0)
            return "";
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] &&  j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }
}
