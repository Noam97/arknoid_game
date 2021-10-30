import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * A Paddle class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public class Paddle implements Sprite, Collidable {
    static final double WIDTH_GUI = 800;
    static final double WIDTH_FRAME = 20;
    private Rectangle paddle;
    private Block block;
    private biuoop.KeyboardSensor keyboard;
    private GameLevel game;
    private LevelInformation level;
//    private double step = level.paddleSpeed();
private double step;


    /**
     * @param block    block
     * @param keyboard sensor
     * @param paddle   rectangle paddle
     * @param game     game
     * @param level level
     */
    public Paddle(Block block, biuoop.KeyboardSensor keyboard, Rectangle paddle,
                  GameLevel game, LevelInformation level) {
        this.block = block;
        this.keyboard = keyboard;
        this.paddle = paddle;
        this.game = game;
        this.level = level;
        this.step = level.paddleSpeed();
    }

    /**
     * change of step in the negative direction of the X axis.
     */
    public void moveLeft() {
        //change in x axs
        Point upperLeft = this.block.getCollisionRectangle().getUpperLeft();
        if (upperLeft.getX() - step <= WIDTH_FRAME) {
            return;
        }
        upperLeft.setX(upperLeft.getX() - this.step);
    }

    /**
     * change of step in the negative direction of the X axis.
     */
    public void moveRight() {
        Point upperLeft = this.block.getCollisionRectangle().getUpperLeft();
        if (upperLeft.getX() +  this.step + level.paddleWidth() >= this.WIDTH_GUI - this.WIDTH_FRAME) {
            return;
        }
        upperLeft.setX(upperLeft.getX() + step);
    }


    /**
     * sprite method.
     * move left or right according the sensors
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * sprite method.
     *
     * @param d surface
     */
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
    }

    /**
     * collisionDetection.Collidable method.
     *
     * @return collision rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity of the object
     * @param hitter          ball
     * @return velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double widthOfPaddle = paddle.getWidth();
        double lengthOfArea = widthOfPaddle / 5;
        Line rangeX = paddle.upperLineRectangle();
        double colllisionX = collisionPoint.getX();
        double startXpaddle = paddle.upperLineRectangle().start().getX();
        Velocity v = currentVelocity;
        double speed = Math.sqrt(currentVelocity.getDx() * currentVelocity.getDx()
                + currentVelocity.getDy() * currentVelocity.getDy());
        if ((startXpaddle <= colllisionX) && (colllisionX < startXpaddle + lengthOfArea)) {
            v = Velocity.fromAngleAndSpeed(300, speed);
            return v;
        } else if (colllisionX <= startXpaddle + 2 * lengthOfArea) {
            v = Velocity.fromAngleAndSpeed(300, speed);
            return v;
        } else if (colllisionX <= startXpaddle + 3 * lengthOfArea) {
            v = block.hit(hitter, collisionPoint, currentVelocity);
            return v;
        } else if (colllisionX <= startXpaddle + 4 * lengthOfArea) {
            v = Velocity.fromAngleAndSpeed(30, speed);
            return v;
        }
        v = Velocity.fromAngleAndSpeed(60, speed);
        return v;
    }


    /**
     * Add this paddle to the game.
     *
     * @param g game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}


