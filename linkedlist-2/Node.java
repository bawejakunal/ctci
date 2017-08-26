/**
 *
 * Helper module for linked list chapter
 *
 **/

import java.util.*;

class Node {

    int value;  // value stored at this node
    Node next;  // pointer to next node

    // constructor
    Node (int data) {
        this.value = data;
        this.next  = null;
    }

    // print list from this node onwards
    void print() {
        Node current = this;
        while (current != null) {
            System.out.format("%d ", current.value);
            current = current.next;
        }
        System.out.println();
    }

    // generate a random list of given length
    static Node generate(int length, int min, int max) {
        Random rand = new Random();
        Node head = null;
        int range = max - min + 1;
        for (int i = 0; i < length; i++) {
            Node t = new Node(rand.nextInt(range) + min);
            if (head == null)
                head = t;
            else {
                t.next = head;
                head = t;
            }
        }
        return head;
    }

    static Node fromArray(int []array) {
        if (array == null || array.length == 0)
            return null;

        Node head = new Node(array[0]);
        Node end = head;
        for (int i = 1; i < array.length; i++) {
            end.next = new Node(array[i]);
            end = end.next;
        }
        return head;
    }
}