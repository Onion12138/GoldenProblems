package leetcode.sort.quicksort;

/**
 * @author onion
 * @date 2020/4/26 -2:31 下午
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 */
public class _75颜色分类 {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for(int i=0;i < two;){
            if(nums[i] == 1)
                i++;
            else if(nums[i] == 2)
                swap(nums, i, --two);
            else
                swap(nums,++zero, i++);
        }
    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
