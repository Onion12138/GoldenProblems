package leetcode.binarytree;

import leetcode.common.TreeNode;

/**
 * @author onion
 * @date 2020/4/28 -4:23 下午
 */
public class _543二叉树的直径 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
}
