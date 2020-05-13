package leetcode.dynamicprogramming.path;

import algorithm.annotation.AnotherSolution;

import java.util.List;

/**
 * @author onion
 * @date 2020/5/5 -9:57 下午
 */
public class _120三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }
    @AnotherSolution
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];
        for (int i = triangle.size()-1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            dp[i] = new int[list.size()];
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = (i == triangle.size() - 1 ? 0 :Math.min(dp[i+1][j],dp[i+1][j+1]))+list.get(j);
            }
        }
        return dp[0][0];
    }
}
