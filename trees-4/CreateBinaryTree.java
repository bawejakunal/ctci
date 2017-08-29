/**
 *
 * Create a minimal height binary tree from a given array
 *
 * A minimal height binary tree is a balanced tree
 * 
 **/

import java.util.Scanner;

public class CreateBinaryTree {

    static Node createBalancedTree(int []array, int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;
        Node root = new Node(array[mid]);
        root.left = createBalancedTree(array, start, mid - 1);
        root.right = createBalancedTree(array, mid + 1, end);
        return root;
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++)
            array[i] = in.nextInt();
        in.close();
        Node root = createBalancedTree(array, 0, array.length - 1);

        // Inorder print
        for (Node n: root.inorder())
            System.out.format("%d ", n.data);
        System.out.println();

        // Pre-order print
        for (Node n: root.preorder())
            System.out.format("%d ", n.data);
        System.out.println();
    }

}