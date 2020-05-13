package leetcode.dynamicprogramming.sequence;

/**
 * @author onion
 * @date 2020/4/26 -2:56 下午
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 */
public class _97交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int a = s1.length();
        int b = s2.length();
        if(a+b != s3.length())
            return false;
        boolean[][] dp = new boolean[a+1][b+1];
        dp[0][0] = true;
        for(int i=0;i<=a;i++){
            for(int j=0;j<=b;j++){
                if(i>0 && s3.charAt(i+j-1)==s1.charAt(i-1))
                    dp[i][j] |= dp[i-1][j];
                if(j>0 && s3.charAt(i+j-1)==s2.charAt(j-1))
                    dp[i][j] |= dp[i][j-1];
            }
        }
        return dp[a][b];
    }
}
