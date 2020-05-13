package algorithm.template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author onion
 * @date 2020/4/27 -11:33 上午
 */
public class TwoSum {
    Set<Integer> sum = new HashSet<>();
    List<Integer> nums = new ArrayList<>();
    public void add(int number){
        for (int i : nums) {
            sum.add(number + i);
        }
        nums.add(number);
    }
    //寻找当前数据结构中是否存在两个数和为value
    public boolean find(int value){
        return sum.contains(value);
    }
}
