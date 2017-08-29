/**
 *
 * link each node to next node in level
 *
 **/

import java.util.*;

public class CreateLinkedList {
    
    // reverse of pre-orde traversal
    // current node, right subtree, left subtree
    static void createLevelList(Node root, int level, ArrayList<Node>list) {
        if (root == null)
            return;

        if (level == list.size()) {
            root.next = null;
            list.add(root);
        }
        else {
            root.next = list.get(level);
            list.set(level, root);
        }

        createLevelList(root.right, level + 1, list);
        createLevelList(root.left, level + 1, list);
    }

    static ArrayList<Node> createLevelList(Node root) {
        ArrayList<Node> list = new ArrayList<Node>();
        createLevelList(root, 0, list);
        return list;
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++)
            array[i] = in.nextInt();
        in.close();
        Node root = CreateBinaryTree.
                        createBalancedTree(array, 0, array.length - 1);
        ArrayList<Node> levels = createLevelList(root);

        // level order printing
        for (Node first: levels) {
            Node current = first;
            while (current != null) {
                System.out.format("%d ", current.data);
                current = current.next;
            }
            System.out.println();
        }
    }
}