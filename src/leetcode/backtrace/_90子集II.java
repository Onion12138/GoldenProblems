package leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:51 下午
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class _90子集II {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, int start, ArrayList<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            dfs(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
