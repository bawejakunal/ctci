/**
 *
 * A binary tree node definition
 *
 **/

import java.util.*;

class Node {

    int data;
    Node left, right, next;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    protected void inorder(ArrayList<Node> list) {
        if (this.left != null)
            this.left.inorder(list);
        list.add(this);
        if (this.right != null)
            this.right.inorder(list);
    }

    ArrayList<Node> inorder() {
        ArrayList<Node> list = new ArrayList<Node>();
        this.inorder(list);
        return list;
    }

    protected void preorder(ArrayList<Node> list) {
        list.add(this);
        if (this.left != null)
            this.left.preorder(list);
        if (this.right != null)
            this.right.preorder(list);
    }

    ArrayList<Node> preorder() {
        ArrayList<Node> list = new ArrayList<Node>();
        this.preorder(list);
        return list;
    }
}