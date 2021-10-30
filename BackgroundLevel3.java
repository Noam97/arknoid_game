import biuoop.DrawSurface;
import java.awt.Color;
/**
 * A BackgroundLLevel3 class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class BackgroundLevel3 implements Sprite {
    private Color color;

    /**
     * constructor.
     * @param color color of the background
     */
    public BackgroundLevel3(Color color) {
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
        d.setColor(Color.BLACK);
        d.fillRectangle(100,400, 100, 600);
        d.setColor(Color.WHITE);
        d.fillRectangle(120,420, 60, 580);
        d.setColor(Color.BLACK);
        d.drawLine(150, 420, 150, 600);
        d.setColor(Color.BLACK);
        d.drawLine(120, 510, 180, 510);
        d.setColor(Color.darkGray);
        d.fillRectangle(135,330, 30,70);
        d.setColor(Color.darkGray);
        d.fillRectangle(142,250, 15,80);
        d.setColor(Color.ORANGE);
        d.fillCircle(150, 240, 10);
        d.setColor(Color.RED);
        d.fillCircle(150, 240, 8);
        d.setColor(Color.WHITE);
        d.fillCircle(150, 240, 3);
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
