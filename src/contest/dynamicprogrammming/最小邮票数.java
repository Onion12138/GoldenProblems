package contest.dynamicprogrammming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author onion
 * @date 2020/5/5 -8:10 下午
 */
public class 最小邮票数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int c = scanner.nextInt();
            int n = scanner.nextInt();
            int[] cash = new int[n];
            for (int i = 0; i < n; i++) {
                cash[i] = scanner.nextInt();
            }
            int[] dp = new int[c+1];
            Arrays.fill(dp, n+1);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = c; j >= cash[i]; j--) {
                    dp[j] = Math.min(dp[j],dp[j-cash[i]]+1);
                }
            }
            System.out.println(dp[c]==n+1 ? 0 : dp[c]);
        }
    }

}
