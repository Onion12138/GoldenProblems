package leetcode.stack.monotonic;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/26 -2:45 下午
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class _84柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int res = 0;
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || heights[i] < heights[stack.peek()])){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                res = Math.max(res, width*height);
            }
            stack.push(i);
        }
        return res;
    }
}

