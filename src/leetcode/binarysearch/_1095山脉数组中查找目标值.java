package leetcode.binarysearch;

/**
 * @author onion
 * @date 2020/4/29 -4:43 下午
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *  
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 *
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *
 */
public class _1095山脉数组中查找目标值 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length()-1;
        int peek = findPeek(mountainArr);
        int res = seekFromUpstair(mountainArr, l, peek, target);
        if(res != -1)
            return res;
        return seekFromDownstair(mountainArr, peek+1, r, target);
    }
    private int seekFromUpstair(MountainArray mountainArr, int l, int r, int target){
        while(l < r){
            int mid = (l+r)/2;
            if(mountainArr.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return mountainArr.get(l) == target ? l : -1;
    }
    private int seekFromDownstair(MountainArray mountainArr, int l, int r, int target){
        while(l < r){
            int mid = (l+r)/2;
            if(mountainArr.get(mid) > target)
                l = mid + 1;
            else
                r = mid;
        }
        return mountainArr.get(l) == target ? l : -1;
    }
    private int findPeek(MountainArray mountainArr){
        int l = 0, r = mountainArr.length()-1;
        while(l < r){
            int mid = (l+r)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1))
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }
}
interface MountainArray {
    int get(int index);
    int length();
}
