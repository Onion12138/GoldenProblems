package leetcode.statemachine;

/**
 * @author onion
 * @date 2020/4/30 -8:51 上午
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class _188买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(k > n/2)
            return maxProfitInfinite(prices);
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];
    }
    public int maxProfitInfinite(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i-1])
                res += prices[i]-prices[i-1];
        return res;
    }
}
