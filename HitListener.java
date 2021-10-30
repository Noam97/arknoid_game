/**
 * A HitListener interface.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-03
 */
public interface HitListener {


    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit block
     * @param hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}
