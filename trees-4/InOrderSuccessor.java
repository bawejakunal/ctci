/**
 *
 * Find in-order successor of a given node in Binary search tree
 * Assume nodes DO NOT have parent pointers
 *
 **/

import java.util.Scanner;

public class InOrderSuccessor {

    /*
     * Even if val does not exist return next node with
     * data greater than val
     */
    static Node getInOrderSucessor(Node root, int val) {
        if (root == null)
            return null;

        if (root.data == val) {
            if (root.right != null) {
                Node n = root.right;
                while (n.left != null)
                    n = n.left;
                return n;
            }
            else
                return null;
        }

        else if (root.data < val)
            return getInOrderSucessor(root.right, val);

        else {
            Node leftAns = getInOrderSucessor(root.left, val);
            return leftAns == null ? root : leftAns;
        }
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++)
            array[i] = in.nextInt();
        int val = in.nextInt();
        in.close();
        Node root = CreateBinaryTree.
                        createBalancedTree(array, 0, array.length - 1);
        Node successor = getInOrderSucessor(root, val);
        System.out.println(successor == null ? "MAX NODE" :
                            Integer.toString(successor.data));
    }

}