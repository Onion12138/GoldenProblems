package leetcode.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2020/5/5 -10:18 上午
 */
public class _986区间列表的交集 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length){
            int a0 = A[i][0];
            int a1 = A[i][1];
            int b0 = B[j][0];
            int b1 = B[j][1];
            if(b1 >= a0 && a1 >= b0)
                ret.add(new int[]{Math.max(a0,b0),Math.min(a1,b1)});
            if(b1 < a1)
                j++;
            else
                i++;
        }
        int[][] arr = new int[ret.size()][2];
        for(int k = 0; k < arr.length; k++)
            arr[k] = ret.get(k);
        return arr;
    }
}
