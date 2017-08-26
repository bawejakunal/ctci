/**
 *
 * Check if two strings are permutations of each other
 *
 **/

import java.util.*;

public class CheckPermutation{

    private static boolean isPermutation(String s1, String s2) {
        if ((s1 == null && s2 != null) || (s1 != null && s2 == null)
             || (s1.length() != s2.length())) {
             return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++)
             map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i < s2.length(); i++) {
            if (!map.containsKey(s2.charAt(i)) || map.get(s2.charAt(i)) == 0)
                 return false;
            map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        boolean perm = isPermutation(s1, s2);
        System.out.println(perm ? "YES" : "NO");
    }

}
