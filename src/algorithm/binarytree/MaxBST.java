package algorithm.binarytree;

import leetcode.common.TreeNode;

/**
 * @author onion
 * @date 2020/4/28 -4:28 下午
 */
public class MaxBST {
    public TreeNode maxBinarySearchTree(TreeNode root){
        int[] record = new int[3];
        return helper(root,record);
    }
    private TreeNode helper(TreeNode head, int[] record){
        if (head == null){
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.val;
        TreeNode left = head.left;
        TreeNode right = head.right;
        TreeNode leftBST = helper(head.left,record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        TreeNode rightBST = helper(head.right,record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(lMin,rMin);
        record[2] = Math.min(lMax,rMax);
        if (left == leftBST && right == rightBST && lMax < value && value < rMin){
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize,rSize);
        return lSize > rSize ? leftBST : rightBST;
    }
}
