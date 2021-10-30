import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * MultipleFramesBouncingBallsAnimation class.
 * The method creates multiple bouncing balls animation.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-04-22
 */
public class MultipleFramesBouncingBallsAnimation {
    /**
     * @param args array of inputs
     */
    public static void main(String[] args) {
        int width = 600;
        int height = 600;
        MultipleBouncingBallsAnimation a = new MultipleBouncingBallsAnimation();
        Point upLeftFirstRectangle = new Point(50, 50);
        Point downRightFirstRectangle = new Point(500, 500);
        Point upLeftSecondRectangle = new Point(450, 450);
        Point downRightSecondRectangle = new Point(600, 600);
        Ball[] balls = new Ball[args.length];
        //a.ballsSetter(balls, args);
        multipleFramesBallsSetter(balls, args, a, upLeftFirstRectangle, downRightFirstRectangle);
        GUI gui = a.screenSizeOf(width, height);
        DrawSurface d = gui.getDrawSurface();
        Sleeper sleeper = new Sleeper();
        while (true) {
            d = gui.getDrawSurface();
            //The gray rectangle
            d.setColor(Color.gray);
            int width1 = (int) downRightFirstRectangle.getX() - (int) upLeftFirstRectangle.getX();
            int height1 = (int) downRightFirstRectangle.getY() - (int) upLeftFirstRectangle.getY();
            d.fillRectangle((int) upLeftFirstRectangle.getX(), (int) upLeftFirstRectangle.getY(), width1, height1);
            //The yellow rectangle
            d.setColor(Color.yellow);
            int width2 = (int) downRightSecondRectangle.getX() - (int) upLeftSecondRectangle.getX();
            int height2 = (int) downRightSecondRectangle.getY() - (int) upLeftSecondRectangle.getY();
            d.fillRectangle((int) upLeftSecondRectangle.getX(), (int) upLeftSecondRectangle.getY(), width2, height2);
            //Bouncing balls in the gray rectangle
            for (int i = 0; i < balls.length / 2; i++) {
                balls[i].moveOneStep(upLeftFirstRectangle, downRightFirstRectangle);
                balls[i].drawOn(d);
            }
            //Bouncing balls in the yellow rectangle
            for (int i = balls.length / 2; i < balls.length; i++) {
                balls[i].moveOneStep(upLeftSecondRectangle, downRightSecondRectangle);
                balls[i].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    /**
     * @param balls array og balls
     * @param args  array of inputs
     * @param a     access to methods of MultipleBouncingBallsAnimation
     * @param p1    up and left point of the first rectangle
     * @param p2    down and rightF point of the first rectangle
     * @return array of balls
     */
    public static Ball[] multipleFramesBallsSetter(Ball[] balls, String[] args,
                                                   MultipleBouncingBallsAnimation a, Point p1, Point p2) {
        java.util.Random rand = new java.util.Random();
        int bound1 = (int) p1.getX();
        int bound2 = (int) p2.getX();
        int bound3 = 100;
        int j;
        int speed;
        double angle;
        Velocity v;
        int x, y;
        for (j = 0; j < args.length; j++) {
            int r = Integer.parseInt(args[j]);
            Color randomColor = new Color(rand.nextInt(0xFFFFFF));
            if (j < args.length / 2) {
                x = bound3 + rand.nextInt(bound2 - bound3);
                y = bound3 + rand.nextInt(bound2 - bound3);
            } else {
                x = bound2 + rand.nextInt(bound1);
                y = bound2 + rand.nextInt(bound1);
            }
            balls[j] = new Ball(new Point(x, y), r, randomColor);
            speed = a.speedSetting(r);
            angle = a.angleSetting();
            v = Velocity.fromAngleAndSpeed(angle, speed);
            balls[j].setVelocity(v);
        }
        return balls;
    }

    /**
     * @param upLeft    The up and the left of the rectangle
     * @param downRight The lower and the right of the rectangle
     * @return the width and the height of the rectangle
     */
    public static Point sizeOfRectangle(Point upLeft, Point downRight) {
        double width = downRight.getX() - upLeft.getX();
        double height = downRight.getY() - upLeft.getY();
        Point sizeOfRectangle = new Point(width, height);
        return sizeOfRectangle;
    }

}
