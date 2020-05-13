package contest.greedy;

import java.util.*;

/**
 * @author onion
 * @date 2020/5/12 -9:05 下午
 */
public class FillOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int avg = scanner.nextInt();
        int n = scanner.nextInt();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double price = scanner.nextDouble();
            int distance = scanner.nextInt();
            list.add(new Pair(price,distance));
        }
        list.sort(Comparator.comparing(a -> a.price));
        int maxDistance = c * avg;
        double cost = 0.0;
        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(a->a.start));
        for (int i = 0; i < n; i++) {
            Pair pair = list.get(i);
            int need = (pair.distance+maxDistance < d ? maxDistance : d - pair.distance);
            int cnt = 0;
            Interval interval = new Interval(pair.distance,pair.distance+need);
            int len = 0;
            Iterator<Interval> iterator = queue.iterator();
            while (iterator.hasNext()){
                Interval cur = iterator.next();
                len += cur.end - cur.start;
                if (cur.start <= interval.end && cur.end >= interval.start){ //区间相交
                    iterator.remove();
                    int min = Math.min(cur.start,interval.start);
                    int max = Math.max(cur.end,interval.end);
                    interval = new Interval(min,max); //区间合并
                }
            }
            queue.offer(interval);
            int afterLen = 0;
            for (Interval next : queue) {
                afterLen += next.end - next.start;
            }
            cnt += afterLen - len; //前后区间差值即为加油量
            cost += cnt/(avg*1.0)*pair.price;
        }
        Interval interval = queue.poll(); //最后能行进的区间范围
        assert interval != null;
        if (interval.start == 0 && interval.end == d){
            System.out.printf("%.2f\n",cost);
        }else {
            System.out.printf("The maximum travel distance = %.2f\n",(double)interval.end);
        }
    }
}
class Pair{
    Double price;
    int distance;
    public Pair(Double price, int distance) {
        this.price = price;
        this.distance = distance;
    }
}
class Interval{
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
class Another{
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int avg = scanner.nextInt();
        int n = scanner.nextInt();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double price = scanner.nextDouble();
            int distance = scanner.nextInt();
            list.add(new Pair(price,distance));
        }
        list.sort(Comparator.comparing(a -> a.price));
        boolean[] visited = new boolean[d];
        int maxDistance = c * avg;
        double cost = 0.0;
        for (int i = 0; i < n; i++) {
            Pair pair = list.get(i);
            int need = (pair.distance+maxDistance < d ? maxDistance : d - pair.distance);
            int cnt = 0;
            for (int j = pair.distance; j < pair.distance+need; j++) {
                if (!visited[j]){
                    visited[j] = true;
                    cnt++;
                }
            }
            cost += cnt/(avg*1.0)*pair.price;
        }
        int i;
        for (i = 0; i < d; i++) {
            if (!visited[i]){
                System.out.printf("The maximum travel distance = %.2f\n",(double)i);
                break;
            }
        }
        if (i == d)
            System.out.printf("%.2f\n",cost);
    }
}
