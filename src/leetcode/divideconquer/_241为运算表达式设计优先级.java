package leetcode.divideconquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author onion
 * @date 2020/5/11 -8:31 下午
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 */
public class _241为运算表达式设计优先级 {
    private List<Character> operator = new ArrayList<>();
    private List<Integer> num = new ArrayList<>();
    private List<Integer>[][] memo;
    public List<Integer> diffWaysToCompute(String input) {
        split(input);
        int n = num.size();
        memo = new ArrayList[n][n];
        return conquer(0, n-1);
    }
    private List<Integer> conquer(int start, int end){
        if(memo[start][end] != null)
            return memo[start][end];
        if (start == end) {
            memo[start][end] = new ArrayList<>(Collections.singleton(num.get(start)));
            return memo[start][end];
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = start; i < end; i++){
            List<Integer> left = conquer(start, i);
            List<Integer> right = conquer(i+1, end);
            for(int l : left){
                for(int r : right){
                    ret.add(calculate(l, r, operator.get(i)));
                }
            }
        }
        return memo[start][end] = ret;
    }
    private int calculate(int l, int r, char operator){
        switch(operator){
            case '+':
                return l + r;
            case '-':
                return l - r;
            case '*':
                return l * r;
            default:
                return l + r;
        }
    }
    private void split(String input){
        int res = 0;
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                num.add(res);
                res = 0;
                operator.add(input.charAt(i));
            }else{
                res = 10 * res + input.charAt(i) - '0';
            }
        }
        num.add(res);
    }
}
