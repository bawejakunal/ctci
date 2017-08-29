/**
 *
 * Check if a given binary tree is a bst
 *
 **/

import java.util.Scanner;

public class CheckBst {

    static boolean isBst(Node root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.data <= min) ||
            (max != null && root.data > max)) {
            return false;
        }

        return isBst(root.left, min, root.data) &&
                isBst(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++)
            array[i] = in.nextInt();
        in.close();
        Node root = CreateBinaryTree.
                        createBalancedTree(array, 0, array.length - 1);
        System.out.println(isBst(root, null, null) ? "YES" : "NO");    
    }
}