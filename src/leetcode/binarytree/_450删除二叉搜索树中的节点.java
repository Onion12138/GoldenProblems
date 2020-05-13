package leetcode.binarytree;

import leetcode.common.TreeNode;

/**
 * @author onion
 * @date 2020/5/1 -9:56 上午
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 */
public class _450删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key) {
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            TreeNode successor = getMin(root.right);
            successor.right = deleteMin(root.right);
            successor.left = root.left;
            return successor;
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    private TreeNode getMin(TreeNode root){
        while(root.left != null)
            root = root.left;
        return root;
    }
    private TreeNode deleteMin(TreeNode node){
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
}
