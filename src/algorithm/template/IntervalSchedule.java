package algorithm.template;

import algorithm.annotation.Application;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author onion
 * @date 2020/4/27 -4:09 下午
 */
@Application("Leetcode  435题")
public class IntervalSchedule {
    public int intervalSchedule(int[][] intervals) {
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
        return count;
    }
}
