import biuoop.DrawSurface;
import java.util.ArrayList;

/**
 * A SpriteCollection class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public class SpriteCollection {
    private java.util.List<Sprite> spriteCollection;

    /**
     * construct.
     */
    public SpriteCollection() {
        this.spriteCollection = new ArrayList<>();
    }

    /**
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        this.spriteCollection.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < spriteCollection.size(); i++) {
            spriteCollection.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d surface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < spriteCollection.size(); i++) {
            spriteCollection.get(i).drawOn(d);
        }
    }

    /**
     * remove the sprite.
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        this.spriteCollection.remove(s);
    }
}