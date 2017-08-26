/**
 *
 * Compress a string into chars followed by numbers
 *
 **/

import java.util.*;

public class StringCompression {

    private static String compress(String str) {
        if (str == null)
            return null;

        StringBuilder builder = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == prev)
                count++;
            else {
                builder.append(prev);
                builder.append(count);
                prev = str.charAt(i);
                count = 1;

                if (builder.length() >= str.length())
                    return str;
            }
        }
        builder.append(prev);
        builder.append(count);

        if (builder.length() >= str.length())
            return str;

        return builder.toString();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        String comp = compress(str);
        System.out.println(comp);
    }
}