package leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:23 下午
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class _47全排列II {
    private List<List<Integer>> ret;
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ret = new ArrayList<>();
        used = new boolean[nums.length];
        helper(nums,new ArrayList<>());
        return ret;
    }
    private void helper(int[] nums,List<Integer> list){
        if(list.size() == nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                if(i>0 && nums[i]==nums[i-1] && !used[i-1])
                    continue;
                list.add(nums[i]);
                used[i] = true;
                helper(nums,list);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}
