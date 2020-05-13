package contest.dynamicprogrammming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author onion
 * @date 2020/5/5 -9:24 下午
 *
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）
 * 5，1，1和1，5，1 是同一种分法。
 */
public class 放苹果 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] s=reader.readLine().split(" ");
        int m=Integer.parseInt(s[0]);
        int n=Integer.parseInt(s[1]);
        int result=put(m,n);
        System.out.println(result);
    }
    public static int put(int m,int n){
        if(m == 0 || n == 1)
            return 1;
        if(n > m)
            return put(m,m);
        return put(m,n-1)+put(m-n,n);
    }
}
