package contest.dynamicprogrammming;

import java.util.Scanner;

/**
 * @author onion
 * @date 2020/5/5 -9:33 下午
 *
 * 一个整数总可以拆分为2的幂的和，例如： 7=1+2+4 7=1+2+2+2 7=1+1+1+4 7=1+1+1+2+2 7=1+1+1+1+1+2 7=1+1+1+1+1+1+1
 * 总共有六种不同的拆分方式。
 * 再比如：4可以拆分成：4 = 4，4 = 1 + 1 + 1 + 1，4 = 2 + 2，4=1+1+2。
 * 用f(n)表示n的不同拆分的种数，例如f(7)=6. 要求编写程序，读入n(不超过1000000)，输出f(n)%1000000000。
 */
public class 整数拆分 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i-1] + (i % 2 == 0 ? dp[i/2] : 0)) % 1000000000;
        System.out.println(dp[n]);
    }
}
