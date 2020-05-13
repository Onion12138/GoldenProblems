package leetcode.dynamicprogramming.zeroonebag;

import algorithm.annotation.AnotherSolution;

/**
 * @author onion
 * @date 2020/5/4 -4:48 下午
 */
public class BackpackII {
    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        if(n == 0)
            return 0;
        int[][] dp = new int[n][m+1];
        for(int i = 0; i <= m; i++)
            dp[0][i] = i >= A[0] ? V[0] : 0;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= A[i]){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-A[i]]+V[i]);
                }
            }
        }
        return dp[n-1][m];
    }
    @AnotherSolution
    public int backPack(int m, int[] A, int[] V) {
        int n = A.length;
        if(n == 0)
            return 0;
        int[] dp = new int[m+1];
        for(int i = 0; i < n; i++)
            for(int j = m; j >= A[i]; j--)
                dp[j] = Math.max(dp[j],dp[j-A[i]]+V[i]);
        return dp[m];
    }
}
