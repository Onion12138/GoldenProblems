package leetcode.linklist;

import leetcode.common.ListNode;

/**
 * @author onion
 * @date 2020/5/4 -9:07 下午
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 */
public class _25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode b = head;
        for(int i = 0; i < k; i++) {
            if(b == null)
                return head;
            b = b.next;
        }
        ListNode newHead = reverse(head, b);
        head.next = reverseKGroup(b, k);
        return newHead;
    }
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
