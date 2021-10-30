import static java.lang.Double.isInfinite;

/**
 * A line class.
 *
 * @author Noam Lachmani <noamm240@gmail.com>
 * @version 1.6
 * @since 2020-04-22
 */
public class Line {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double m1;
    private double m2;
    private Point start;
    private Point end;
    /**
     * construct a line given start and end points.
     *
     * @param start starting point
     * @param end   ending point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        double dx = this.start.getX() - this.end.getX();
        double dy = this.start.getY() - this.end.getY();

    }
    /**
     * construct a line given x1,y1,x2,y2 coordinates.
     *
     * @param x1 the x1 coordinate
     * @param y1 the y1 coordinate
     * @param x2 the x2 coordinate
     * @param y2 the y2 coordinate
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * @return the length of the line
     */
    public double length() {
        return start.distance(end);
    }
    /**
     * @return the middle point of the line
     */
    public Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;
        return new Point(middleX, middleY);
    }
    /**
     * @return the start point of the line
     */
    public Point start() {
        return this.start;
    }
    /**
     * @return the end point of the line
     */
    public Point end() {
        return this.end;
    }
    /**
     * The method checks if the lines intersect.
     *
     * @param other x1,y1,x2,y2 coordinate of other line x1
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersectionLines(Line other) {
        double dxA = this.start.getX() - this.end.getX();
        double dyA = this.start.getY() - this.end.getY();

        double dxB = other.start.getX() - other.end.getX();
        double dyB = other.start.getY() - other.end.getY();
        this.m1 = dyA / dxA;
        this.m2 = dyB / dxB;
        //check if one of the lines is parallel to Y-axis, but the other is not.
        if ((dxA == 0 && dxB != 0) || (dxA != 0 && dxB == 0)) {
            return true;
        }

        //check if the segments are parallel and also if the segment are not in the same line.
        if (Math.abs(this.m1 - this.m2) <= 0.0000001) {
            if (this.end == other.end) {
                return true;
            }
            if (this.start == other.start) {
                return true;
            }
            if (this.start == other.end) {
                return true;
            }
            if (this.end == other.start) {
                return true;
            }
            return false;
        }

        if (equals(other)) {
            return false;
        }

        return true;
    }

    /**
     * @param other x1,y1,x2,y2 coordinate of other line x1
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (!isIntersectionLines(other)) {
            return null;
        }

        double b1 = this.y1 - this.m1 * this.x1;
        double b2 = other.start().getY() - this.m2 * other.start.getX();
        double intersectX = (b2 - b1) / (this.m1 - this.m2);
        double intersectY;

        //if line1 is parallel to the Y axis
        if (isInfinite(this.m1)) {
            intersectY = this.m2 * this.x1 + b2;
        } else if (isInfinite(this.m2)) {
        //if line1 is parallel to the Y axis.
        intersectY = this.m1 * this.x2 + b1;
        } else {
            intersectY = this.m1 * intersectX + b1;
        }
        Point p = this.intersectCross(other);
        if (p != null) {
            intersectX = p.getX();
            intersectY = p.getY();
        }
        if ((isScopeY(intersectY, other) && isScopeX(intersectX, other))) {
            Point p1 = new Point(intersectX, intersectY);
            return p1;
        }
        return null;
    }

    /**
     *
     * @param other line
     * @return intersection point
     */
    public Point intersectCross(Line other) {
        Point intersect = null;
        if (isInfinite(this.m1) && !isInfinite(this.m2)) {
            intersect = new Point(this.x1, other.y2);
        } else if ((isInfinite(this.m2) && !isInfinite(this.m1))) {
            intersect = new Point(this.x2, other.y1);
        }
        return intersect;
    }

    /**
     * @param other x1,y1,x2,y2 coordinate of other line x1
     * @return true if the segment intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * @param x     Coordinate X of the intersection point
     * @param other x1,y1,x2,y2 coordinate of other line x1
     * @return true if x is in the scope, and false if it is not
     */
    public boolean isScopeX(double x, Line other) {
        double a = this.start.getX();
        double b = this.end.getX();
        double c = other.start.getX();
        double d = other.end.getX();

        if ((Math.min(a, b) <= x && x <= Math.max(a, b)) && (Math.min(c, d) <= x && x <= Math.max(c, d))) {
            return true;
        }
        return false;
    }

    /**
     * @param y     Coordinate X of the intersection point
     * @param other x1,y1,x2,y2 coordinate of other line x1
     * @return true if y is in the scope, and false if it is not
     */
    public boolean isScopeY(double y, Line other) {
        double a = this.start.getY();
        double b = this.end.getY();
        double c = other.start.getY();
        double d = other.end.getY();
        if ((Math.min(a, b) <= y) && (y <= Math.max(a, b)) && (Math.min(c, d) <= y) && (y <= Math.max(c, d))) {
            return true;
        }
        return false;
    }


    /**
     * @param other x1,y1,x2,y2 coordinate of other line
     * @return true if the lines are equal, false other otherwise
     */
    public boolean equals(Line other) {
        if (this.start.getX() == other.start.getX()
                && this.start.getY() == other.start.getY()
                && (this.end.getX() == other.end.getX())
                && (this.end.getY() == other.end.getY())) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param rect rectangle
     * @return If this line does not intersect with the rectangle, return null.
     *          Otherwise, return the closest intersection point to the
     *          start of the line.
     */
        public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> intersects = rect.intersectionPoints(this);
        int numberOfIntersects = intersects.size();
        //there is no intersect points
        if (numberOfIntersects == 0) {
            return null;
        }
        //there is one intersect point
        if (numberOfIntersects == 1) {
            return  intersects.get(0);
        } //there are two intersect points
            if (this.start.distance(intersects.get(0)) <= this.start.distance(intersects.get(1))) {
                return intersects.get(0);
            }

            return intersects.get(1);
        }

//    public static void main(String[] args) {
//
//        Point p1 = new Point(490, 210);
//        Point p2 = new Point(510, 210);
//
//        Line l1 = new Line(500, 0, 500, 600);
//
//        Point p3 = new Point(500, 0);
//        Point p4 = new Point(500, 600);
//
//        Line l2 = new Line(490, 210, 510, 210);
//
//        Point x = l1.intersectionWith(l2);
//
//        System.out.println(x.getX());
//        System.out.println(x.getY());
//
//    }
    }

