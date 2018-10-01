package algorithms.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinkedQueue<Item> implements Iterable<Item> {

	private class Node{
		private Item item;
		private Node next;
	}
	
	private Node first;// begining of queue
	private Node last;// end of queue
	private int n;// number of elements on queue
	
	public LinkedQueue() {
		first = null;
		last = null;
		n = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return n;
	}
	
	public void enque(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else 		  oldlast.next = last;
		n++;
	}
	
	public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		n--;
		if(isEmpty()) last = null;
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
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{
		private Node current;
		
		public QueueIterator() {
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
		LinkedQueue<String> queue = new LinkedQueue<String>();
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if(!s.equals("-")) {
				queue.enque(s);
			} else if(!queue.isEmpty()) {
				StdOut.print(queue.dequeue() + " ");
			}
		}
		StdOut.println("(" + queue.size() + " left on the queue)");
	}

}
