import java.util.Arrays;

public class Brute {
	
	public static void main(String[] args) {
		
        Point[] inputPoints;
        Point[] collinearPoints = new Point[4];
        
		// rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        
        // read in the input
        String filename = args[0];
        In in = new In(filename);
        
        // read in total num of points
        int N = in.readInt();
        
        // create the array of points
        inputPoints = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            inputPoints[i] = new Point(x, y);
            inputPoints[i].draw();
        }
       
        for (int i = 0; i < N; i++) {
        	
        	for (int j = i + 1; j < N; j++) {
        		
        		if (inputPoints[i].compareTo(inputPoints[j]) == 0) continue;
        		
        		double firstSlope = inputPoints[i].slopeTo(inputPoints[j]);
        		
            	for (int k = j + 1; k < N; k++) {
            		
            		if (inputPoints[i].compareTo(inputPoints[k]) == 0 ||
            			inputPoints[j].compareTo(inputPoints[k]) == 0) {
            			continue;
            		}
            		
            		double secondSlope = inputPoints[i].slopeTo(inputPoints[k]);
            		
                   	for (int l = k + 1; l < N; l++) {
                   		
                		if (inputPoints[i].compareTo(inputPoints[l]) == 0 ||
                    		inputPoints[j].compareTo(inputPoints[l]) == 0 ||
                    		inputPoints[k].compareTo(inputPoints[l]) == 0) {
                    			continue;
                    		}
                		
                   		double thirdSlope = inputPoints[i].slopeTo(inputPoints[l]);
                   		
                		if (firstSlope == secondSlope && firstSlope == thirdSlope) {
                			
                			collinearPoints[0] = inputPoints[i];
                			collinearPoints[1] = inputPoints[j];
                			collinearPoints[2] = inputPoints[k];
                			collinearPoints[3] = inputPoints[l];
                			
                			Arrays.sort(collinearPoints);
                			
                			collinearPoints[0].drawTo(collinearPoints[3]);
                			//StdDraw.show(10);
                			StdOut.println(collinearPoints[0].toString() + "-> " + 
                					       collinearPoints[1].toString() + "-> " +
                					       collinearPoints[2].toString() + "-> " +
                					       collinearPoints[3].toString());
                		}
                   	}
                }
            }
        }
        // display to screen all at once
        StdDraw.show(0);
	}

}