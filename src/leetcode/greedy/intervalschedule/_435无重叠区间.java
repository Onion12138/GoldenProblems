package leetcode.greedy.intervalschedule;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author onion
 * @date 2020/4/27 -4:08 下午
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 */
public class _435无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int end = intervals[0][1];
        for(int[] interval : intervals){
            int start = interval[0];
            if(start >= end){
                count ++;
                end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
