import java.util.ArrayList;
import java.util.List;

/**
 * A Rectangle class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-05-06
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    //list of lines who have intersection points with the rectangle
    private java.util.List<Line> intersectionLines;

    /**
     * The method creates a new rectangle with location and width/height.
     *
     * @param upperLeft The upper left point of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.intersectionLines = new ArrayList<>();
    }

    /**
     * @return the upper side of the rectangle
     */
    public Line upperLineRectangle() {
        //     Point downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Line upperLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + width, this.upperLeft.getY());
        return upperLineOfRectangle;
    }

    /**
     * @return the lower side  of the rectangle
     */
    public Line lowerLineRectangle() {
        Point downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point downRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + this.height);
        Line lowerLineOfRectangle = new Line(downLeft.getX(), downLeft.getY(), downRight.getX(), downRight.getY());
        return lowerLineOfRectangle;
    }

    /**
     * @return the left side of the rectangle
     */
    public Line leftLineRectangle() {
        Point downLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Line leftLineOfRectangle = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                downLeft.getX(), downLeft.getY());
        return leftLineOfRectangle;
    }

    /**
     * @return the right side of the rectangle
     */
    public Line rightLineRectangle() {
        Point upperRight = new Point(this.upperLeft.getX() + this.width, upperLeft.getY());
        Point downRight = new Point(upperRight.getX(), this.upperLeft.getY() + this.height);
        Line rightLineOfRectangle = new Line(upperRight.getX(), upperRight.getY(), downRight.getX(), downRight.getY());
        return rightLineOfRectangle;
    }

    /**
     *
     * @return list of lines of rectangle
     */
    public java.util.List<Line> linesOfRectangle() {
        List rectangleSides = new ArrayList();
        rectangleSides.add(upperLineRectangle());
        rectangleSides.add(lowerLineRectangle());
        rectangleSides.add(leftLineRectangle());
        rectangleSides.add(rightLineRectangle());
        return rectangleSides;
    }

    /**
     * @param line line
     * @return a (possibly empty) List of intersection points
     * with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Line> linesOfRectangle = linesOfRectangle();
        java.util.List<Point> intersectionsList = new ArrayList();
        for (int i = 0; i < linesOfRectangle.size(); i++) {
            if (!(linesOfRectangle.get(i).isIntersecting(line))) {
                continue;
            } else {
                intersectionsList.add(linesOfRectangle.get(i).intersectionWith(line));
                intersectionLines.add(linesOfRectangle.get(i));
            }
        }
        return intersectionsList;
    }


    /**
     * @return the width  of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @return list of lines which have intersection points with the rectangle
     */
    public java.util.List<Line> getListOfIntersectLines() {
        return intersectionLines;
    }

    /**
     *
     * @param args array of inputs
     */
    public static void main(String[] args) {
        int x = 50;
        int y = 100;
        Point upperLeft = new Point(x, y);
        double width = 500;
        double height = 200;
        int x1 = 0;
        int y1 = 0;
        int x2 = 800;
        int y2 = 800;
        Line line = new Line(x1, y1, x2, y2);
        Rectangle r = new Rectangle(upperLeft, width, height);
        java.util.List<Line> list = r.linesOfRectangle();
        java.util.List<Point> pointsList = r.intersectionPoints(line);
        java.util.List<Line> intersectionLines = r.getListOfIntersectLines();
        Point point = line.closestIntersectionToStartOfLine(r);
    }
}