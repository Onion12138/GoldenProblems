package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * @author onion
 * @date 2020/5/5 -11:57 上午
 */
public class MaxMatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int[] ret = new int[4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr,0);
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[k] += matrix[j][k];
                }
                int[] result = maxSubArrayRange(arr);
                if(result[2] > max){
                    max = result[2];
                    ret[0] = i;
                    ret[1] = result[0];
                    ret[2] = j;
                    ret[3] = result[1];
                }
            }
        }
        return ret;
    }
    public int[] maxSubArrayRange(int[] nums) {
        int[] ret = new int[3];
        ret[2] = nums[0];
        int dp = nums[0];
        int begin = 0;
        for (int i = 1; i < nums.length; i++) {
            if(dp > 0)
                dp += nums[i];
            else{
                dp = nums[i];
                begin = i;
            }
            if(dp > ret[2]){
                ret[2] = dp;
                ret[1] = i;
                ret[0] = begin;
            }
        }
        return ret;
    }
}
