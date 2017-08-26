/**
 *
 * Reverse a string
 *
 **/

import java.util.*;

public class ReverseString {

    private static String reverse(String str) {
        if (str == null)
            return str;

        char array[] = str.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return new String(array);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        String rev = reverse(str);
        System.out.println(rev);
    }

}
