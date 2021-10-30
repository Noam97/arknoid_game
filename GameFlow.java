import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * A GameFlow class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-06-18
 */
public class GameFlow {
    private KeyboardSensor ks;
    private AnimationRunner runner;
    private GUI guiGame;
    private Counter score;

    /**
     * @param ar Animation runner
     * @param ks Keyboard sensor
     * @param guiGame the gui of the game
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI guiGame) {
        this.runner = ar;
        this.ks = ks;
        this.score = new Counter(0);
        this.guiGame = guiGame;
    }

    /**
     * @param levels levels of the game
     */
    @SuppressWarnings("checkstyle:SimplifyBooleanExpression")
    public void runLevels(List<LevelInformation> levels) {
        boolean lost = false;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(runner, guiGame, levelInfo, score);
            level.initialize();
            level.run();
            if ((level.getRemainingBalls() == 0)) {
                lost = true;
                break;
            }
        }
        if (lost) {
            this.runner.run(new LostScreen(score));
        }
        this.runner.run(new WinScreen(score));

    }
}

