package leetcode.unionfind;

import algorithm.template.UnionFind;

/**
 * @author onion
 * @date 2020/5/1 -5:29 下午
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。
 * 在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 */
public class _990方程的可满足性 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String str : equations){
            if(str.charAt(1) == '='){
                char a = str.charAt(0);
                char b = str.charAt(3);
                uf.unionElements(a-'a',b-'a');
            }
        }
        for(String str : equations){
            if(str.charAt(1) == '!'){
                char a = str.charAt(0);
                char b = str.charAt(3);
                if(uf.isConnected(a-'a',b-'a'))
                    return false;
            }
        }
        return true;
    }
}
