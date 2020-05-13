package leetcode.linklist.twopointer;

import leetcode.common.ListNode;

/**
 * @author onion
 * @date 2020/4/28 -9:06 上午
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class _160链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode curA = headA;
        while(curA != null){
            curA = curA.next;
            lenA ++;
        }
        int lenB = 0;
        ListNode curB = headB;
        while(curB != null){
            curB = curB.next;
            lenB ++;
        }
        curA = headA;
        curB = headB;
        if(lenA > lenB){
            int n = lenA - lenB;
            while(n > 0){
                curA = curA.next;
                n--;
            }
        }else{
            int n = lenB - lenA;
            while(n > 0){
                curB = curB.next;
                n--;
            }
        }
        while(curA != null && curB != null){
            if(curA == curB)
                return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
