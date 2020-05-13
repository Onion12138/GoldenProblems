package leetcode.stack;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/26 -7:29 下午
 */
public class _232用栈实现队列 {
    Stack<Integer> from;
    Stack<Integer> to;
    public _232用栈实现队列() {
        from = new Stack<>();
        to = new Stack<>();
    }
    public void push(int x) {
        while(!to.isEmpty()){
            from.push(to.pop());
        }
        from.push(x);
    }
    public int pop() {
        while(!from.isEmpty()){
            to.push(from.pop());
        }
        return to.pop();
    }
    public int peek() {
        while(!from.isEmpty()){
            to.push(from.pop());
        }
        return to.peek();
    }
    public boolean empty() {
        return from.isEmpty() && to.isEmpty();
    }
}
