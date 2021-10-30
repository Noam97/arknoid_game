import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * A Level2 class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class Level2 implements LevelInformation {
    static final double RECTANGLE_HEIGHT = 20;
    static final double Y_FIRST_ROW = 250;
    static final double GUI_WIDTH = 800;
    static final double FRAME_GUI = 20;
    static final int RECTANGLES_NUMBER = 10;
    private double rectangleWidth = (GUI_WIDTH - 2 * FRAME_GUI) / RECTANGLES_NUMBER;



    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        java.util.List velocities = new ArrayList();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(Velocity.fromAngleAndSpeed(10 + (i + 1) * 5, 5));
            velocities.add(Velocity.fromAngleAndSpeed(-60 + (i + 1) * 5, 5));

        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 20;
    }

    @Override
    public int paddleWidth() {
        return 400;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
       // Background b = new Background(Color.pink);
        BackgroundLevel2 b = new BackgroundLevel2(Color.WHITE);
        return b;
    }
    @Override
    public List<Block> blocks() {
        java.util.List<Block> blocks = new ArrayList<>();
      //  System.out.println(rectangleWidth);
        for (int i = 0; i < this.RECTANGLES_NUMBER; i++) {
            Point upperLeft = new Point(this.FRAME_GUI + this.rectangleWidth * i, this.Y_FIRST_ROW);
           // System.out.println(this.GUI_WIDTH - this.FRAME_GUI + this.rectangleWidth * i);
            Rectangle rec = new Rectangle(new Point(upperLeft.getX(), upperLeft.getY()),
                    this.rectangleWidth, this.RECTANGLE_HEIGHT);
            Block block = new Block(getColorOfRectangle(i), rec);
            blocks.add(block);
        }
        return blocks;
}

    /**
     * @param i index of rectangle
     * @return color of the rectangle
     */
    public Color getColorOfRectangle(int i) {
        if (i == 0 || i == 1) {
            return Color.MAGENTA;
        } else if (i == 2 || i == 3) {
            return Color.red;
        } else if (i == 4 || i == 5) {
            return Color.yellow;
        } else if (i == 6 || i == 7) {
            return Color.CYAN;
        } else {
          return Color.BLUE;
        }
    }
    @Override
    public int numberOfBlocksToRemove() {
        return 10;
    }
}
