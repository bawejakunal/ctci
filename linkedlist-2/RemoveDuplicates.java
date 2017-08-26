/**
 *
 * Remove duplicates from LinkedList
 *
 **/

import java.util.*;
// import Node;

public class RemoveDuplicates {

    // without using extra space
    private static void removeDuplicates(Node head) {
        if (head == null)
            return;

        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            current = current.next;
        }
    }

    private static void removeDuplicatesWithSpace(Node head) {
        if (head == null)
            return;

        HashSet<Integer> set = new HashSet<Integer>();
        
        Node current = head;
        set.add(current.value);
        while (current.next != null) {
            if (set.contains(current.next.value))
                current.next = current.next.next;
            else {
                current = current.next;
                set.add(current.value);
            }
        }
    }

    public static void main(String []args) throws IllegalArgumentException {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int min = in.nextInt();
        int max = in.nextInt();
        int option = in.nextInt();
        in.close();
        Node head = Node.generate(length, min, max);
        head.print();      // print generated list
        switch(option) {
            case 1: removeDuplicates(head);
                    break;
            case 2: removeDuplicatesWithSpace(head);
                    break;
            default: throw new IllegalArgumentException("Invalid option");
        }
        head.print();
    }
}