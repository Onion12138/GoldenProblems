package algorithm.template;

import algorithm.annotation.Application;
import algorithm.annotation.Note;
import leetcode.common.ListNode;

/**
 * @author onion
 * @date 2020/4/28 -8:41 上午
 */
@Application("Leetcode 234题")
public class LinkedList {
    @Note("反转链表，迭代方法")
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    @Note("反转链表，递归方法")
    public ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode ret = reverseListRecursion(next);
        next.next = head;
        return ret;
    }
    @Note("查找链表中点偏左")
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    @Note("查找链表中点偏右")
    private ListNode endOfFirstHalfRight(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    ListNode successor = null;
    @Note("反转链表前N个节点")
    private ListNode reverseN(ListNode head, int n) {
        if (head == null)
            return null;
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
