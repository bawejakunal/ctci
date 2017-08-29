/**
 *
 * Check if a given binary tree is balanced
 *
 **/

import java.util.*;

public class CheckBalanced {

    // static boolean isBalanced(Node root) {
    //     if (root == null)
    //         return true;

    //     int lh = getHeight(root.left);
    //     int rh = getHeight(root.right);

    //     if (Math.abs(lh - rh) > 1)
    //         return false;
    //     else
    //         return isBalanced(root.left) && isBalanced(root.right);
    // }

    static int getHeight(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    static boolean isBalanced(Node root) {
        return checkBalance(root) != -1;
    }

    /**
     *
     * -1 unbalanced
     *  else return height
     *
     **/
    static int checkBalance(Node root) {
        if (root == null)
            return 0;

        int lh = checkBalance(root.left);
        if (lh == -1)
            return -1;  // left subtree unbalanced

        int rh = checkBalance(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)  // unbalance here
            return -1;
        else
            return 1 + Math.max(lh, rh);
    }

    public static void main(String []args) {
        // Empty tree
        Node empty = null;
        System.out.println(isBalanced(empty) ? "YES": "NO");

        // Single node
        Node single = new Node(1);
        System.out.println(isBalanced(single) ? "YES" : "NO");

        // Balanced Complete Tree
        Node balanced = new Node(0);        // 0
        balanced.left = new Node(1);        // 1
        balanced.right = new Node(2);
        balanced.left.left = new Node(3);   // 2
        balanced.left.right = new Node(4);
        balanced.right.left = new Node(5);
        balanced.right.right = new Node(6);
        System.out.println(isBalanced(balanced) ? "YES" : "NO");

        // Balanced Incomplete Tree
        Node incomp = new Node(0);        // 0
        incomp.left = new Node(1);        // 1
        incomp.right = new Node(2);
        incomp.left.left = new Node(3);   // 2
        incomp.left.right = new Node(4);
        System.out.println(isBalanced(incomp) ? "YES" : "NO");

        // Unbalanced Tree
        Node unbalanced = new Node(0);        // 0
        unbalanced.left = new Node(1);        // 1
        unbalanced.left.left = new Node(2);   // 2
        System.out.println(isBalanced(unbalanced) ? "YES" : "NO");
    }
}