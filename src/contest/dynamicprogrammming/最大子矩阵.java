package contest.dynamicprogrammming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author onion
 * @date 2020/5/5 -10:55 上午
 *
 * 输入是一个N * N的矩阵。输入的第一行给出N (0 < N <= 100)。
 * 再后面的若干行中，依次（首先从左到右给出第一行的N个整数，再从左到右给出第二行的N个整数……）给出矩阵中的N2个整数，整数之间由空白字符分隔（空格或者空行）。
 * 已知矩阵中整数的范围都在[-127, 127]。
 */
public class 最大子矩阵 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int max = Integer.MIN_VALUE;
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i][j] = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(arr,0);
                for (int j = i; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        arr[k] += matrix[j][k];
                    }
                    max = Math.max(max,maxSubArray(arr));
                }

            }
            System.out.println(max);
        }
    }
    public static int maxSubArray(int[] nums) {
        int dp = nums[0];
        int ret = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (dp > 0)
                dp += nums[i];
            else
                dp = nums[i];
            ret = Math.max(ret, dp);
        }
        return ret;
    }
}
