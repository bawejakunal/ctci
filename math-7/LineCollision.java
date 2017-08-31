/**
 *
 * Determine if two given lines will intersect i.e collide
 *
 **/

class Line {
    static double epsilon = 0.000001;
    double intercept;
    double slope;

    Line(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }

    boolean intersects (Line l) {
        return Math.abs(this.slope - l.slope) > Line.epsilon ||
                Math.abs(this.intercept - l.intercept) < Line.epsilon;
    }
}

public class LineCollision {

    public static void main(String[] args) {
        // Same line
        Line l1 = new Line(3.0, 2.0);
        Line l2 = l1;
        System.out.println(l1.intersects(l2) ? "YES" : "NO");

        // Parallel lines
        l2 = new Line(3.0, 0.0);
        System.out.println(l1.intersects(l2) ? "YES" : "NO");

        // Intersecting lines
        l2 = new Line(-4.5, -1.7);
        System.out.println(l1.intersects(l2) ? "YES" : "NO");
    }
}