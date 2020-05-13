package contest.tree;

/**
 * @author onion
 * @date 2020/5/9 -2:29 下午
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 二叉树遍历{
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String pre = scanner.next();
            String in = scanner.next();
            TreeNode root = build(pre,in);
            StringBuilder sb = new StringBuilder();
            post(root,sb);
            System.out.println(sb);
        }
    }
    private static TreeNode build(String str1, String str2){
        if (str1.length() == 0)
            return null;
        char c = str1.charAt(0);
        TreeNode root = new TreeNode(c);
        int pos = str2.indexOf(c+"");
        root.left = build(str1.substring(1,1+pos),str2.substring(0, pos));
        root.right = build(str1.substring(1+pos),str2.substring(pos+1));
        return root;
    }
    private static void post(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        post(root.left,sb);
        post(root.right,sb);
        sb.append(root.c);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != '#')
                    stack.push(string.charAt(i));
                else {
                    if (!stack.isEmpty()){
                        System.out.print(stack.pop() + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            Queue<Character> queue = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                queue.offer(s.charAt(i));
            }
            TreeNode root = buildTree(queue);
            StringBuilder sb = new StringBuilder();
            inOrder(root, sb);
            System.out.println(sb);
        }
    }
    private static void inOrder(TreeNode root, StringBuilder sb){
        if (root == null)
            return;
        inOrder(root.left,sb);
        sb.append(root.c);
        sb.append(" ");
        inOrder(root.right,sb);
    }
    private static TreeNode buildTree(Queue<Character> queue){
        if (queue.isEmpty())
            return null;
        if (queue.peek() == '#'){
            queue.poll();
            return null;
        }
        TreeNode root = new TreeNode(queue.poll());
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
class TreeNode{
    char c;
    TreeNode left;
    TreeNode right;
    public TreeNode(char c) {
        this.c = c;
    }
}




