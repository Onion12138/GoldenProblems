package leetcode.twopointer.collision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/30 -3:55 下午
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class _15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                break;
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int num = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if(nums[j] + nums[k] < num)
                    j++;
                else if(nums[j] + nums[k] > num)
                    k--;
                else{
                    ret.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j+1 < nums.length && nums[j+1] == nums[j])
                        j++;
                    while(k-1 >= 0 && nums[k] == nums[k-1])
                        k--;
                    j++;
                    k--;
                }
            }
        }
        return ret;
    }
}
