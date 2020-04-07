//package com.example.algs.tree;
//
//import edu.princeton.cs.algs4.Queue;
//
///**
// * @author lyloou
// * @date 2019/10/18
// */
//public class PriorityTraversal {
//    public static void main(String[] args) {
//        Node tree = Node.createTree();
//        System.out.print("depth: ");
//        depthPriority(tree);
//
//        System.out.println();
//
//        Queue<Node> queue = new Queue<>();
//        queue.enqueue(tree);
//        System.out.print("breadth: ");
//        breadthPriority(queue);
//    }
//
//    private static void depthPriority(Node node) {
//        System.out.print(node.value + " ");
//        if (node.left != null) {
//            depthPriority(node.left);
//        }
//
//        if (node.right != null) {
//            depthPriority(node.right);
//        }
//    }
//
//
//    private static void breadthPriority(Queue<Node> queue) {
//        if (queue.isEmpty()) {
//            return;
//        }
//        Node node = queue.dequeue();
//        System.out.print(node.value + " ");
//        if (node.left != null) {
//            queue.enqueue(node.left);
//        }
//        if (node.right != null) {
//            queue.enqueue(node.right);
//        }
//        breadthPriority(queue);
//    }
//}
