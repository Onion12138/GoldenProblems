package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:26 下午
 * 给出一个区间的集合，请合并所有重叠的区间。
 */

public class _56合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1)
            return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int i = 0;
        while(i < intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length -1 && right >= intervals[i+1][0]){
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
