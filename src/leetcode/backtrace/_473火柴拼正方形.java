package leetcode.backtrace;

import java.util.Arrays;

/**
 * @author onion
 * @date 2020/5/6 -6:24 下午
 *
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 */
public class _473火柴拼正方形 {
    public boolean makesquare(int[] nums) {
        if(nums.length < 4)
            return false;
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 4 != 0)
            return false;
        Arrays.sort(nums);
        return dfs(nums,nums.length-1,new int[4],sum/4);
    }
    private boolean dfs(int[] nums, int pos, int[] sum, int avg){
        if(pos == -1)
            return sum[0] == avg && sum[1] == avg && sum[2] == avg;
        for(int i = 0; i < 4; i++){
            if(sum[i] + nums[pos] > avg)
                continue;
            sum[i] += nums[pos];
            if(dfs(nums,pos-1,sum,avg))
                return true;
            sum[i] -= nums[pos];
        }
        return false;
    }
}
