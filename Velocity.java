/**
 * Velocoty class.
 * collisionDetection.Velocity specifies the change in position on the x and the y axes.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-04-22
 *
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * @param dx the change in position on the "x" axes
     * @param dy the change in position on the "y" axes
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return the change in position on the "x" axes
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the change in position on the "x" axes
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * @param p point with position (x,y)
     * @return new point with position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * @param angle between the speed and dy
     * @param speed of the object
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radian = Math.toRadians(angle);
        double dx = Math.sin(radian) * speed;
        double dy = -Math.cos(radian) * speed;
        return new Velocity(dx, dy);
    }
}
