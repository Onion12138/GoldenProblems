package leetcode.array.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author onion
 * @date 2020/4/27 -11:42 上午
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class _560和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int ret = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                ret += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
