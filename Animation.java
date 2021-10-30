import biuoop.DrawSurface;
/**
 * A Animation interface.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public interface Animation {
    /**
     * the logic from the previous run method goes here.
     * the `return` or `break` statements should be replaced with this.running = false;
     * @param d drawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * is in charge of stopping condition.
     * @return stopping condition
     */
    boolean shouldStop();
}
