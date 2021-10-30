/**
 * A BallRemover class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-03
 */
public class BallRemover  implements HitListener {
    private Counter remainingBalls;
    private GameLevel game;

    /**
     * @param remainingBalls count the balls
     * @param game game
     */
    public BallRemover(Counter remainingBalls, GameLevel game) {
        this.remainingBalls = remainingBalls;
        this.game = game;
    }
    /**
     *   Blocks that are hit should be removed
     *   from the game. Remember to remove this listener from the block
     *   that is being removed from the game.
     * @param beingHit the hitter ball
     * @param hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
