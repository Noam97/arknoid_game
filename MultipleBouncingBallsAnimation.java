import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * MultipleBouncingBallsAnimation class.
 * The method creates multiple bouncing balls animation.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-04-22
 */
public class MultipleBouncingBallsAnimation {
    /**
     * The method creates balls and put them into an array.
     *
     * @param args  array of inputs
     * @param balls array of balls
     * @return ball
     */
    public static Ball[] ballsSetter(Ball[] balls, String[] args) {
        java.util.Random rand = new java.util.Random();
        int j;
        int speed;
        double angle;
        Velocity v;
        for (j = 0; j < args.length; j++) {
            int r = Integer.parseInt(args[j]);
            Color randomColor = new Color(rand.nextInt(0xFFFFFF));
            int x = 50 + rand.nextInt(50);
            int y = 50 + rand.nextInt(50);
            balls[j] = new Ball(new Point(x, y), r, randomColor);
            speed = speedSetting(r);
            angle = angleSetting();
            v = Velocity.fromAngleAndSpeed(angle, speed);
            balls[j].setVelocity(v);
        }
        return balls;
    }


    /**
     * The method returns a random speed of the ball
     * larger ball is slower (but ball above size 50 can all have the same slow speed).
     *
     * @param r radius of the ball
     * @return the speed of the ball
     */
    public static int speedSetting(int r) {
        java.util.Random rand = new java.util.Random();
        int speed;
        int randomNumber = 30 + rand.nextInt(20);
        if (r < 50) {
            speed = randomNumber / r;
        } else {
            speed = 5;
        }
        return speed;
    }

    /**
     * The method a random angle between 0 and 180.
     *
     * @return random angle
     */
    public static double angleSetting() {
        java.util.Random rand = new java.util.Random();
        int randomAngle = rand.nextInt(180);
        return randomAngle;
    }

    /**
     * @param width  of the board screen
     * @param height of the board screen
     * @return the screen
     */
    public static GUI screenSizeOf(int width, int height) {
        GUI gui = new GUI("Multiple Bouncing Balls Animation", width, height);
        return gui;
    }

    /**
     * @param balls  array of balls
     * @param height of the board
     * @param width  of the board
     * @param gui the screen
     * @return none
     */
    public static Void drawMultipleBouncingBallsAnimation(Ball[] balls, int width, int height, GUI gui) {
        Sleeper sleeper = new Sleeper();
        DrawSurface d;
        while (true) {
            d = gui.getDrawSurface();
            for (int i = 0; i < balls.length; i++) {
                balls[i].moveOneStep(new Point(0, 0), new Point(300, 300));
                balls[i].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
    /**
     * @param args array of inputs
     */
    public static void main(String[] args) {
        int width = 300;
        int height = 300;
        GUI gui = screenSizeOf(width, height);
        Ball[] balls = new Ball[args.length];
        ballsSetter(balls, args);
        drawMultipleBouncingBallsAnimation(balls, width, height, gui);
    }
}
