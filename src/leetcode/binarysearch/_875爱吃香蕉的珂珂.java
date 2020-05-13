package leetcode.binarysearch;

/**
 * @author onion
 * @date 2020/5/1 -12:51 下午
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 */
public class _875爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = findMax(piles);
        while(left < right) {
            int mid = (left + right)/2;
            if(canFinish(piles, mid, H))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    private int findMax(int[] piles){
        int res = piles[0];
        for(int i = 1; i < piles.length; i++)
            res = Math.max(res, piles[i]);
        return res;
    }
    private boolean canFinish(int[] piles, int speed, int h){
        int time = 0;
        for(int p : piles)
            time += p/speed + (p%speed == 0 ? 0 : 1);
        return time <= h;
    }
}
