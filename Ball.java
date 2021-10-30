import biuoop.DrawSurface;
import java.awt.Color;

/**
 * A Ball class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-04-22
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment g;

    /**
     * @param center center point of a circle
     * @param r      radios of circle
     * @param color  of circle
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * @return coordinate x
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return coordinate y
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the length of the radius
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    // draw the ball on the given DrawSurface

    /**
     * @param surface The features of the polygon
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * @param velo velocity
     */
    public void setVelocity(Velocity velo) {
        this.v = velo;
    }

    /**
     * @param dx The difference between the previous X coordinate and the present one
     * @param dy The difference between the previous y coordinate and the present one
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * @return velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * @return game
     */
    public GameEnvironment getGameEnvironment() {
        return this.g;
    }

    /**
     * @param left  upper and left point
     * @param right lower anf right point
     */
    // public void moveOneStep(Point upLeft, Point downRight) {
    public void moveOneStep(Point left, Point right) {
        double dx = getVelocity().getDx();
        double dy = getVelocity().getDy();
        Point point;
        //this.center = this.getVelocity().applyToPoint(this.center);
        point = this.getVelocity().applyToPoint(this.center);
        //left
        if (point.getX() <= (left.getX() + this.getSize())) {
            this.setVelocity(-dx, dy);
        }
        //right
        if ((right.getX() - this.getSize()) <= point.getX()) {
            this.setVelocity(-dx, dy);
        }
        //up
        if ((right.getY() - this.getSize()) <= point.getY()) {
            this.setVelocity(dx, -dy);
        }
        // down
        if (point.getY() <= (left.getY() + this.getSize())) {
            this.setVelocity(dx, -dy);
        }
        this.center = this.getVelocity().applyToPoint(this.center);

    }

    /**
     * A Generic method move one step.
     */
    public void moveOneStep() {
       // System.out.println("(" + this.center.getX() + "," + this.center.getY() + ") dx: " + this.getVelocity().getDx()
        //        + " dy: " + this.getVelocity().getDy());
        double dx = this.getVelocity().getDx();
        double dy = this.getVelocity().getDy();
        //The trajectory of the object which moving from line.start() to line.end().
        Line trajectory = new Line(this.center.getX(), this.center.getY(),
                this.center.getX() + dx, this.center.getY() + dy);
        CollisionInfo info = this.g.getClosestCollision(trajectory);
        //the velocity after the collision
        Velocity temp;
        //if the line has no intersect point with the block
        if (info == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            //if the line has intersect point with the block
        } else {
            double xOfCollision = info.collisionPoint().getX();
            double yOfCollision = info.collisionPoint().getY();
            Collidable temp1 = info.collisionObject();
            //the velocity after the collision
            temp = temp1.hit(this, new Point(xOfCollision, yOfCollision), this.v);
            double newDxVelocity = temp.getDx();
            double newDyVelocity = temp.getDy();
            Point p = null;

//            for (int i = 0; i < 20; i++) {
//                p = trajectory.middle();
//                trajectory.start().setX(p.getX());
//                trajectory.start().setY(p.getY());
//            }
//            this.center.setY(p.getY());
//            this.center.setX(p.getX());
//
//            this.v = temp;
//            this.center = this.getVelocity().applyToPoint(new Point(xOfCollision, yOfCollision));

            //The collision happened in left or right
            if (dx != newDxVelocity) {
                //The collision happened in right
                if (dx > 0) {
                    xOfCollision = xOfCollision - this.r;
                }
                //The collision happened in left
                if (dx < 0) {
                    xOfCollision = xOfCollision + this.r;
                }
            }
            //The collision happened in up or down
            if (dy != newDyVelocity) {
                //The collision happened in down
                if (dy > 0) {
                    yOfCollision = yOfCollision - this.r;
                }
                //The collision happened in up
                if (dy < 0) {
                    yOfCollision = yOfCollision + this.r;
                }
            }
         //   this.v = info.collisionObject().hit(new Point(xOfCollision, yOfCollision), this.v);
            this.setVelocity(newDxVelocity, newDyVelocity);
           this.center = new Point(xOfCollision, yOfCollision);

        }
    }

    /**
     * @param game game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * @param game game
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.g = game;
    }

    /**
     * Method to remove from the game.
     * @param game game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
    //
//        Point p = this.getVelocity().applyToPoint(this.center);
//        //left
//        if (p.getX() - this.getSize() + dx <= upLeft.getX()) {
//            setVelocity(-dx, dy);
//        }
//        //right
//        if (downRight.getX() <= p.getX() + this.getSize() + dx) {
//            setVelocity(-dx, dy);
//        }
//
//        //up
//        if (p.getY() - this.getSize() + dy <= upLeft.getY()) {
//            setVelocity(dx, -dy);
//        }
//        //down
//        if (downRight.getY() <= p.getY() + this.getSize() + dy) {
//            setVelocity(dx, -dy);
//        }
//        this.center = this.getVelocity().applyToPoint(this.center);
//    }
}


