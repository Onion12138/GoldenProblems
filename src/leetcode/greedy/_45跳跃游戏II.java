package leetcode.greedy;

import algorithm.annotation.AnotherSolution;

/**
 * @author onion
 * @date 2020/5/4 -8:58 上午
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 */
public class _45跳跃游戏II {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int jump = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxPosition = Math.max(maxPosition, i+nums[i]);
            if(i == end){
                end = maxPosition;
                jump++;
            }
        }
        return jump;
    }
    @AnotherSolution
    public int jump2(int[] nums) {
        if(nums.length < 2)
            return 0;
        int curMax = nums[0];
        int preMax = nums[0];
        int jump = 1;
        for(int i = 1; i < nums.length; i++){
            if(i > curMax){
                jump++;
                curMax = preMax;
            }
            preMax = Math.max(preMax, nums[i]+i);
        }
        return jump;
    }
}
