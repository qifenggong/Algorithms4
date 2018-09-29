package algorithms.fundamentals;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings<Item> implements Iterable<Item>{

	private Item[] a;
	private int N;//size
	
	public FixedCapacityStackOfStrings() {
		a = (Item[]) new Object[2];
		N = 0;
	}
	
	public void push(Item item) {
		if(N == a.length) resize(2*a.length);
		a[N++] = item;
	}
	
	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length/4) resize(a.length/2);
		return item;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for(int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public Iterator<Item> iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;
		public boolean hasNext() { return i > 0; }
		public Item next() { return a[--i]; }
		public void remove() {
			
		}
	}
	
	public static void main(String[] args) {
		FixedCapacityStackOfStrings<String> s = new FixedCapacityStackOfStrings<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) {
				s.push(item);
			} else if(!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("("+s.size()+" left on the stack)");
	}

}
