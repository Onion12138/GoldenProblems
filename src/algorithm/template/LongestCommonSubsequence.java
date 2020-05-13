package algorithm.template;

/**
 * @author onion
 * @date 2020/5/5 -7:49 下午
 */
public class LongestCommonSubsequence {
    public void getLengthAndPrintSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        int[][] path = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    path[i][j] = 1;
                }else if(dp[i-1][j] > dp[i][j-1]) {
                    dp[i][j] = dp[i-1][j];
                    path[i][j] = 2;
                }else{
                    dp[i][j] = dp[i][j-1];
                    path[i][j] = 3;
                }
            }
        }
        System.out.println(dp[m][n]);
        StringBuilder sb = new StringBuilder(dp[m][n]);
        while (m != 0 && n != 0) {
            if (path[m][n] == 1) {
                sb.append(a.charAt(m-1));
                m--;
                n--;
            } else if (path[m][n] == 2) {
                m--;
            } else {
                n--;
            }
        }
        System.out.println(sb.reverse());
    }
}
