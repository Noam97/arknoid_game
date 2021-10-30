import biuoop.DrawSurface;

import java.awt.Color;
/**
 * A NameIndicator class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class NameIndicator implements Sprite {
    private LevelInformation level;

    /**
     * constructor.
     * @param level level
     */
    public NameIndicator(LevelInformation level)  {
        this.level = level;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(600, 13, "Level Name: " + level.levelName(), 15);
    }

    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }

    /**[
     * add the object to the game.
     *
     * @param g game
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}
