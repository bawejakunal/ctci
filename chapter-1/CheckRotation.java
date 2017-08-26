/**
 *
 * Confirm if second string is rotation of first string
 *
 **/

import java.util.*;

public class CheckRotation{

    private static boolean isRotation(String s1, String s2)
                        throws IllegalArgumentException {
        
        if (s1 == null)
            throw new IllegalArgumentException("First String can not be null");

        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }

    public static void main(String []args) throws IllegalArgumentException {
        if (args.length < 2)
            throw new IllegalArgumentException("Too few arguments !");

        boolean check = isRotation(args[0], args[1]);
        System.out.println(check ? "YES" : "NO");
    }
}