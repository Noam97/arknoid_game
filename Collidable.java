import biuoop.DrawSurface;

/**
 * A collisionDetection.Collidable interface.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public interface Collidable {
    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.


    /**
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity of the object
     * @param hitter ball
     * @return The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

    /**
     *
     * @param surface surface
     */
    void drawOn(DrawSurface surface);
}