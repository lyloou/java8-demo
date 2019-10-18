package com.example.algs.tree;

/**
 * @author lyloou
 * @date 2019/10/18
 */
public class PrintTree {
    public static void main(String[] args) {
        Node root = Node.createTree();
        printNodesWithPre(root);
        System.out.println();
        printNodesWithPost(root);
        System.out.println();
        printNodesWithMid(root);
    }

    private static void printNodesWithMid(Node node) {
        if (node == null) {
            return;
        }

        printNodesWithMid(node.left);
        System.out.print(node.value + " ");
        printNodesWithMid(node.right);
    }

    private static void printNodesWithPost(Node node) {
        if (node == null) {
            return;
        }

        printNodesWithPost(node.left);
        printNodesWithPost(node.right);
        System.out.print(node.value + " ");
    }

    private static void printNodesWithPre(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        printNodesWithPre(node.left);
        printNodesWithPre(node.right);
    }


}
