package leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author onion
 * @date 2020/4/26 -2:54 下午
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class _93复原IP地址 {
    private List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, "");
        return res;
    }
    private void dfs(String s, int start, int n, String temp){
        if(n==4){
            if(s.length() == start)
                res.add(temp);
            return;
        }
        for(int i=1;i < 4; i++){
            if(s.length() < i + start)
                return;
            String sub = s.substring(start, i+start);
            int value = Integer.parseInt(sub);
            if(value < 256 && sub.length() == (value + "").length()) {
                dfs(s, start+i, n+1, temp + sub + (n==3 ? "" : "."));
            }
        }
    }
}
