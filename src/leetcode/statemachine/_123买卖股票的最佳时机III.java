package leetcode.statemachine;

/**
 * @author onion
 * @date 2020/4/30 -9:56 上午
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class _123买卖股票的最佳时机III {
    /*
    * dp[i][2][0] = max(dp[i-1][2][0],dp[i-1][2][1]+prices[i])
    * dp[i][2][1] = max(dp[i-1][2][1],dp[i-1][1][0]-prices[i])
    * dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][1][1]+prices[i])
    * dp[i][1][1] = max(dp[i-1][1][1],-prices[i])
    * */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp10 = 0;
        int dp11 = Integer.MIN_VALUE;
        int dp20 = 0;
        int dp21 = Integer.MIN_VALUE;
        for(int price : prices){
            dp20 = Math.max(dp20,dp21+price);
            dp21 = Math.max(dp21,dp10-price);
            dp10 = Math.max(dp10,dp11+price);
            dp11 = Math.max(dp11,-price);
        }
        return dp20;
    }
}
