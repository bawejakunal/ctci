/**
 *
 * Replace a given substring with another substring
 *
 **/

import java.util.*;

public class ReplaceChar {

    private static int replace(char array[], char orig, char repl[],
                               int length) {
        if (array == null || repl == null || repl.length == 0)
            return length;

        int newLength = length;
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == orig)
                cnt++;
        }
        newLength += (repl.length - 1) * cnt;

        int last = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == orig) {
                for (int j = repl.length - 1; j >= 0; j--)
                    array[last--] = repl[j];
            }
            else {
                array[last--] = array[i];
            }
        }
        
        return newLength;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        in.close();
        char repl[] = {'%', '2', '0'};
        char array[] = new char[repl.length * str.length()];
        System.arraycopy(str.toCharArray(), 0, array, 0, str.length());
        
        int newLength = replace(array, ' ', repl, str.length());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < newLength; i++)
            builder.append(array[i]);
        System.out.println(builder.toString());
    }
}