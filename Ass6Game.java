import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * A SpriteCollection class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public class Ass6Game {
    /**
     * @param args array of inputs
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Game", 800, 600);
        AnimationRunner ar = new AnimationRunner(60, gui);
        GameFlow gameFlow = new GameFlow(ar, gui.getKeyboardSensor(), gui);
        List<LevelInformation> basicList = new ArrayList<>();
        basicList.add(new Level1());
        basicList.add(new Level2());
        basicList.add(new Level3());
        basicList.add(new Level4());
        List<LevelInformation> list = new ArrayList<>();
        for (String arg : args) {
            if (arg.equals("1")) {
                list.add(new Level1());
            }
            if (arg.equals("2")) {
                list.add(new Level2());
            }
            if (arg.equals("3")) {
                list.add(new Level3());
            }
            if (arg.equals("4")) {
                list.add(new Level4());
            }
        }
        if (list.size() == 0) {
            gameFlow.runLevels(basicList);
        } else {
            gameFlow.runLevels(list);
        }
    }
}


