package contest.graph.topologicalsort;

import java.util.*;

/**
 * @author onion
 * @date 2020/5/9 -9:22 上午
 */
public class Experiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        int[] cost = new int[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            graph[a].add(b);
            degree[b]++;
        }
        List<Integer> topology = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        int totalTime = 0;
        int[] earliest = new int[n];
        int[] latest = new int[n];
        while (!queue.isEmpty()){
            int u = queue.poll();
            topology.add(u);
            for (int v : graph[u]) {
                earliest[v] = Math.max(earliest[v], earliest[u]+cost[u]);
                degree[v] --;
                if (degree[v] == 0){
                    queue.offer(v);
                    totalTime = Math.max(totalTime,earliest[v]+cost[v]);
                }
            }
        }
        for (int i = topology.size()-1; i >= 0; i--) {
            int u = topology.get(i);
            if (graph[u].size() == 0){
                latest[u] = totalTime-cost[u];
            }else {
                latest[u] = Integer.MAX_VALUE;
            }
            for (int v : graph[u]) {
                latest[u] = Math.min(latest[u], latest[v]-cost[u]);
            }
        }
        System.out.println(totalTime);
    }
}
