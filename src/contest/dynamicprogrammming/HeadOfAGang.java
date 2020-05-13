package contest.dynamicprogrammming;

import java.util.*;

/**
 * @author onion
 * @date 2020/5/8 -11:48 上午
 */
public class HeadOfAGang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; i++) {
            String a = scanner.next();
            String b = scanner.next();
            int t = scanner.nextInt();
            uf.union(a,b,t);
        }
        List<Pair> list = new ArrayList<>();
        for (Set<String> set : uf.groupSet()){
            int max = 0;
            String mx = null;
            int total = 0;
            if (set.size() < 3)
                continue;
            for (String s : set) {
                int time = uf.getTime(s);
                if (time > max){
                    max = time;
                    mx = s;
                }
                total += time;
            }
            if (total/2 > k && mx != null){
                list.add(new Pair(mx,set.size()));
            }
        }
        list.sort(Comparator.comparing(o -> o.string));
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
class Pair{
    String string;
    int number;
    Pair(String string, int number){
        this.string = string;
        this.number = number;
    }
    public String toString() {
        return string + " " + number;
    }
}
class UnionFind{
    Map<String,String> map;
    Map<String,Integer> time;
    Map<String,Set<String>> group;
    public Collection<Set<String>> groupSet() {
        return group.values();
    }
    public int getTime(String key) {
        return time.get(key);
    }
    public UnionFind() {
        map = new HashMap<>();
        time = new HashMap<>();
        group = new HashMap<>();
    }
    public String find(String p){
        if (!p.equals(map.get(p))) {
            map.put(p, find(map.get(p)));
        }
        return map.get(p);
    }
    public void union(String a, String b, int t) {
        if (!map.containsKey(a))
            map.put(a,a);
        if (!map.containsKey(b))
            map.put(b,b);
        time.put(a,time.getOrDefault(a,0)+t);
        time.put(b,time.getOrDefault(b,0)+t);
        String pa = find(a);
        String pb = find(b);
        if (!group.containsKey(pa) && group.containsKey(pb)){
            group.get(pb).add(a);
            map.put(a,pb);
            return;
        }
        if (!group.containsKey(pa)){
            Set<String> set = new HashSet<>();
            set.add(pa);
            group.put(pa, set);
        }
        Set<String> g = group.get(pa);
        g.add(b);
        if (group.containsKey(pb)) {
            g.addAll(group.get(pb));
            group.remove(pb);
        }
        group.put(pa, g);
        if (pa.equals(pb))
            return;
        map.put(b,pa);
    }
}

