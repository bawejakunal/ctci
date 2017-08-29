/**
 *
 * Print paths in a binary tree which sum to a given total
 *
 **/

import java.util.*;

public class PathSum {

    static void printArrayElements(ArrayList<Integer> array, int start,
                                    int end) {

        for (int i = start; i <= end; i++)
            System.out.format("%d ", array.get(i));
        System.out.println();
    }

    static void printSumPath(Node root, ArrayList<Integer> path, int sum,
                            int level) {

        if (root == null)
            return;

        if (path.size() == level)
            path.add(root.data);
        else
            path.set(level, root.data);

        int target = 0;
        for (int i = level; i >= 0; i--) {
            target += path.get(i);
            if (target == sum)
                printArrayElements(path, i, level);
        }

        printSumPath(root.left, path, sum, level + 1);
        printSumPath(root.right, path, sum, level + 1);
    }

    static void printSumPath(Node root, int sum) {
        
        if (root != null) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            printSumPath(root, path, sum, 0);
        }
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++)
            array[i] = in.nextInt();
        int sum = in.nextInt();
        in.close();

        Node root = CreateBinaryTree.
                        createBalancedTree(array, 0, array.length - 1);

        printSumPath(root, sum);
    }
}