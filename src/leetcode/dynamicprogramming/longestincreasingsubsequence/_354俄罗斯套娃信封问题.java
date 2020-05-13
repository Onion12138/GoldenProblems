package leetcode.dynamicprogramming.longestincreasingsubsequence;

import java.util.Arrays;

/**
 * @author onion
 * @date 2020/4/27 -11:57 上午
 */
public class _354俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->a[0]-b[0] == 0 ? b[1]-a[1] : a[0]-b[0]);
        int[] arr = new int[envelopes.length];
        int res = 0;
        for (int[] i : envelopes) {
            int idx = Arrays.binarySearch(arr, 0, res, i[1]);
            idx = idx < 0? - idx - 1: idx;
            arr[idx] = i[1];
            if (idx == res)
                res++;
        }
        return res;
    }
}
