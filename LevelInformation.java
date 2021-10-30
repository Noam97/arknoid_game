import java.util.List;

/**
 * A LevelInformation interface.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public interface LevelInformation {
    /**
     * @return number of balls
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     *
     * @return list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return paddle speed
     */
    int paddleSpeed();

    /**
     * @return paddle width
     */
    int paddleWidth();


    /**
     * The level name will be displayed at the top of the screen.
     *
     * @return level name
     */
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return list of blocks
     */
    List<Block> blocks();

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return the number of the blocks
     */
    int numberOfBlocksToRemove();
}
