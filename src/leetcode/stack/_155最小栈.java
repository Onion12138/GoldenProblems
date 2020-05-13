package leetcode.stack;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/26 -7:15 下午
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 */
public class _155最小栈 {
    private Stack<Integer> data;
    private Stack<Integer> min;
    public _155最小栈() {
        data = new Stack<>();
        min = new Stack<>();
    }
    public void push(int x) {
        data.push(x);
        if(min.isEmpty() || min.peek() > x)
            min.push(x);
        else
            min.push(min.peek());
    }
    public void pop() {
        data.pop();
        min.pop();
    }
    public int top() {
        return data.peek();
    }
    public int getMin() {
        return min.peek();
    }
}
