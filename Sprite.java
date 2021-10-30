import biuoop.DrawSurface;

/**
 * A Sprite interface.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     * @param d surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add the object to the game.
     * @param g game
     */
    void addToGame(GameLevel g);
}