package leetcode.math;

import algorithm.annotation.AnotherSolution;

/**
 * @author onion
 * @date 2020/5/4 -10:05 上午
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class _7整数反转 {
    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
            x /= 10;
        }
        return (int)res;
    }
    @AnotherSolution
    public int reverse2(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x = x / 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE%10))
                return 0;
            else if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE%10))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
