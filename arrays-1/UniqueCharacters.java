/**
 *
 * Check if a string has all unique characters
 *
 **/

import java.util.*;

public class UniqueCharacters {

    private static boolean hasUniqueChars(String str) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i)))
                return false;
            set.add(str.charAt(i));
        }
        return true;
    }

    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        in.close();
        System.out.println(hasUniqueChars(str) ? "YES" : "NO");
    }
}
