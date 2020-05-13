package leetcode.linklist.twopointer;

import leetcode.common.ListNode;

/**
 * @author onion
 * @date 2020/4/27 -11:17 上午
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 */
public class _142环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode intersect = getIntersection(head);
        if(intersect == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = intersect;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    private ListNode getIntersection(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return slow;
        }
        return null;
    }
}
