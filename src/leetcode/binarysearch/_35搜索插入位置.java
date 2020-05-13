package leetcode.binarysearch;

/**
 * @author onion
 * @date 2020/4/27 -10:57 上午
 */
public class _35搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] < target)
                l = mid + 1;
            else if(nums[mid] > target)
                r = mid - 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
