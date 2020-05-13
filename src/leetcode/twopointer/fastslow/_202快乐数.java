package leetcode.twopointer.fastslow;

/**
 * @author onion
 * @date 2020/4/30 -8:46 上午
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 */
public class _202快乐数 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(bitSquareSum(fast));
        }while(fast != slow);
        return slow == 1;
    }
    private int bitSquareSum(int n){
        int ret = 0;
        while(n != 0){
            int mod = n % 10;
            ret += mod * mod;
            n /= 10;
        }
        return ret;
    }
}
