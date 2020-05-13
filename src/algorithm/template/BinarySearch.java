package algorithm.template;

import algorithm.annotation.Application;
import algorithm.annotation.Recommend;

/**
 * @author onion
 * @date 2020/4/27 -10:12 上午
 * 二分查找模版
 * 为了简便，不考虑溢出问题
 */
public class BinarySearch {
    //搜索一个数索引，不存在则返回-1
    @Recommend
    public int basicBinarySearchClosedInterval(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    @Recommend
    @Application("Leetcode 35题")
    private int findSmallerNumberCount(int[] nums, int target) {
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
    @Recommend
    @Application("Leetcode 34题")
    private int binarySearchLeftBoundCloseInterval(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    @Recommend
    private int binarySearchRightBoundCloseInterval(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
    public int basicBinarySearchWithFix(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[left] == target ? left : -1;
    }
    private int binarySearchLeftBound(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r)/2;
            if (nums[mid] == target)
                r = mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        //此时l表示比target小的元素个数
        if (l == nums.length || nums[l] != target)
            return -1;
        return l;
    }
    private int binarySearchRightBound(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r)/2;
            if (nums[mid] == target)
                l = mid + 1;
            else if (nums[mid] < target)
                r = mid;
            else
                l = mid + 1;
        }
        if (l == 0 || nums[l-1] != target)
            return -1;
        return l - 1;
    }
}
