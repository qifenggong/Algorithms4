package algorithms.fundamentals;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Average {

	//this class should not be instantiated
	private Average() {}
	
	public static void main(String[] args) {
		int count = 0;
		double sum = 0.0;
		
		while(!StdIn.isEmpty()) {
			double value = StdIn.readDouble();
			sum += value;
			count++;
		}

		// compute the average
		double average = sum/count;
		
		StdOut.println("Average is " + average);
	}

}
