package leetcode.stack;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/5/5 -10:06 上午
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。
 * 整数除法仅保留整数部分。
 */
public class _227基本计算器II {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + (c - '0');
            if((!Character.isDigit(c) && c != ' ')|| i == s.length() - 1){
                int pre;
                switch(sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre*num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre/num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty())
            res += stack.pop();
        return res;
    }
}
