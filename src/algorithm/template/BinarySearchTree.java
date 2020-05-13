package algorithm.template;

import algorithm.annotation.Note;
import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/28 -2:10 下午
 */
public class BinarySearchTree {
    @Note("left mid right")
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            cur = cur.right;
        }
    }
    @Note("left right mid")
    public void postOrder(TreeNode root) {
        if (root != null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);
                if (root.left != null)
                    s1.push(root.left);
                if (root.right != null)
                    s1.push(root.right);
            }
            while (!s2.isEmpty())
                System.out.println(s2.pop().val);
        }
    }
    @Note("left right mid with one stack")
    public void postOrderOneStack(TreeNode root) {
        if (root != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if (c.left != null && root != c.left && root != c.right){
                    stack.push(c.left);
                }else if (c.right != null && root != c.right){
                    stack.push(c.right);
                }else{
                    System.out.println(stack.pop().val);
                    root = c;
                }
            }
        }
    }

    public void morrisIn(TreeNode head) {
        if (head == null)
            return;
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                } //左子树上最右节点
                if (cur2.right == null){
                    cur2.right = cur1; //第一次遇到cur1
                    cur1 = cur1.left;
                    continue;
                }else { //第二次遇到cur1
                    cur2.right = null;
                }
            }
            System.out.println(cur1.val);
            cur1 = cur1.right;
        }
    }
    public void morrisPre(TreeNode head) {
        if (head == null)
            return;
        TreeNode cur1 = head;
        TreeNode cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                } //左子树上最右节点
                if (cur2.right == null) {
                    cur2.right = cur1; //第一次遇到cur1
                    System.out.println(cur1.val);
                    cur1 = cur1.left;
                    continue;
                } else { //第二次遇到cur1
                    cur2.right = null;
                }
            }else {
                System.out.println(cur1.val);
            }
            cur1 = cur1.right;
        }
    }

    public static void morrisPos(TreeNode head) {
        if(head == null){
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right !=null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
    }
    public static void printEdge(TreeNode node){
        TreeNode tail =reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null ){
            System.out.println(cur.val);
            cur =cur.right;
        }
        reverseEdge(tail);
    }
    public static TreeNode reverseEdge(TreeNode node){
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null){
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
