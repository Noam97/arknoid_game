import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
import java.util.ArrayList;

/**
 * A Game class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-05
 */
public class GameLevel implements Animation {
    static final int R = 5;
    private java.util.Random rand = new java.util.Random();
    private GUI gui;
    private biuoop.KeyboardSensor keyboard;
    private DrawSurface dr;
    private double widthOfRectangle;
    private double heightOfRectangle;
    private double yOfFirstRowRectangles;
    private double widthOfGui;
    private double heightOfGui;
    private int numberOfRectangleInFirstRow;
    private int numberOfRows;
    private double widthOfFrame;
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation level;
    private PrintingHitListener printingHitListener;


    /**
     * constructor.
     *
     * @param guiGame the gui of the game
     * @param runner  runner
     * @param level   level information
     * @param score score
     */
    public GameLevel(AnimationRunner runner, GUI guiGame, LevelInformation level, Counter score) {
        this.widthOfRectangle = 50;
        this.heightOfRectangle = 20;
        this.widthOfGui = 800;
        this.yOfFirstRowRectangles = 150;
        this.numberOfRectangleInFirstRow = 12;
        this.numberOfRows = 6;
        this.widthOfFrame = 20;
        this.heightOfGui = 600;
        this.runner = runner;
        this.gui = guiGame;
        this.keyboard = gui.getKeyboardSensor();
        this.dr = gui.getDrawSurface();
        this.level = level;
        this.remainingBlocks = new Counter(level.numberOfBlocksToRemove());
        this.remainingBalls = new Counter(level.numberOfBalls());
        this.score = score;
    }

    /**
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle).
     */
    public void initialize() {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        NameIndicator nameIndicator = new NameIndicator(this.level);
        BlockRemover blockRemover = new BlockRemover(this, remainingBlocks);

        this.sprites.addSprite(level.getBackground());
        createFrame();
        level.blocks();
        for (Block b : level.blocks()) {
            b.addToGame(this);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTrackingListener);
           // b.addHitListener(printingHitListener);
        }

        createPaddle();
        createTitleRectangle();
        scoreIndicator.addToGame(this);
        nameIndicator.addToGame(this);



    }

    /**
     * create the frame of the screen by blocks and and add them to the game.
     */
    public void createFrame() {
        this.remainingBalls = new Counter();
        HitListener ballRemover = new BallRemover(remainingBalls, this);
        //the left block

        Rectangle r1 = new Rectangle(new Point(0, 0), this.widthOfFrame, this.heightOfGui);
        Block b1 = new Block(Color.gray, r1);
        //the right block
        Rectangle r2 = new Rectangle(new Point(this.widthOfGui - this.widthOfFrame, 0),
                this.widthOfFrame, this.heightOfGui);
        Block b2 = new Block(Color.gray, r2);
        //the upper block
        Rectangle r3 = new Rectangle(new Point(0, 20), this.widthOfGui, this.widthOfFrame);
        Block b3 = new Block(Color.gray, r3);
        //the lower block
        Rectangle r4 = new Rectangle(new Point(0, this.heightOfGui - this.widthOfFrame + 15),
                this.widthOfGui, 5);
        Block b4 = new Block(Color.gray, r4);
        b4.addHitListener(ballRemover);
        b1.addToGame(this);
        b2.addToGame(this);
        b3.addToGame(this);
        b4.addToGame(this);
    }

    /**
     * The method creates two balls and and add them to the game.
     */
    public void createBalls() {
        for (int i = 0; i < level.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(450, 500), R, Color.white);
//         Ball ball1 = new Ball(new Point((widthOfGui / 2 + 0.5 * level.paddleWidth()),
//                    this.heightOfGui - 2 * this.heightOfRectangle - rand.nextInt(300)),
//                    this.R, Color.WHITE);
        // System.out.println("ball" + "(" + ball.getX() + "," + ball.getY() + ")");


            ball.setVelocity(level.initialBallVelocities().get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
            this.remainingBalls.increase(1);
        }
    }

    /**
     * create paddle and add it to the game.
     */
    public void createPaddle() {
        Rectangle paddleRec = new Rectangle(new Point((this.widthOfGui - level.paddleWidth()) / 2,
                this.heightOfGui - 2 * this.heightOfRectangle), level.paddleWidth(),
                this.heightOfRectangle);
        Block paddleBlock = new Block(Color.ORANGE, paddleRec);
        Paddle paddle = new Paddle(paddleBlock, keyboard, paddleRec, this, level);
        paddle.addToGame(this);
    }

    /**
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * create rectangle which shows the score and the level name.
     */
    public void createTitleRectangle() {
        Rectangle scoreRec = new Rectangle(new Point(0, 0), this.widthOfGui, this.widthOfFrame);
        Block b1 = new Block(Color.white, scoreRec);
        b1.addToGame(this);
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        sprites.drawAllOn(d);
        sprites.notifyAllTimePassed();
        if (this.remainingBalls.getValue() == 0) {
            this.running = false;
            return;
        }
        if (this.remainingBlocks.getValue() <= 0) {
          //  System.out.println(remainingBlocks.getValue());
            this.running = false;
            this.score.increase(100);
            return;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * @return remaining balls
     */
    public int getRemainingBalls() {
        return remainingBalls.getValue();
    }

    /**
     * The method run the game -- start the animation loop.
     */
    public void run() {
        this.createBalls();
        this.running = true;
        this.runner.run(this);
    }
}

