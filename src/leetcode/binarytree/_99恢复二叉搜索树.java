package leetcode.binarytree;

import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/26 -2:59 下午
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 */
public class _99恢复二叉搜索树 {
    private void swap(TreeNode x, TreeNode y){
        int val = x.val;
        x.val = y.val;
        y.val = val;
    }
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, x = null, y = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val < pre.val){
                y = root;
                if(x == null)
                    x = pre;
            }
            pre = root;
            root = root.right;
        }
        swap(x, y);
    }
}
