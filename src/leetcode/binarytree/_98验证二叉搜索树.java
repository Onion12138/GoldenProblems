package leetcode.binarytree;

import leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author onion
 * @date 2020/4/26 -2:57 下午
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class _98验证二叉搜索树 {
    double last = - Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(isValidBST(root.left)){
            if(last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val <= inorder)
                return false;
            inorder = cur.val;
            cur = cur.right;
        }
        return true;
    }
    public boolean isValidBST3(TreeNode root) {
        return isValidBST3(root, null, null);
    }
    private boolean isValidBST3(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null)
            return true;
        if(min != null && root.val <= min.val)
            return false;
        if(max != null && root.val >= max.val)
            return false;
        return isValidBST3(root.left,min,root) && isValidBST3(root.right,root,max);
    }
}
