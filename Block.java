import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A Block class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public class Block implements Collidable, Sprite, HitNotifier {
   private List<HitListener> hitListeners;
    private java.awt.Color color;
    private Rectangle r;

    /**
     * @param color of the block
     * @param r rectangle
     */
    public Block(java.awt.Color color, Rectangle r) {
        this.color = color;
        this.r = r;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * @return the "collision shape" of the object.
     */
    public Rectangle getCollisionRectangle() {
        return this.r;
    }

    /**
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity of the object
     * @param hitter ball
     * @return The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        java.util.List<Line> intersectionLines = r.getListOfIntersectLines();
//        if (intersectionLines.size() == 2) {
//            return new collisionDetection.Velocity(-currentVelocity.getDx(), -currentVelocity.getDy());
//        }
        double width = r.getWidth();
        double height = r.getHeight();
        Point p1 = r.getUpperLeft(), p2 = new Point(r.getUpperLeft().getX() + r.getWidth(), r.getUpperLeft().getY());
        Point p3 = new Point(r.getUpperLeft().getX(), r.getUpperLeft().getY() + height);
        Point p4 = new Point(p2.getX(), p3.getY());
        this.notifyHit(hitter);
        if (collisionPoint.equals(p1) || collisionPoint.equals(p2) || collisionPoint.equals(p3)
                || collisionPoint.equals(p4)) {
         return new Velocity(-currentVelocity.getDx(), -currentVelocity.getDy());
    }
        //the collision happened up or down
        if (intersectionLines.get(0).start().getX() == intersectionLines.get(0).end().getX()) {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
    }
    /**
     *
     * @param surface surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.r.getUpperLeft().getX(), (int) this.r.getUpperLeft().getY(),
                (int) this.r.getWidth(), (int) this.r.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.r.getUpperLeft().getX(), (int) this.r.getUpperLeft().getY(),
                (int) this.r.getWidth(), (int) this.r.getHeight());

    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() { }

    /**
     * add the object to the game.
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * remove block from the game.
     * @param game game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }
    /**
     * @param hl hit listener
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * @param hl listener
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * @param hitter ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}

