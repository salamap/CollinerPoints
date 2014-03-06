import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Fast {
	
	private static void drawAndPrint(ArrayList<Point> myList) {
		Collections.sort(myList);
		myList.get(0).drawTo(myList.get(myList.size() - 1));
		StdDraw.show(20);
		for (int i = 0; i < myList.size() - 1; i++) {
			StdOut.print(myList.get(i).toString() + "-> ");
		}
		StdOut.println(myList.get(myList.size() - 1).toString());
	}
	
	
	public static void main(String[] args) {
		// rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        
		Point [] points;
		Point furthestPoint = null;

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        
        // read in total num of points
        int N = in.readInt();
        
        // create the array of points
        points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
            points[i].draw();
        }
        
        Arrays.sort(points);
        
        for (int i = 0; i < N; i++) {
        	Point origin = points[i];
        	Arrays.sort(points, i, N, origin.SLOPE_ORDER);
            ArrayList<Point> drawQ = new ArrayList<Point>();
   			
        	for (int j = i + 1; j < N; j++) {
           		if (drawQ.isEmpty()) {
        			drawQ.add(origin);
        			drawQ.add(points[j]);
        			continue;
        		}
           		if (origin.slopeTo(points[j]) == origin.slopeTo(drawQ.get(drawQ.size() - 1))) {
           			drawQ.add(points[j]);
           		}
           		else {
           			if (drawQ.size() >= 4 && furthestPoint != drawQ.get(drawQ.size()-1)) {
           				furthestPoint = drawQ.get(drawQ.size()-1);
           				drawAndPrint(drawQ);
           			}
           			drawQ.clear();
           			drawQ.add(origin);
           			drawQ.add(points[j]);
           		}
        	}
   			if (drawQ.size() >= 4 && furthestPoint != drawQ.get(drawQ.size()-1)) {
   				furthestPoint = drawQ.get(drawQ.size()-1);
   				drawAndPrint(drawQ);
		        drawQ.clear();
   			}
        }
        StdDraw.show(0);
	}
}