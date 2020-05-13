package leetcode.dynamicprogramming.completebag;

import algorithm.annotation.Note;

/**
 * @author onion
 * @date 2020/4/26 -4:57 下午
 */
public class _518零钱兑换II {
    @Note("nums放在外循环，target在内循环。且内循环正序。")
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int x = coin; x < amount + 1; ++x)
                dp[x] += dp[x - coin];
        return dp[amount];
    }
}
