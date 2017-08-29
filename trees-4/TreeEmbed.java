/**
 *
 * Given two binary trees, check if T2 is contained within T1
 *
 * THIS IS SLIGHTLY DIFFERENT FROM CTCI in the way that T2 leaves
 * need not be the leaves in T1 as well
 */

import java.util.*;

public class TreeEmbed {

    /**
     * If t2 is within t1 starting at root
     **/
    static boolean matchTreeAtRoot(Node t1, Node t2) {
        
        if ((t1 == null && t2 == null) || (t2 == null && t1 != null))
            return true;
        
        else if (t1 == null || t1.data != t2.data)
            return false;

        return matchTreeAtRoot(t1.left, t2.left) &&
                matchTreeAtRoot(t1.right, t2.right);
    }

    static boolean isContained(Node t1, Node t2) {
        if (t2 == null)
            return true;

        else if (t1 == null)
            return false;

        if (t1.data == t2.data)
            return matchTreeAtRoot(t1, t2);

        return isContained(t1.left, t2) || isContained(t1.right, t2);
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        
        // first tree
        int length = in.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++)
            array[i] = in.nextInt();

        int l2 = in.nextInt();
        int a2[] = new int[l2];
        for (int i = 0; i < a2.length; i++)
            a2[i] = in.nextInt();

        in.close();
        Node first = CreateBinaryTree.
                        createBalancedTree(array, 0, array.length - 1);
        Node second = CreateBinaryTree.
                        createBalancedTree(a2, 0, a2.length - 1);

        System.out.println(isContained(first, second) ? "YES":"NO");
    }
}