import biuoop.DrawSurface;
import java.awt.Color;

/**
 * A ScoreIndicator class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-03
 */
public class ScoreIndicator implements Sprite {
    private Counter currentScore;

    /**
     * constructor.
     * @param scoreCounter count the score
     */
    public ScoreIndicator(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * draw the sprite to the screen.
     * @param d surface
     */
    @Override
    public void drawOn(DrawSurface d) {
           // d.setColor(Color.BLACK);
            d.drawText(400, 13, "Score:" + currentScore.getValue(), 15);

        }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * add the object to the game.
     * @param g game
     */
    @Override
    public void addToGame(GameLevel g) {
    g.addSprite(this);
    }
}
