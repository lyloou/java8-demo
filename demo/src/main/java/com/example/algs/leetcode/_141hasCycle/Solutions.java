package com.example.algs.leetcode._141hasCycle;

/**
 * @author lyloou
 * @date 2019/12/16
 */
public class Solutions {
    public static void main(String[] args) {
        boolean i = new Solutions().hasCycle(new ListNode(1));
        System.out.println(i);
    }

    public boolean hasCycle(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return false;
        }
        ListNode slow = listNode; // slow 走1步
        ListNode fast = listNode.next; // fast 走2步
        while (slow.next != null && fast.next != null) {
            if (fast.val == slow.val) {
                return true;
            }
            fast = fast.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;

        }
        return false;
    }


}
