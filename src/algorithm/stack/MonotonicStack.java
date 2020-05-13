package algorithm.stack;

import algorithm.annotation.Application;
import algorithm.annotation.Note;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/5/1 -10:20 上午
 */
@Application("Leetcode 503题")
public class MonotonicStack {
    @Note("找到数组中右边第一个比当前元素大的元素")
    public int[] nextGreaterElement(int[] nums) {
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            ret[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ret;
    }
    @Note("找到数组中右边第一个比当前元素大的间隔")
    public int[] nextGreaterInterval(int[] nums) {
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            ret[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(nums[i]);
        }
        return ret;
    }
}
