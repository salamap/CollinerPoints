CollinearPoints
==============
Recognizing line patterns in a given set of points.

Computer vision involves analyzing patterns in visual images and reconstructing the real-world objects that produced them. The process in often broken up into two phases: feature detection and pattern recognition. Feature detection involves selecting important features of the image; pattern recognition involves discovering patterns in the features. We will investigate a particularly clean pattern recognition problem involving points and line segments. This kind of pattern recognition arises in many other applications such as statistical data analysis.

The problem. Given a set of N distinct points in the plane, draw every (maximal) line segment that connects a subset of 4 or more of the points.

The API:
public class Point implements Comparable<Point> {
   public final Comparator<Point> SLOPE_ORDER;        // compare points by slope to this point

   public Point(int x, int y)                         // construct the point (x, y)

   public   void draw()                               // draw this point
   public   void drawTo(Point that)                   // draw the line segment from this point to that point
   public String toString()                           // string representation

   public    int compareTo(Point that)                // is this point lexicographically smaller than that point?
   public double slopeTo(Point that)                  // the slope between this point and that point
}

The compareTo() method compares points by their y-coordinates, breaking ties by their x-coordinates. Formally, the invoking point (x0, y0) is less than the argument point (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
The slopeTo() method returns the slope between the invoking point (x0, y0) and the argument point (x1, y1), which is given by the formula (y1 − y0) / (x1 − x0).

The SLOPE_ORDER comparator compares points by the slopes they make with the invoking point (x0, y0). Formally, the point (x1, y1) is less than the point (x2, y2) if and only if the slope (y1 − y0) / (x1 − x0) is less than the slope (y2 − y0) / (x2 − x0).

A faster, sorting-based solution. Given a point p, the following method determines whether p participates in a set of 4 or more collinear points.

Think of p as the origin.
For each other point q, determine the slope it makes with p.
Sort the points according to the slopes they makes with p.
Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p. If so, these points, together with p, are collinear.
Applying this method for each of the N points in turn yields an efficient algorithm to the problem. The algorithm solves the problem because points that have equal slopes with respect to p are collinear, and sorting brings such points together. The algorithm is fast because the bottleneck operation is sorting.
