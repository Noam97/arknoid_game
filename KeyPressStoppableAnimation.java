import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * A KeyPressStoppableAnimation class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * @param sensor sensor
     * @param key white space
     * @param animation animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * the logic from the previous run method goes here.
     * the `return` or `break` statements should be replaced with this.running = false;
     *
     * @param d drawSurface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.sensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * is in charge of stopping condition.
     *
     * @return stopping condition
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
