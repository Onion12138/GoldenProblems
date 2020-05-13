package leetcode.twopointer;

/**
 * @author onion
 * @date 2020/4/26 -5:14 下午
 */
public class _680验证回文字符串II {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean isPalindrome(String s, int l, int r) {
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
