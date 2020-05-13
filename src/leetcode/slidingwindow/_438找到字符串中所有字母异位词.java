package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/27 -11:30 上午
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 *
 */
public class _438找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] need = new int[128];
        int[] window = new int[128];
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<p.length();i++)
            need[p.charAt(i)]++;
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(need[ch] > window[ch])
                count++;
            window[ch]++;
            if(right - left + 1 == p.length()){
                if(count == p.length())
                    ret.add(left);
                ch = s.charAt(left);
                window[ch] --;
                if(need[ch] > 0 && window[ch] < need[ch]){
                    count--;
                }
                left++;
            }
            right++;
        }
        return ret;
    }
}
