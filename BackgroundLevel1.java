import biuoop.DrawSurface;
import java.awt.Color;
/**
 * A BackgroundLevel1 class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class BackgroundLevel1 implements Sprite {

    private Color color;

    /**
     * constructor.
     * @param color color of the background
     */
    public BackgroundLevel1(Color color) {
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
        d.setColor(Color.BLUE);
        //upper line
        d.drawLine(425, 20, 425,150);
        //lower line
        d.drawLine(425, 200, 425,330);
        //right line
        d.drawLine(450, 175, 580,175);
        //left line
        d.drawLine(400, 175, 270,175);
        d.drawCircle(425,  175, 100);
        d.drawCircle(425,  175, 50);
        d.drawCircle(425,  175, 25);

    }

    public void backgroundLevel1 (DrawSurface d) {

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
