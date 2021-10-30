/**
 * A collisionDetection.CollisionInfo class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * constructor.
     * @param collisionPoint  the point at which the collision occurs.
     * @param collisionObject the collidable object involved in the collision
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     *
     * @return the collidable object involved in the collision
     */
    public Collidable collisionObject() {
    return this.collisionObject;
    }

    /**
     *
     * @param collision the point of the collision
     */
    public void setCollisionPoint(Point collision) {
        this.collisionPoint = collision;
    }

    /**
     *
     * @param c the object which collided
     */
    public void setCollisionObject(Collidable c) {
        this.collisionObject = c;
    }
}
