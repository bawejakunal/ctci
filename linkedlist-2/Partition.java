/**
 *
 * Partition a linked list around a given value
 *
 **/

public class Partition {

    private static Node partition(Node head, int x) {
        if (head == null)
            return null;
        Node smallBegin = null, smallEnd = null;
        Node greatBegin = null;

        Node current = head;
        while (current != null) {
            Node t = current;
            current = current.next;

            // add to head of smaller list
            if (t.value < x) {
                t.next = smallBegin;
                smallBegin = t;
                if (smallEnd == null)
                    smallEnd = smallBegin;   // single element list
            }
            else {
                t.next = greatBegin;
                greatBegin = t;
            }
        }

        if (smallBegin == null)
            return greatBegin;  // no small elements

        smallEnd.next = greatBegin;
        return smallBegin;
    }

    public static void main(String []args) {
        Node head = Node.generate(20, 0, 9);
        head.print();
        head = partition(head, head.value);
        head.print();
    }
}