import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A Level4 class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class Level4 implements LevelInformation {

    static final double RECTANGLE_HEIGHT = 20;
    static final double RECTANGLE_WIDTH = 60;
    static final int ROWS_NUMBER = 7;
    static final double Y_FIRST_ROW = 150;
    static final double GUI_WIDTH = 800;
    static final double FRAME_GUI = 20;
    static final int RECTANGLES_NUMBER = 15;
    private Color color;
    private double rectangleWidth = (GUI_WIDTH - 2 * FRAME_GUI) / RECTANGLES_NUMBER;


    @Override
    public int numberOfBalls() {
        return 3;
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
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Finall Four";
    }

    @Override
    public Sprite getBackground() {
        BackgroundLevel4 b = new BackgroundLevel4(Color.blue);
        return b;
    }

    @Override
    public List<Block> blocks() {
        java.util.List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < ROWS_NUMBER; i++) {
            for (int j = 0; j < RECTANGLES_NUMBER; j++) {
                Point upperLeft = new Point(this.FRAME_GUI + this.rectangleWidth * j,
                        Y_FIRST_ROW + (i * this.RECTANGLE_HEIGHT));
                Rectangle rec = new Rectangle(upperLeft, this.rectangleWidth, RECTANGLE_HEIGHT);
                Block b = new Block(getRowColor(i), rec);
                blocks.add(b);
            }
        }
        return blocks;
    }

    /**
     * @param i index
     * @return color
     */
    public Color getRowColor(int i) {
        if (i == 1) {
            return Color.gray;
        }
        if (i == 2) {
            return Color.red;
        }
        if (i == 3) {
            return Color.CYAN;
        }
        if (i == 4) {
            return Color.green;
        }
        if (i == 5) {
            return Color.white;
        }
        if (i == 6) {
            return Color.pink;
        } else {
            return Color.yellow;
        }
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
