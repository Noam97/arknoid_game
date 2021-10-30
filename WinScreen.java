import biuoop.DrawSurface;
/**
 * A WinScreen class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class WinScreen implements Animation {
    private Counter score;
    private boolean stop;

    /**
     * constructor.
     * @param score score
     */
    public WinScreen(Counter score) {
        this.stop = false;
        this.score = score;
    }
    /**
     * the logic from the previous run method goes here.
     * the `return` or `break` statements should be replaced with this.running = false;
     *
     * @param d drawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your Score is " + score.getValue(), 32);
    }

    /**
     * is in charge of stopping condition.
     *
     * @return stopping condition
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
