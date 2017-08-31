/**
 *
 * N sided polygon. Ants start moving at same speed in a random direction
 *  What is probability of two or more ants colliding
 *
 **/

public class AntPolygon {

    static private double findCollisionProb(int sides) {
        // probability of not collision has only 2 cases
        // when all ants move in clockwise or anti-clockwise
        // directions

        // 1 - 2/(2^n)
        return 1.0 - Math.pow(2, 1-sides);
    }

    public static void main(String []args) throws Exception {
        if (args.length != 1)
            throw new Exception("Enter number of sides for the polygon");

        int sides = Integer.parseInt(args[0]);
        if (sides < 3)
            throw new Exception("Not a valid polygon");

        System.out.println(findCollisionProb(sides));
    }
}