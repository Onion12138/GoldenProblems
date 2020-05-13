package leetcode.slidingwindow;

/**
 * @author onion
 * @date 2020/4/26 -2:32 下午
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class _76最小覆盖子串 {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length())
            return "";
        int[] needs = new int[128];
        int[] window = new int[128];
        for (int i = 0; i < t.length(); i++)
            needs[t.charAt(i)]++;
        int left = 0;
        int right = 0;
        String res = "";
        int count = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (needs[ch] > window[ch])
                count++;
            window[ch]++;
            while (count == t.length()){
                ch = s.charAt(left);
                window[ch]--;
                if (needs[ch] > window[ch])
                    count--;
                if ("".equals(res) || res.length() > right-left+1)
                    res = s.substring(left, right + 1);
                left++;
            }
            right++;
        }
        return res;
    }
}
