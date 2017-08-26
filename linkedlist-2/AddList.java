/**
 *
 * Addition of two lists
 *
 **/

public class AddList {

    // digits in number
    private static int length(Node head) {
        int len = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            len++;
        }
        return len;
    }

    // not allowed to modify existing lists
    // generate new list
    private static Node sumList(Node h1, Node h2) {
        int l1 = length(h1);
        int l2 = length(h2);

        if (l1 == 0)
            return h2;
        if  (l2 == 0)
            return h1;

        Node head = null, end = null;
        Node r1 = h1, r2 = h2;
        if (l1 < l2) {
            r1 = h2;
            r2 = h1;
        }
        int carry = 0;

        // r2 is smaller list
        while (r2 != null) {
            carry += r1.value + r2.value;
            Node nxt = new Node(carry % 10);
            if (end == null) {
                end = nxt;
                head = end;
            }
            else {
                end.next = nxt;
                end = nxt;
            }
            carry /= 10;
            r1 = r1.next;
            r2 = r2.next;
        }

        // r1 is longer
        while (r1 != null) {
            carry += r1.value;
            Node nxt = new Node(carry % 10);
            if (end == null) {
                end = nxt;
                head = end;
            }
            else {
                end.next = nxt;
                end = nxt;
            }
            carry /= 10;
            r1 = r1.next;
        }

        while (carry > 0) {
            end.next = new Node(carry % 10);
            end = end.next;
            carry /= 10;
        }

        return head;
    }

    public static void main(String []args) {
        Node l1 = Node.generate(10, 0, 9);
        Node l2 = Node.generate(11, 0, 9);
        l1.print();
        l2.print();
        Node sum = sumList(l2, l1);
        sum.print();
    }
}