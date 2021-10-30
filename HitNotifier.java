/**
 * A HitNotifier interface.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-03
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl hit listener
     */
    void addHitListener(HitListener hl);

    /**
     *  Remove hl from the list of listeners to hit events.
     * @param hl hit listener
     */
    void removeHitListener(HitListener hl);
}
