import java.util.*;

// Some ADT implementations from the Java libraries, for convenience in testing

class Queue implements IQueue {
	java.util.LinkedList<Integer> q = new LinkedList<Integer>();
	
	public Queue(){
		q = new LinkedList<Integer>();
	}
	
	public Queue enqueue(int elem){
		q.add(new Integer(elem));
		return this;
	}
	
	public Queue dequeue(){
		q.removeFirst();
		return this;
	}
	
	public int front(){
		return q.getFirst();
	}	
}

class Stack implements IStack {
	java.util.LinkedList<Integer> s = new LinkedList<Integer>();
	
	public Stack(){
		s = new LinkedList<Integer>();
	}
	
	public Stack push(int elem){
		s.push(elem);
		return this;
	}
	
	public Stack pop(){
		s.pop();
		return this;
	}
	
	public int top(){
		return s.peekFirst();
	}
}

class PriorityQueue implements IPriorityQueue {
	java.util.PriorityQueue<Integer> p = new java.util.PriorityQueue<Integer>();
	
	public PriorityQueue(){
		p = new java.util.PriorityQueue<Integer>();
	}
	
	public PriorityQueue addElt(int elem){
		p.offer(elem);
		return this;
	}
	
	public PriorityQueue remMinElt(){
		p.poll();
		return this;
	}
	
	public int getMinElt(){
		return p.peek();
	}
}

