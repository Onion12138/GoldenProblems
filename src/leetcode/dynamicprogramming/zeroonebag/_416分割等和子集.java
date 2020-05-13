package leetcode.dynamicprogramming.zeroonebag;

/**
 * @author onion
 * @date 2020/5/4 -5:08 下午
 *
 * 给定一个只包含正整数的非空数组。
 * 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class _416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums)
            sum += n;
        if(sum % 2 != 0)
            return false;
        int c = sum/2;
        boolean[] dp = new boolean[c+1];
        for(int i = 0; i <= c; i++)
            dp[i] = (nums[0] == i);
        for(int i = 1; i < nums.length; i++)
            for(int j = c; j >= nums[i]; j--)
                dp[j] |= dp[j-nums[i]];
        return dp[c];
    }
}
