package contest.dynamicprogrammming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author onion
 * @date 2020/5/8 -9:25 上午
 *
 *  该题的目的是要你统计图的连通分支数。
 *  每个输入文件包含若干行，每行两个整数i,j，表示节点i和j之间存在一条边。
 */
public class 第一题 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        UnionFind unionFind = new UnionFind();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        while (s != null){
            String[] digit = s.split(" ");
            int a = Integer.parseInt(digit[0]);
            int b = Integer.parseInt(digit[1]);
            set.add(a);
            set.add(b);
            unionFind.union(a,b);
            s = br.readLine();
        }
        for (int i : set){
            if (unionFind.find(i) == i)
                count++;
        }
        System.out.println(count);
    }
    static class UnionFind {
        private Map<Integer,Integer> parent;
        public UnionFind(){
            parent = new HashMap<>();
        }
        public int find(int p){
            if (p != parent.get(p))
                parent.put(p,find(parent.get(p)));
            return parent.get(p);
        }
        public void union(int p, int q) {
            if(!parent.containsKey(p))
                parent.put(p, p);
            if (!parent.containsKey(q))
                parent.put(q, q);
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot)
                return;
            parent.put(pRoot,qRoot);
        }
    }

}
