package algorithm.template;

/**
 * @author onion
 * @date 2020/5/1 -5:25 下午
 */
public class UnionFind{
    private int[] parent;
    private int[] rank;
    public UnionFind(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    private int find(int p){
        if (p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        if(rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else if(rank[pRoot] > rank[qRoot])
            parent[qRoot] = pRoot;
        else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}

