package leetcode.twopointer.collision;

import java.util.Arrays;

/**
 * @author onion
 * @date 2020/5/4 -8:29 下午
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
public class _16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target) < Math.abs(closeSum-target))
                    closeSum = sum;
                if(sum > target)
                    k--;
                else if(sum < target)
                    j++;
                else
                    return target;
            }
        }
        return closeSum;
    }
}
