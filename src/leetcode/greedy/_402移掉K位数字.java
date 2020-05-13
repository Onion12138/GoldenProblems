package leetcode.greedy;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/5/13 -8:59 上午
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 */
public class _402移掉K位数字 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > n && k > 0){
                stack.pop();
                k--;
            }
            if (!stack.isEmpty() || n != 0)
                stack.push(n);
        }
        while (!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stack)
            sb.append(i);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
