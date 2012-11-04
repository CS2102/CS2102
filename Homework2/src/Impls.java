import java.util.*;

// Some ADT implementations from the Java libraries, for convenience in testing

class QueueImplX implements Queue {
	java.util.LinkedList<Integer> q = new LinkedList<Integer>();
	
	public QueueImplX newQ(){
		q = new LinkedList<Integer>();
		return this;
	}
	
	public QueueImplX enqueue(int elem){
		q.add(new Integer(elem));
		return this;
	}
	
	public QueueImplX dequeue(){
		q.removeFirst();
		return this;
	}
	
	public int front(){
		return q.getFirst();
	}	
}

class StackImplX implements Stack {
	java.util.LinkedList<Integer> s = new LinkedList<Integer>();
	
	public StackImplX newStk(){
		s = new LinkedList<Integer>();
		return this;
	}
	
	public StackImplX push(int elem){
		s.push(elem);
		return this;
	}
	
	public StackImplX pop(){
		s.pop();
		return this;
	}
	
	public int top(){
		return s.peekFirst();
	}
}

class PriorityQueueImplX implements PriorityQueue {
	java.util.PriorityQueue<Integer> p = new java.util.PriorityQueue<Integer>();
	
	public PriorityQueueImplX newPQ(){
		p = new java.util.PriorityQueue<Integer>();
		return this;
	}
	
	public PriorityQueueImplX addElt(int elem){
		p.offer(elem);
		return this;
	}
	
	public PriorityQueueImplX remMinElt(){
		p.poll();
		return this;
	}
	
	public int getMinElt(){
		return p.peek();
	}
}

