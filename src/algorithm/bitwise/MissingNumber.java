package algorithm.bitwise;

import algorithm.annotation.AnotherSolution;

/**
 * @author onion
 * @date 2020/5/1 -5:10 下午
 * 数组nums包含从0到n的所有整数，但其中缺了一个。
 * 请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        res ^= n;
        for(int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
    @AnotherSolution
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int res = 0;
        res += n;
        for(int i = 0; i < n; i++)
            res += i - nums[i];
        return res;
    }
}
