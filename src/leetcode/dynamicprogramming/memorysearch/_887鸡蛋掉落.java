package leetcode.dynamicprogramming.memorysearch;

/**
 * @author onion
 * @date 2020/4/27 -2:47 下午
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 */
public class _887鸡蛋掉落 {
    private int[][] memo;
    public int superEggDrop(int K, int N) {
        memo = new int[K+1][N+1];
        return dp(K, N);
    }
    private int dp(int k, int n) {
        if(k == 1)
            return n;
        if(n == 0)
            return 0;
        if(memo[k][n] != 0)
            return memo[k][n];
        int res = Integer.MAX_VALUE;
        int l = 1, r = n;
        while(l <= r){
            int mid = (l+r)/2;
            int broken = dp(k-1, mid-1);
            int unbroken = dp(k, n-mid);
            if(broken > unbroken){
                r = mid - 1;
                res = Math.min(res, broken+1);
            }else{
                l = mid + 1;
                res = Math.min(res, unbroken+1);
            }
        }
        return memo[k][n] = res;
    }
}
