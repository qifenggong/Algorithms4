package algorithms.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedBag<Item> implements Iterable<Item> {

	private class Node{
		private Item item;
		private Node next;
	}
	
	private Node first;
	private int n;
	
	public LinkedBag() {
		first = null;
		n = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return n;
	}
	
	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		n++;
	}
	
	public Iterator<Item> iterator(){
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<Item>{
		private Node current;
		
		public BagIterator() {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		LinkedBag<String> bag = new LinkedBag<String>();
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			bag.add(s);	
		}

		StdOut.println("the size of bag: " + bag.size());
		for(String item:bag) {
			StdOut.print(item + " ");
		}
	}

}
