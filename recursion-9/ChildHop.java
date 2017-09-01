/**
 *
 * A child can hop 1 to n steps at a time
 * Given staircase of height h, find the number of ways in which the child can
 * climb the staircase
 *
 **/

public class ChildHop {

    static int countWays(int height, int step) {
        if (height == 0 || step == 1)
            return 1;   // only 1 way to not climb
        else if (height <= step)
            return (int) Math.pow(2, height - 1);
        
        int ways[] = new int[step + 1];
        ways[0] = 1;
        ways[1] = 1;
        for (int s = 2; s <= step; s++)
            ways[s] = ways[s-1] << 1;   // double the previous ones
        for (int t = step + 1; t <= height; t++) {
            int total = 0;
            for (int i = 0; i < step; i++) {
                ways[i] = ways[i + 1];
                total += ways[i];
            }
            ways[step] = total;
        }
        return ways[step];
    }

    public static void main(String []args) {
        int height = Integer.parseInt(args[0]);
        int step = Integer.parseInt(args[1]);
        System.out.println(countWays(height, step));
    }
}