import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * A Level3 class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class Level3 implements LevelInformation {

    static final double RECTANGLE_HEIGHT = 25;
    static final double RECTANGLE_WIDTH = 55;
    static final int ROWS_NUMBER = 5;
    static final double Y_FIRST_ROW = 150;
    static final double GUI_WIDTH = 800;
    static final double FRAME_GUI = 20;
    static final int RECTANGLES_NUMBER = 10;
    private Color color;

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        java.util.List velocities = new ArrayList();
        for (int i = 0; i < numberOfBalls(); i++) {
            java.util.Random rand = new java.util.Random();
            velocities.add(Velocity.fromAngleAndSpeed(100 + rand.nextInt(200), 4));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        BackgroundLevel3 b = new BackgroundLevel3(Color.green);
        return b;
    }

    /**
     * @return list of rectangles
     */
    public java.util.List<Rectangle> rectangles() {
        java.util.List<Rectangle> rectangles = new ArrayList<>();
        for (int i = 0; i < this.ROWS_NUMBER; i++) {
            for (int j = 1; j < this.RECTANGLES_NUMBER + 1 - i; j++) {
                Point upperLeft = new Point(this.GUI_WIDTH - FRAME_GUI - j * this.RECTANGLE_WIDTH,
                        this.Y_FIRST_ROW + i * this.RECTANGLE_HEIGHT);
                Rectangle rec = new Rectangle(new Point(upperLeft.getX(), upperLeft.getY()),
                        this.RECTANGLE_WIDTH, this.RECTANGLE_HEIGHT);
                rectangles.add(rec);
            }
        }
        return rectangles;
    }

    @Override
    public List<Block> blocks() {
        java.util.List<Block> blocks = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < this.ROWS_NUMBER; i++) {
            int numberOfRectanglesInRow = RECTANGLES_NUMBER + 1 - i;
            for (int j = 1; j < numberOfRectanglesInRow; j++) {
                Point upperLeft = new Point(this.GUI_WIDTH - this.FRAME_GUI - j * this.RECTANGLE_WIDTH,
                        this.Y_FIRST_ROW + i * this.RECTANGLE_HEIGHT);
                Block b = new Block(getColorOfRectangle(i), rectangles().get(counter));
                blocks.add(b);
                counter++;
            }
        }
        return blocks;
    }

    /**
     * @param i index of the row
     * @return color according to the index
     */
    public Color getColorOfRectangle(int i) {
        if (i == 0) {
            this.color = Color.gray;
            return Color.gray;
        } else if (i == 1) {
            this.color = Color.red;
            return this.color;
        } else if (i == 2) {
            this.color = Color.yellow;
            return this.color;
        } else if (i == 3) {
            this.color = Color.blue;
            return this.color;
        } else if (i == 4) {
            this.color = Color.pink;
            return this.color;
        }
        //i=5
        this.color = Color.green;
        return this.color;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}