/**
 *
 * Find Kth element from last element in list
 *
 **/

import java.util.Scanner;

public class Klast {

    /* Returns kth node from end of linked list.
     * throws illegal argument exception for null list
     * returns null for k longer than list
     */
    private static Node lastElement(Node head, int k)
            throws IllegalArgumentException {

        if (head == null || k < 1)
            throw new IllegalArgumentException("Empty list or invalid k !");

        Node slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null)
                return null;    // list longer than k
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int k = in.nextInt();
        in.close();

        Node head = Node.generate(length, 1, 100);
        if (head != null)
            head.print();

        try {
            Node kLast = lastElement(head, k);
            if (kLast != null)
                System.out.println(kLast.value);
            else
                System.out.format("List smaller than %d\n", k);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}