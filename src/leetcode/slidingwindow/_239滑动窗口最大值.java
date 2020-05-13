package leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author onion
 * @date 2020/4/26 -8:06 下午
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 */
public class _239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ret = new int[nums.length-k+1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(i >= k){
                if(nums[i-k] == queue.peekFirst())
                    queue.removeFirst();
            }
            while(!queue.isEmpty() && queue.peekLast() < nums[i])
                queue.removeLast();
            queue.addLast(nums[i]);
            if(i >= k-1)
                ret[index++] = queue.peekFirst();
        }
        return ret;
    }
    //存储下标
    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ret = new int[nums.length-k+1];
        for(int i = 0; i < nums.length; i++){
            if(i >= k && i-k == queue.peekFirst())
                queue.removeFirst();
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.removeLast();
            queue.addLast(i);
            if(i >= k-1)
                ret[i-k+1] = nums[queue.peekFirst()];
        }
        return ret;
    }
}
