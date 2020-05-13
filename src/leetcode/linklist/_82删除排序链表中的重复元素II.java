package leetcode.linklist;

import leetcode.common.ListNode;

/**
 * @author onion
 * @date 2020/4/26 -2:42 下午
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class _82删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head.next;
        if(cur.val != head.val){
            head.next = deleteDuplicates(head.next);
        }else{
            while(cur != null && cur.val == head.val){
                cur = cur.next;
            }
            head = deleteDuplicates(cur);
        }
        return head;
    }
}
