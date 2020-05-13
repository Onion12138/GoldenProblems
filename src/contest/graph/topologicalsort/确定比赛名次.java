package contest.graph.topologicalsort;

import java.util.*;

/**
 * @author onion
 * @date 2020/5/9 -8:27 上午
 */
public class 确定比赛名次 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer>[] set = new HashSet[n];
        for (int i = 0; i < n; i++) {
            set[i] = new HashSet<>();
        }
        int[] inDegree = new int[n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            set[a].add(b);
            inDegree[b]++;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int cur = queue.poll();
            result.add(cur);
            for (int w : set[cur]){
                inDegree[w] --;
                if (inDegree[w] == 0)
                    queue.offer(w);
            }
        }
        result.forEach(e->System.out.print((e+1) + " "));

    }
}
