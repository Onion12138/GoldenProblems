package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:13 下午
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 */
public class _39组合总和 {
    private List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(),0);
        return ret;
    }
    private void helper(int[] candidates, int target, List<Integer> list, int start){
        if(target == 0){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(target >= candidates[i]){
                list.add(candidates[i]);
                helper(candidates, target-candidates[i],list,i);
                list.remove(list.size()-1);
            }
        }
    }
}
