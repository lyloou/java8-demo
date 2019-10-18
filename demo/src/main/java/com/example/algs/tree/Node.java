package com.example.algs.tree;

/**
 * @author lyloou
 * @date 2019/10/18
 */
public class Node<T> {
    Node left;
    Node right;
    T value;

    public Node(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public static Node createTree() {

        Node n0 = new Node(0);

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        return n0;
    }
}
