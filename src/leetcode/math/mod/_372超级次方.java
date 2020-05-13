package leetcode.math.mod;

/**
 * @author onion
 * @date 2020/4/26 -3:59 下午
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 提示：(a * b) % k = (a % k)(b % k) % k
 *
 */
public class _372超级次方 {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length-1);
    }
    private int superPow(int a, int[] b, int end){
        if(end == -1)
            return -1;
        int last = b[end];
        int part1 = power(a, last);
        int part2 = power(superPow(a,b,end-1),10);
        return (part1*part2)%base;
    }
    private int base = 1337;
    private int power(int a, int n) {
        a %= base;
        int res = 1;
        for(int i = 1; i <= n; i++){
            res *= a;
            res %= base;
        }
        return res;
    }
    //彩蛋：快速幂
    public int quickPow(int a, int k) {
        if (k == 0)
            return 1;
        if (k % 2 == 1) {
            return a * quickPow(a, k - 1);
        } else {
            int sub = quickPow(a, k / 2);
            return sub * sub;
        }
    }
}
