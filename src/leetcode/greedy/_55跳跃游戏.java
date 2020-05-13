package leetcode.greedy;

/**
 * @author onion
 * @date 2020/4/26 -2:24 下午
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 */
public class _55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int far = 0;
        for(int i=0;i<nums.length;i++){
            if(i > far)
                return false;
            far = Math.max(far, i + nums[i]);
            if(far >= nums.length)
                return true;
        }
        return true;
    }
}
