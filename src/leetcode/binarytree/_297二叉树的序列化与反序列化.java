package leetcode.binarytree;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onion
 * @date 2020/4/28 -2:34 下午
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */
public class _297二叉树的序列化与反序列化 {
    class Codec {
        public String serialize(TreeNode root) {
            if (root == null)
                return "#_";
            return root.val + "_" + serialize(root.left) + serialize(root.right);
        }
        public TreeNode deserialize(String data) {
            String[] split = data.split("_");
            Queue<String> queue = new LinkedList<>();
            for (String s : split)
                queue.offer(s);
            return preConstruct(queue);
        }
        private TreeNode preConstruct(Queue<String> queue) {
            String value = queue.poll();
            if ("#".equals(value))
                return null;
            TreeNode ret = new TreeNode(Integer.parseInt(value));
            ret.left = preConstruct(queue);
            ret.right = preConstruct(queue);
            return ret;
        }
    }
}
