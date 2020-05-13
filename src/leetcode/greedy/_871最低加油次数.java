package leetcode.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author onion
 * @date 2020/5/13 -9:52 上午
 *
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target 英里处。
 *
 * 沿途有加油站，每个 station[i] 代表一个加油站，它位于出发位置东面 station[i][0] 英里处，并且有 station[i][1] 升汽油。
 *
 * 假设汽车油箱的容量是无限的，其中最初有 startFuel 升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 *
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 *
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 *
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 *
 */
public class _871最低加油次数 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int cnt = 0;
        int distance = startFuel;
        for (int[] station : stations) {
            while (!queue.isEmpty() && distance < station[0]){
                distance += queue.poll();
                cnt ++;
            }
            if (distance < station[0])
                return -1;
            queue.offer(station[1]);
        }
        while(!queue.isEmpty() && distance < target){
            distance += queue.poll();
            cnt++;
        }
        return distance >= target ? cnt : -1;
    }
}
