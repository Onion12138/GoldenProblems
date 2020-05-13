package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:19 下午
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class _46全排列 {
    private List<List<Integer>> ret;
    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        helper(nums,0);
        return ret;
    }
    private void helper(int[] nums,int start){
        if(start == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i : nums)
                list.add(i);
            ret.add(list);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,i, start);
            helper(nums,start+1);
            swap(nums,i,start);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
