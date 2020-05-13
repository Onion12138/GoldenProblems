package leetcode.statemachine;

import algorithm.annotation.AnotherSolution;

/**
 * @author onion
 * @date 2020/4/30 -9:21 上午
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 */
public class _309最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0)
            return 0;
        int[][] dp = new int[n][3];
        dp[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][2],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            dp[i][2] = dp[i-1][1]+prices[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][2]);
    }
    @AnotherSolution
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;
        int dp2 = 0;
        for (int price : prices) {
            int temp0 = dp0;
            int temp1 = dp1;
            dp0 = Math.max(dp2, dp0);
            dp1 = Math.max(temp0 - price, dp1);
            dp2 = temp1 + price;
        }
        return Math.max(dp0, dp2);
    }
}
