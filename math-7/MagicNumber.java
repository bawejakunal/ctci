/**
 *
 * In a non-decreasing number series containing multiples of 3, 5, and 7
 * fetch the kth number, where k >= 0
 *
 **/

import java.util.*;

public class MagicNumber {


    static int getMagicNumber(int k) {
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        Queue<Integer> q7 = new LinkedList<Integer>();
        q3.add(1);
        int m = Integer.MAX_VALUE;

        for (int i = 0; i <= k; i++) {

            int m3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
            int m5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
            int m7 = q7.isEmpty() ? Integer.MAX_VALUE : q7.peek();

            m = Math.min(m3, Math.min(m5, m7));

            if (m == m3) {
                q3.remove();
                q3.add(3 * m);
                q5.add(5 * m);
            }
            else if (m == m5) {
                q5.remove();
                q5.add(5 * m);
            }
            else if (m == m7) {
                q7.remove();
            }
            q7.add(7 * m);
        }
        return m;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MagicNumber k");
            return;
        }

        int k = Integer.parseInt(args[0]);
        if (k < 0) {
            System.out.println("valid range: k >= 0");
            return;
        }

        System.out.println(getMagicNumber(k));
    }
}