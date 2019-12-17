package com.example.algs.leetcode._023mergeKLists;

/**
 * @author lyloou
 * @date 2019/12/16
 */

import java.util.*;

import static com.example.algs.leetcode._023mergeKLists.ListNode.getNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solutions4 {
    public static void main(String[] args) {
        // [[-10,-9,-9,-9,-7,-2,-1,2,4],[-9,-7,-6,-6,-3,0,1,3],[-10,-9,-2,-1,1,3]]
        System.out.println(new Solutions4().mergeKLists(new ListNode[]{
                getNode(Arrays.asList(-10, -9, -9, -9, -7, -2, -1, 2, 4)),
                getNode(Arrays.asList(-9, -7, -6, -6, -3, 0, 1, 3)),
                getNode(Arrays.asList(-10, -9, -2, -1, 1, 3))}));

        System.out.println(new Solutions4().mergeKLists(new ListNode[]{
                getNode(Arrays.asList(1, 4, 5)),
                getNode(Arrays.asList(1, 3, 4)),
                getNode(Arrays.asList(2, 6))}));
    }

    // 优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().val);
        }
        return getNode(list);
    }

}