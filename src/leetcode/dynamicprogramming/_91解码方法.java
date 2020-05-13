package leetcode.dynamicprogramming;

/**
 * @author onion
 * @date 2020/4/26 -2:52 下午
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 */
public class _91解码方法 {
    public int numDecodings(String s) {
        int m = s.length();
        int[] dp = new int[m+1];
        dp[0] = 1;
        for(int i=1;i<=m;i++){
            if(s.charAt(i-1) != '0')
                dp[i] = dp[i-1];
            if(i>1 && (s.charAt(i-2) == '1' || (s.charAt(i-1) <= '6' && s.charAt(i-2) == '2')))
                dp[i] += dp[i-2];
        }
        return dp[m];
    }
}
