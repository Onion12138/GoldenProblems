package leetcode.dynamicprogramming;

import algorithm.annotation.AnotherSolution;
import algorithm.annotation.Recommend;

/**
 * @author onion
 * @date 2020/5/3 -8:48 上午
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class _53最大子序和 {
    @Recommend
    public int maxSubArray1(int[] nums) {
        int dp = nums[0];
        int ret = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (dp > 0)
                dp += nums[i];
            else
                dp = nums[i];
            ret = Math.max(ret, dp);
        }
        return ret;
    }
    @AnotherSolution
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i]表示以i结尾的最大子数组和
        dp[0] = nums[0];
        int ret = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length-1);
    }
    private int maxSubArray(int[] nums, int left, int right) {
        if(left == right)
            return nums[left];
        int mid = (left + right)/2;
        int leftSum = maxSubArray(nums, left, mid);
        int rightSum = maxSubArray(nums, mid+1, right);
        int sum = 0;
        int crossLeft = Integer.MIN_VALUE;
        int crossRight = Integer.MIN_VALUE;
        for(int i = mid+1; i <= right; i++){
            sum += nums[i];
            crossRight = Math.max(crossRight, sum);
        }
        sum = 0;
        for(int i = mid; i >= left; i--) {
            sum += nums[i];
            crossLeft = Math.max(crossLeft, sum);
        }
        return Math.max(Math.max(leftSum,rightSum),crossLeft+crossRight);
    }
}
