/**
 *
 * Print all permutations of a characters of a string
 *
 **/

import java.util.*;

public class PermuteString {

    static LinkedList<String> permute(String str, int idx) {
        LinkedList<String> permutations;
        if (idx == str.length())  {
            permutations = new LinkedList<String>();
            permutations.add(new String());      // empty string
        }
        else {
            permutations = permute(str, idx + 1);
            LinkedList<String> newPermutations = new LinkedList<String>();
            
            while (permutations.size() > 0) {
                String perm = permutations.pollFirst();
                for (int i = 0; i <= perm.length(); i++) {
                    String newString = perm.substring(0, i) + str.charAt(idx)
                                       + perm.substring(i);
                    newPermutations.add(newString);
                }
            }
            permutations = newPermutations;
        }
        return permutations;
    }

    static LinkedList<String> permute(String str) {
        return permute(str, 0);
    }

    public static void main(String []args) {
        if (args.length != 1)
            System.out.println("Pass string as an arg");

        LinkedList<String> permutations = permute(args[0]);
        for (String str : permutations)
            System.out.println(str);
    }
}