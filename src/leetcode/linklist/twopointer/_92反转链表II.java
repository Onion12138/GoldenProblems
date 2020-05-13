package leetcode.linklist.twopointer;

import algorithm.annotation.AnotherSolution;
import leetcode.common.ListNode;

/**
 * @author onion
 * @date 2020/4/26 -2:53 下午
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class _92反转链表II {
    ListNode successor = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1)
            return reverseN(head, n);
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    @AnotherSolution
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=1;i<m;i++)
            pre = pre.next;
        ListNode cur = pre.next;
        for(int i=m;i<n;i++){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
