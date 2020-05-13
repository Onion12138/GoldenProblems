package leetcode.heap;

import java.util.*;

/**
 * @author onion
 * @date 2020/4/27 -9:43 上午
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class _692前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>(k);
        Map<String,Integer> map = new HashMap<>();
        for(String s : words)
            map.put(s, map.getOrDefault(s, 0)+1);
        //小根堆
        Queue<String> queue = new PriorityQueue<>((w1, w2)-> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for(String s : map.keySet()){
            queue.offer(s);
            if(queue.size() > k)
                queue.poll();
        }
        while (!queue.isEmpty())
            ret.add(queue.poll());
        Collections.reverse(ret);
        return ret;
    }
}
