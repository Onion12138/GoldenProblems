package leetcode.math;

/**
 * @author onion
 * @date 2020/4/26 -2:22 下午
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class _50n次幂 {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0.0;
        long d = n;
        if(d < 0){
            x = 1/x;
            d = -d;
        }
        double res = 1.0;
        while(d > 0){
            if((d & 1) == 1)
                res *= x;
            x *= x;
            d >>= 1;
        }
        return res;
    }
}
