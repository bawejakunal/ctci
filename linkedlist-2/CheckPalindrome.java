/**
 *
 * Check if a given list is a palindrome
 *
 **/

import java.util.*;

public class CheckPalindrome {
    private static boolean isPalindrome(Node head) {
        Node slow = head, fast = head;
        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length list
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop().intValue() != slow.value)
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String []args) {
        int arr[] = {1, 2, 3, 4, 5, 4, 3 , 2, 1};
        Node head = Node.fromArray(arr);

        // Case 1: odd length palindrom
        head.print();
        System.out.println(isPalindrome(head) ? "YES" : "NO");

        // Case 2: even length palindrome
        arr = new int[]{1, 2, 3, 3, 2, 1};
        head = Node.fromArray(arr);
        head.print();
        System.out.println(isPalindrome(head) ? "YES" : "NO");

        // // Case 3: empty palindrome
        arr = new int[]{};
        head = Node.fromArray(arr);
        System.out.println(isPalindrome(head) ? "YES" : "NO");

        // //Case 4: Not a palindrome
        arr = new int[]{1, 2, 3, 3, 1};
        head = Node.fromArray(arr);
        head.print();
        System.out.println(isPalindrome(head) ? "YES" : "NO");
    }
}