import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * A AnimationRunner class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor.
     *
     * @param framesPerSecond the number of the frames in second
     * @param guiGame         the gui of the game
     */
    public AnimationRunner(int framesPerSecond, GUI guiGame) {
        this.gui = guiGame;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * The method run the game -- start the animation loop.
     *
     * @param animation animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / 60;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
      //  gui.close();
    }
}
