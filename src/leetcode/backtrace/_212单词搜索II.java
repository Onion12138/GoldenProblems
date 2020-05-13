package leetcode.backtrace;

import java.util.*;

/**
 * @author onion
 * @date 2020/5/11 -10:26 下午
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 */
public class _212单词搜索II {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String s : words)
            trie.add(s);
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                String s = String.valueOf(board[i][j]);
                if(trie.isPrefix(s)){
                    visited[i][j] = true;
                    dfs(board, s, trie, i, j);
                    visited[i][j] = false;
                }
            }
        }
        List<String> res = new ArrayList<>(ret);
        res.sort(String::compareTo);
        return res;
    }
    private int m;
    private int n;
    private boolean[][] visited;
    private Set<String> ret = new HashSet<>();
    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(char[][] board, String s, Trie trie, int x, int y) {
        if(trie.contains(s)){
            ret.add(s);
        }
        for(int i = 0; i < dir.length; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(0 <= nx && nx < m && 0 <= ny && ny < n && !visited[nx][ny] && trie.isPrefix(s+board[nx][ny])){
                visited[nx][ny] = true;
                dfs(board, s+board[nx][ny], trie, nx, ny);
                visited[nx][ny] = false;
            }
        }
    }
}
class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie(){
        root = new Node();
        size = 0;
    }
    public void add(String word){
        Node cur = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if(!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }
    public boolean contains(String word){
        Node cur = root;
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}
