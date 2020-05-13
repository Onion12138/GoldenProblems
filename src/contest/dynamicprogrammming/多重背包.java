package contest.dynamicprogrammming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author onion
 * @date 2020/5/5 -8:48 下午
 */
public class 多重背包 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int type = scanner.nextInt();
        int v, w, k;
        List<Integer> value = new ArrayList<>();
        List<Integer> weight = new ArrayList<>();
        for (int i = 0; i < type; i++) {
            v = scanner.nextInt();
            w = scanner.nextInt();
            k = scanner.nextInt();
            for (int j = 1; j <= k; j <<= 1) {
                value.add(j * v);
                weight.add(j * w);
                k -= j;
            }
            if (k > 0){
                value.add(k*v);
                weight.add(k*w);
            }
        }
        int[] dp = new int[money+1];
        for (int i = 0; i < value.size(); i++)
            for (int j = money; j >= value.get(i); j--)
                dp[j] = Math.max(dp[j],dp[j-value.get(i)]+weight.get(i));
        System.out.println(dp[money]);
    }
}
