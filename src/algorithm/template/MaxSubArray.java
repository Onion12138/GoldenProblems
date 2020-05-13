package algorithm.template;

import algorithm.annotation.Application;
import algorithm.annotation.Note;

/**
 * @author onion
 * @date 2020/5/5 -11:59 上午
 */
@Application("Leetcode 面试题17.24")
public class MaxSubArray {
    @Note("返回3个值，分别为左右区间和最大子序和")
    public int[] maxSubArrayRange(int[] nums) {
        int[] ret = new int[3];
        ret[2] = nums[0];
        int dp = nums[0];
        int begin = 0;
        for (int i = 1; i < nums.length; i++) {
            if(dp > 0)
                dp += nums[i];
            else{
                dp = nums[i];
                begin = i;
            }
            if(dp > ret[2]){
                ret[2] = dp;
                ret[1] = i;
                ret[0] = begin;
            }
        }
        return ret;
    }
}
