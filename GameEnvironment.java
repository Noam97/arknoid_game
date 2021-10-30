import java.util.ArrayList;

/**
 * A GameEnvironment class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public class GameEnvironment {
    private java.util.List<Collidable> collidables;

    /**
     * construct.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * A method to add the given collidable to the environment.
     *
     * @param c collisionDetection.Collidable
     */
    public void addCollidable(Collidable c) {

        this.collidables.add(c);
    }

    /**
     * @param trajectory trajectory of the object which moving from line.start() to line.end().
     * @return If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        CollisionInfo collisionInfo = null;
        double minDistance = 999999;
        Collidable minColid = null;
        double distancePointCollisionWithStart = 0;
        Point minC = null;
        for (Collidable c : this.collidables) {
            Point collision = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (collision == null) {
                continue;
            }
            distancePointCollisionWithStart = collision.distance(trajectory.start());
            if (distancePointCollisionWithStart <= minDistance) {
                minDistance = distancePointCollisionWithStart;
                minC = collision;
                minColid = c;
            }
        }
        if (minC == null || minColid == null) {
            return null;
        }
        return new CollisionInfo(minC, minColid);
    }

    /**
     * remove collidable.
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
}