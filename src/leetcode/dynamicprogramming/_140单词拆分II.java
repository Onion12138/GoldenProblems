package leetcode.dynamicprogramming;

import java.util.*;

/**
 * @author onion
 * @date 2020/5/11 -7:14 下午
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 */
public class _140单词拆分II {
    private HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return backtrace(s,dict,0);
    }
    private List<String> backtrace(String s, Set<String> dict, int start) {
        List<String> ret = new ArrayList<>();
        if (start == s.length()){
            ret.add("");
            return ret;
        }
        if (map.containsKey(start))
            return map.get(start);
        for (int i = start+1; i <= s.length(); i++) {
            String word = s.substring(start,i);
            if (dict.contains(word)){
                List<String> list = backtrace(s, dict, i);
                for (String string : list) {
                    ret.add(word + (string.equals("") ? "" : " " + string));
                }
            }
        }
        map.put(start,ret);
        return ret;
    }
}
