/**
 *
 * Find the loop node in a linked list having loop
 *
 **/

import java.util.*;

public class FindLoop {

    private static void formLoop(Node head, int loopPos) {
        if (head == null)
            return;
        Node loopHead, end = head;
        for (int i = 1; i < loopPos; i++) {
            if (end.next == null)
                return;     // smaller than loopPos
            end = end.next;
        }

        loopHead = end;
        while (end.next != null) {
            end = end.next;
        }
        end.next = loopHead;    // form loop here
        System.out.format("Loop head idx: %d\n", loopPos);
    }

    private static Node findLoopHead(Node head) {
        if (head == null)
            return null;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)   // loop detected
                break;
        }

        if (fast == null || fast.next == null)
            return null;    // no loop

        fast = head;    // reset fast to head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String []args) {
        Random rand = new Random();
        int length = rand.nextInt(50) + 1;
        Node head = Node.generate(length, 1, length);
        head.print();   // print list
        int loopPos = rand.nextInt(length) + 1;     // random node is loophead
        formLoop(head, loopPos);        // connect last node to node at loopPos
        Node loopHead = findLoopHead(head);
        System.out.println((loopHead != null) ? loopHead.value : "No loop !");
    }
}