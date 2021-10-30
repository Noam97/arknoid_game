import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import  java.awt.Color;

/**
 * A Bouncing Ball Animation class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-04-22
 */
public class BouncingBallAnimation {
    /**
     * @param start The start point of the ball
     * @param dx    the change in position on the "x" axes
     * @param dy    the change in position on the "y" axes
     */
    private static void drawAnimation(Point start, double dx, double dy) {
        java.util.Random rand = new java.util.Random();
        GUI gui = new GUI("Bouncing Ball Animation", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(new Point(start.getX(), start.getY()), 15, Color.PINK);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep(new Point(0, 0),  new Point(200, 200));
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    /**
     * @param args inputs
     */
    public static void main(String[] args) {
        Point start = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        int dx = Integer.parseInt(args[2]);
        int dy = Integer.parseInt(args[3]);
        drawAnimation(start, dx, dy);
    }
}

//        GUI gui = new GUI("title", 200, 200);
//        Sleeper sleeper = new Sleeper();
//        Ball ball = new Ball(new Point(rand.nextInt(200) - 1, rand.nextInt(200) - 1),
//                rand.nextInt(20) - 1, java.awt.Color.BLACK);
//        collisionDetection.Velocity v = collisionDetection.Velocity.fromAngleAndSpeed(50, 15);
//        ball.setVelocity(v);
//        while (true) {
//            ball.moveOneStep(new Point(0, 0), new Point(200, 200));
//            DrawSurface d = gui.getDrawSurface();
//            ball.drawOn(d);
//            gui.show(d);
//            sleeper.sleepFor(50);  // wait for 50 milliseconds.
//        }

