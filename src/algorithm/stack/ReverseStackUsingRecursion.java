package algorithm.stack;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/26 -7:36 下午
 * 使用一个栈和递归逆序一个栈
 */
public class ReverseStackUsingRecursion {
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty())
            return;
        int bottom = popBottomElement(stack);
        reverse(stack);
        stack.push(bottom);
    }
    private static int popBottomElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty())
            return result;
        int last = popBottomElement(stack);
        stack.push(result);
        return last;
    }
}
