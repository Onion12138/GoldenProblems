package leetcode.stack.monotonic;

import algorithm.annotation.Similar;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/26 -9:00 下午
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 提示：将本题化归为84题
 */
@Similar("Leetcode 84题")
public class _85最大矩形 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        int[] height = new int[n];
        int ret = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            ret = Math.max(ret, maxArea(height));
        }
        return ret;
    }
    private int maxArea(int[] height) {
        int ret = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= height.length; i++){
            while(!stack.isEmpty() && (i == height.length || height[i] <= height[stack.peek()])){
                int h = stack.pop();
                int j = stack.isEmpty() ? -1 : stack.peek();
                ret = Math.max(ret, (i-j-1)*height[h]);
            }
            stack.push(i);
        }
        return ret;
    }
}
