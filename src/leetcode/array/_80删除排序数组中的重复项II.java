package leetcode.array;

/**
 * @author onion
 * @date 2020/4/26 -2:41 下午
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 *
 */
public class _80删除排序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3)
            return nums.length;
        int i = 2;
        for (int j = 2; j < nums.length;j++)
            if (nums[j] > nums[i-2])
                nums[i++] = nums[j];
        return i;
    }
}
