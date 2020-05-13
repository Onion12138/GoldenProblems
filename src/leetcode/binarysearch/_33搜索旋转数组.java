package leetcode.binarysearch;

/**
 * @author onion
 * @date 2020/4/27 -9:46 上午
 */
public class _33搜索旋转数组 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }else{
                if(nums[mid] < target && target <= nums[nums.length-1])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
