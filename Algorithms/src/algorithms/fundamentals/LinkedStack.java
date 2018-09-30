package algorithms.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedStack<Item> implements Iterable<Item> {

	private class Node{
		private Item item;
		private Node next;
	}
	
	private Node first;
	private int N;
	
	public LinkedStack() {
		first = null;
		N = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Item item:this) {
			s.append(item + " ");
		}
		return s.toString();
	}
	
	public Iterator<Item> iterator(){
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{
		private Node current = first;
		
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
		LinkedStack<String> stack = new LinkedStack<String>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(!item.equals("-")) {
				stack.push(item);
			} else if(!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");
			}
		}
		StdOut.println("(" + stack.size() +" left on stack)");
		
	}

}
