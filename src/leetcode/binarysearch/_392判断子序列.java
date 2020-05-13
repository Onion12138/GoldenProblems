package leetcode.binarysearch;

import algorithm.annotation.AnotherSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author onion
 * @date 2020/5/1 -5:46 下午
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 *
 */
public class _392判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for(int j = 0; i < s.length() && j < t.length(); j++)
            if(s.charAt(i) == t.charAt(j))
                i++;
        return i == s.length();
    }
    @AnotherSolution
    public boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();
        Map<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = t.charAt(i);
            if(!map.containsKey(c))
                map.put(c, new ArrayList<>());
            map.get(c).add(i);
        }
        int j = 0;
        for(int i = 0; i < m; i++){
            char c = s.charAt(i);
            if(!map.containsKey(c))
                return false;
            int pos = leftBound(map.get(c), j);
            if(pos == map.get(c).size())
                return false;
            j = map.get(c).get(pos) + 1;
        }
        return true;
    }
    private int leftBound(ArrayList<Integer> nums, int target) {
        int l = 0, r = nums.size()-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(nums.get(mid) < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
