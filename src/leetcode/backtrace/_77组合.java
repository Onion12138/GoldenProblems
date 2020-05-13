package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:34 下午
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class _77组合 {
    private List<List<Integer>> ret;
    public List<List<Integer>> combine(int n, int k) {
        ret = new ArrayList<>();
        helper(n,k,1,new ArrayList<>());
        return ret;
    }
    private void helper(int n, int k, int start, List<Integer> list){
        if(list.size() == k){
            ret.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);
            helper(n,k,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
