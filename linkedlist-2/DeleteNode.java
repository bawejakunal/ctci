/**
 *
 * Delete a middle node of linked list
 *
 **/

import java.util.Scanner;

public class DeleteNode {

    private static boolean deleteNode(Node node) {
        if (node == null || node.next == null)
            return false;
        node.value = node.next.value;
        node.next = node.next.next;
        return true;
    }

    public static void main(String []args) throws IllegalArgumentException {

        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int n = in.nextInt();
        in.close();

        if (n > length) {
            throw new IllegalArgumentException(
                        "Node must lie within linked list");
        }

        Node head = Node.generate(length, 1, 10);
        head.print();       // list generated
        Node target = head;
        for (int i = 1; i < n; i++)
            target = target.next;
        if (deleteNode(target))
            head.print();
        else
            System.out.println("Node deletion failed !");
    }
}