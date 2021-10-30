import biuoop.DrawSurface;
import java.awt.Color;
    /**
     * A BackgroundLevel2 class.
     *
     * @author Noam Lachmani <noamm240@gmail.com>
     * @version 1.6
     * @since 2020-06-18
     */
    public class BackgroundLevel2 implements Sprite {

        private Color color;

        /**
         * constructor.
         * @param color color of the background
         */
        public BackgroundLevel2(Color color) {
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
            d.setColor(Color.orange);
            d.fillCircle(100,  50, 130);
            d.setColor(Color.yellow);
            d.fillCircle(100,  50, 100);
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
