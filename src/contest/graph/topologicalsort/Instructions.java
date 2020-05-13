package contest.graph.topologicalsort;

import java.util.*;

/**
 * @author onion
 * @date 2020/5/9 -8:48 上午
 */
public class Instructions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer> topology = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n];
        int[] earliest = new int[n];
        int[] latest = new int[n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int t = scanner.nextInt();
            graph[a].add(new Edge(b,t));
            inDegree[b] ++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0){
                queue.offer(i);
                earliest[i] = 1;
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            topology.add(cur);
            for (Edge edge : graph[cur]){
                int v = edge.to;
                int l = edge.length;
                earliest[v] = Math.max(earliest[v], earliest[cur] + l);
                inDegree[v] --;
                if (inDegree[v] == 0)
                    queue.offer(v);
            }
        }
        for (int i = topology.size()-1; i >= 0; i--) {
            int u = topology.get(i);
            if (graph[u].size() == 0){
                latest[u] = earliest[u];
            }else{
                latest[u] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < graph[u].size(); j++) {
                int v = graph[u].get(j).to;
                int l = graph[u].get(j).length;
                latest[u] = Math.min(latest[u], latest[v]-l);
            }
        }
        int res = 0;
        for (int value : earliest) {
            res = Math.max(res, value);
        }
        System.out.println(res);
    }
}
class Edge{
    int to;
    int length;
    public Edge(int to, int length) {
        this.to = to;
        this.length = length;
    }
}
