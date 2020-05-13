package leetcode.dynamicprogramming.maximin;

import algorithm.annotation.AnotherSolution;
import algorithm.annotation.Recommend;

/**
 * @author onion
 * @date 2020/4/27 -3:07 下午
 *
 * 给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 */
public class _486预测赢家 {
    @Recommend(complexity = "n^2")
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n]; //dp表示先手最多赢多少
        int sum = 0;
        for(int i : nums)
            sum += i;
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++) {
                if(j == i){
                    dp[i][j] = nums[i];
                    continue;
                }
                if(j == i+1){
                    dp[i][j] = Math.max(nums[i],nums[j]);
                    continue;
                }
                dp[i][j] = Math.max(nums[i]+Math.min(dp[i+2][j],dp[i+1][j-1]),
                        nums[j]+Math.min(dp[i+1][j-1],dp[i][j-2]));
            }
        }
        return dp[0][n-1] >= sum - dp[0][n-1];
    }
    @Recommend(complexity = "n^2")
    public boolean PredictTheWinnerFirstAndSecond(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for(int i = n-1; i >= 0; i--){
            f[i][i] = nums[i];
            for(int j = i+1; j < n; j ++){
                f[i][j] = Math.max(nums[i]+s[i+1][j],nums[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return f[0][n-1] >= s[0][n-1];
    }
    @AnotherSolution(complexity = "2^n")
    public boolean PredictTheWinnerRecursion(int[] nums) {
        return first(nums,0,nums.length-1) >= second(nums,0,nums.length-1);
    }
    private int first(int[] nums, int l, int r) {
        if(l == r)
            return nums[l];
        return Math.max(nums[l]+second(nums,l+1,r),nums[r]+second(nums,l,r-1));
    }
    private int second(int[] nums, int l, int r) {
        if(l == r)
            return 0;
        return Math.min(first(nums, l+1, r),first(nums, l, r-1));
    }
}
