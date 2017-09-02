/**
 *
 * Given N cents and infinite number of coins from a denomination
 * Find the number of ways to represent those.
 *
 **/

public class CoinChange {

    static int recursiveChange(int []denomination, int size, int total) {
        // total is zero
        if (total == 0)
            return 1;       // only 1 way to not use any coins

        if (total < 0 || size <= 0)
            return 0;       // negative money or no coins left

        return recursiveChange(denomination, size - 1, total) + 
            recursiveChange(denomination, size, total-denomination[size-1]);
    }

    static int dpChange(int []denomination, int total) {

        int ways[] = new int[total + 1];
        ways[0] = 1;    // base case: 0 money to divide

        for (int i = 0; i < denomination.length; i++) {
            for (int j = denomination[i]; j <= total; j++)
                ways[j] += ways[j - denomination[i]];
        }
        return ways[total];     // ways to distribute total money
    }

    public static void main(String []args) {
        int coins[] = {1, 5, 10, 25};
        int total = Integer.parseInt(args[0]);
        // System.out.println(recursiveChange(coins, coins.length, total));
        System.out.println(dpChange(coins, total));
    }

}