package leetcode.slidingwindow;

/**
 * @author onion
 * @date 2020/4/27 -11:31 上午
 */
public class _3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int l = 0, r = 0;
        int res = 0;
        while(r < s.length()){
            if(freq[s.charAt(r)] == 0)
                freq[s.charAt(r++)]++;
            else
                freq[s.charAt(l++)]--;
            res = Math.max(res, r-l);
        }
        return res;
    }
}
