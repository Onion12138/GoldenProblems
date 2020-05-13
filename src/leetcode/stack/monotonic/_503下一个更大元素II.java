package leetcode.stack.monotonic;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/5/1 -10:28 上午
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 *
 */
public class _503下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 2*n-1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%n])
                stack.pop();
            ret[i%n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return ret;
    }
}
