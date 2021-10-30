import biuoop.DrawSurface;
import java.awt.Color;
/**
 * A BackgroundLevel4 class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class BackgroundLevel4 implements Sprite {

    private Color color;

    /**
     * constructor.
     * @param color color of the background
     */
    public BackgroundLevel4(Color color) {
        this.color = color;
    }
    /**
     * draw the sprite to the screen.
     *
     * @param d surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        Rectangle rec = new Rectangle(new Point(0, 0), 800, 600);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.pink);
        d.drawCircle(100,  500, 100);
        d.drawCircle(100,  500, 70);
        d.drawCircle(100,  500, 50);

        d.drawCircle(500,  100, 100);
        d.drawCircle(500,  100, 45);
        d.drawCircle(500,  100, 65);
    }


    /**
     * notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }

    /**
     * add the object to the game.
     *
     * @param g game
     */
    @Override
    public void addToGame(GameLevel g) {
    }
}
