package leetcode.dynamicprogramming;

import algorithm.annotation.Recommend;
import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author onion
 * @date 2020/4/30 -3:30 下午
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 */
public class _337打家劫舍III {
    @Recommend
    public int rob2(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }
    private int[] dp(TreeNode root) {
        if(root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int rob = root.val + left[0] + right[0];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{notRob, rob};
    }
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(memo.containsKey(root))
            return memo.get(root);
        int a = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int b = rob(root.left) + rob(root.right);
        int res = Math.max(a, b);
        memo.put(root, res);
        return res;
    }

}

