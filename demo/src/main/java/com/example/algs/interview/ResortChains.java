package com.example.algs.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ResortChains {
    public static void main(String[] args) {
        Node firstNode = createNode(4);
        System.out.println("origin:" + firstNode);
        resortNode(firstNode);
        System.out.println("resorted:" + firstNode);

        firstNode = createNode(5);
        System.out.println("origin:" + firstNode);
        resortNode(firstNode);
        System.out.println("resorted:" + firstNode);

    }

    private static void resortNode(Node node) {
        List<Node> list = new ArrayList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        for (int i = 0; i < list.size(); i++) {
            Node head = list.get(i);
            Node tail = list.get(list.size() - i - 1);
            if (head == tail) {
                head.next = null;
                break;
            }
            if (head.next == tail) {
                tail.next = null;
                break;
            }
            tail.next = head.next;
            head.next = tail;
        }
    }

    private static Node createNode(int num) {
        Node tail = new Node(num, null);
        for (int i = num - 1; i > 0; i--) {
            tail = new Node(i, tail);
        }
        return tail;
    }

    static class Node {
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        int value;
        Node next;

        @Override
        public String toString() {
            return value + (next == null ? "" : ("->" + next));
        }
    }
}
