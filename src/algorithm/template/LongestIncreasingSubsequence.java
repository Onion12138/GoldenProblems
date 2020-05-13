package algorithm.template;

import algorithm.annotation.Application;

import java.util.Arrays;

/**
 * @author onion
 * @date 2020/4/27 -11:55 上午
 */
@Application("Leetcode 300题/354题")
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int idx = Arrays.binarySearch(res, 0, len, num);
            idx = idx < 0? -idx - 1: idx;
            res[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
    public int LIS(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for (int poker : nums) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles)
                piles++;
            top[left] = poker;
        }
        return piles;
    }
}
