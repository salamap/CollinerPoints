/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();

    private final int x;                               // x coordinate
    private final int y;                               // y coordinate

    private final double POSITIVE_ZERO = +0.0;         // y coordinates are equal
    
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
    	if (that.y == this.y && that.x == this.x) return Double.NEGATIVE_INFINITY;
    	
    	if (that.x == this.x) return Double.POSITIVE_INFINITY;
    	
    	if (that.y == this.y) return POSITIVE_ZERO;
    	
    	return (double)(that.y - this.y)/(that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    	if (this.y < that.y) return -1;
    	
    	if (this.y == that.y && this.x < that.x) return -1;
    	
    	if (this.y == that.y && this.x == that.x) return 0;
    	
    	return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    
    private class SlopeOrder implements Comparator<Point> {

		@Override
		public int compare(Point q, Point r) {
			// TODO Auto-generated method stub
			if ((Point.this.slopeTo(q) - Point.this.slopeTo(r)) > 0) return 1;
			if ((Point.this.slopeTo(q) - Point.this.slopeTo(r)) < 0) return -1;
			return 0;
		}
    	
    }
  }