/**
 * A point class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-04-22
 */
public class Point {
    private double x;
    private double y;

    /**
     * Construct a point given x and y coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The method creates two variable- the first calculate calculate the difference between two x values,
     * and the second between two y values.
     *
     * @param other x and y coordinates of other point to measure the distance to.
     * @return the distance to the other point.
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /**
     * The method check if two points are equal or otherwise.
     * points are equal if their distance is 0.
     *
     * @param other x and y coordinates of other point to measure the distance to.
     * @return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (distance(other) == 0) {
            return true;
        }
        return false;
    }

    /**
     * @return the x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * @param x1 coordinate
     */
    public void setX(double x1) {
        this.x = x1;
    }

    /**
     * @param y1 coordinat
     */
    public void setY(double y1) {
        this.y = y1;
    }
}
