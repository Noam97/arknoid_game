import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A Level1 class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class Level1 implements LevelInformation {
    private java.util.Random rand = new java.util.Random();


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        java.util.List velocities = new ArrayList();
        velocities.add(Velocity.fromAngleAndSpeed(0, 4));
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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
      //  Background b = new Background(Color.CYAN);
        BackgroundLevel1 b = new BackgroundLevel1(Color.BLACK);

        return b;
    }

    @Override
    public List<Block> blocks() {
        java.util.List<Block> blocks = new ArrayList<>();
        Block b =  new Block(Color.red, new Rectangle(new Point(400, 150), 50, 50));
        blocks.add(b);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
