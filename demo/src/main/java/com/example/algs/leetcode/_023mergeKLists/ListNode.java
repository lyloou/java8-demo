package com.example.algs.leetcode._023mergeKLists;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "" + val +
                "->" + next;
    }

    static ListNode getNode(List<Integer> list) {
        if (list.size() < 1) {
            return null;
        }
        list = new ArrayList<>(list);
        ListNode listNode = new ListNode(list.remove(0));
        listNode.next = getNode(list);
        return listNode;
    }
}