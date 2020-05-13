package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:35 下午
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 */
public class _78子集 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, int start, ArrayList<Integer> list) {
        if(start == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        list.add(nums[start]);
        dfs(nums, start+1, list);
        list.remove(list.size()-1);
        dfs(nums, start+1, list);
    }
}
