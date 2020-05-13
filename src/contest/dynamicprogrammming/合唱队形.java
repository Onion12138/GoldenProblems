package contest.dynamicprogrammming;

import java.util.Scanner;

/**
 * @author onion
 * @date 2020/5/5 -6:16 下午
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学不交换位置就能排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1, 2, …, K，他们的身高分别为T1, T2, …, TK，
 * 则他们的身高满足T1 < T2 < … < Ti , Ti > Ti+1 > … > TK (1 <= i <= K)。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 */
public class 合唱队形 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] left = new int[n];
            int[] right = new int[n];
            int ans = n;
            for (int i = 0; i < n; i++) {
                left[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]){
                        left[i] = Math.max(left[i], left[j]+1);
                    }
                }
            }
            for (int i = n-1; i >= 0; i--) {
                right[i] = 1;
                for (int j = i+1; j < n; j++) {
                    if (arr[i] > arr[j]){
                        right[i] = Math.max(right[i], right[j]+1);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans,n-left[i]-right[i]+1);
            }
            System.out.println(ans);
        }
    }
}
