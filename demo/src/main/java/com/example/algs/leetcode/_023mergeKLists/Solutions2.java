package com.example.algs.leetcode._023mergeKLists;

/**
 * @author lyloou
 * @date 2019/12/16
 */

import java.util.Arrays;

import static com.example.algs.leetcode._023mergeKLists.ListNode.getNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solutions2 {
    public static void main(String[] args) {
        ListNode node1 = getNode(Arrays.asList(1, 4, 5));
        ListNode node2 = getNode(Arrays.asList(1, 3, 4));
        ListNode node3 = getNode(Arrays.asList(2, 6));
        System.out.println(new Solutions2().mergeKLists(new ListNode[]{node1, node2, node3}));
    }


    // 合并重赋值
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode result = null;
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            result = mergeNode(result, node);
        }
        return result;
    }

    private ListNode mergeNode(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }

        // 处理第1个
        ListNode header;
        ListNode pointer;
        if (first.val <= second.val) {
            pointer = new ListNode(first.val);
            first = first.next;
        } else {
            pointer = new ListNode(second.val);
            second = second.next;
        }
        header = pointer;

        // 处理中间的
        while (first != null && second != null) {
            if (first.val <= second.val) {
                pointer.next = new ListNode(first.val);
                first = first.next;
            } else {
                pointer.next = new ListNode(second.val);
                second = second.next;
            }
            pointer = pointer.next;
        }

        // 处理剩余的
        if (first == null) {
            pointer.next = second;
        }
        if (second == null) {
            pointer.next = first;
        }

        return header;
    }
}