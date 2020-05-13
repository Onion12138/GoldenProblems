package leetcode.dynamicprogramming.zeroonebag;

/**
 * @author onion
 * @date 2020/5/11 -8:08 下午
 *
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class _1277统计全为1的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    }
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
