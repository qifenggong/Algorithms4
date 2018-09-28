package algorithms.fundamentals;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Counter implements Comparable<Counter>{

	private final String name;
	private int count = 0;
	
	public Counter(String id) {
		name = id;
	}
	
	public void increment() {
		count++;
	}
	
	public int tally() {
		return count;
	}
	
	public String toString() {
		return count + " " + name;
	}
	
	@Override
	public int compareTo(Counter that) {
		if      (this.count < that.count) return -1;
        else if (this.count > that.count) return +1;
        else                              return  0;
	}
	
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		
		Counter[] hits = new Counter[n];
		for(int i = 0; i < n; i++) {
			hits[i] = new Counter("counter" + i);
		}
		// increment trials counters at random
		for(int t = 1; t < trials; t++) {
			hits[StdRandom.uniform(t)].increment();
		}
		
		// print results
		for(int i = 0; i < n; i++) {
			StdOut.println(hits[i]);
		}

	}

}
