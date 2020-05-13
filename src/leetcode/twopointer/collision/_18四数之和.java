package leetcode.twopointer.collision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author onion
 * @date 2020/5/4 -8:40 下午
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 */
public class _18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i+1; j < nums.length; j++){
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                int m = j+1;
                int n = nums.length-1;
                int sum = nums[i] + nums[j];
                while(m < n){
                    if(sum + nums[m] + nums[n] < target){
                        m++;
                    }else if(sum + nums[m] + nums[n] > target){
                        n--;
                    }else{
                        ret.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        while(m < n && nums[m] == nums[m+1])
                            m++;
                        while(m < n && nums[n] == nums[n-1])
                            n--;
                        m++;
                        n--;
                    }
                }
            }
        }
        return ret;
    }
}
