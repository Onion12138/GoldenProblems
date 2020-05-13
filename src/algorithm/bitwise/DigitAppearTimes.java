package algorithm.bitwise;

/**
 * @author onion
 * @date 2020/4/28 -10:07 上午
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class DigitAppearTimes {
    public int[] singleNumbers(int[] nums) {
        int[] ret = new int[2];
        int xor = 0;
        for (int num : nums) xor ^= num;
        int first = 1;
        while((xor ^ first) == 0)
            first = first << 1;
        for (int num : nums) {
            if ((num ^ first) == 0)
                ret[0] ^= num;
            else
                ret[1] ^= num;
        }
        return ret;
    }
}
