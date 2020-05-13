package leetcode.dynamicprogramming;

/**
 * @author onion
 * @date 2020/4/30 -3:15 下午
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 */
public class _198打家劫舍 {
    public int rob(int[] nums) {
        int pre = 0;
        int ppre = 0;
        int cur = 0;
        for (int num : nums) {
            cur = Math.max(pre, ppre + num);
            ppre = pre;
            pre = cur;
        }
        return cur;
    }
}
