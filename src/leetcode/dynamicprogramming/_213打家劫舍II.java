package leetcode.dynamicprogramming;

/**
 * @author onion
 * @date 2020/4/30 -3:20 下午
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 */
public class _213打家劫舍II {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    public int rob(int[] nums, int start, int end) {
        int pre = 0;
        int ppre = 0;
        int cur = 0;
        for (int i = start; i < end; i ++) {
            cur = Math.max(pre, ppre + nums[i]);
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}
