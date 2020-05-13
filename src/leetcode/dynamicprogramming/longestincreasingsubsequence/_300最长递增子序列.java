package leetcode.dynamicprogramming.longestincreasingsubsequence;

import java.util.Arrays;

/**
 * @author onion
 * @date 2020/4/27 -11:46 上午
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class _300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int[] dp = new int[n];
        int res = 1;
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
    public int lengthOfLISEffective(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0? -idx - 1: idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
}
