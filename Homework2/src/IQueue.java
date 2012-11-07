
public interface IQueue {
	
	IQueue enqueue(int elem);  // adds element
	
	IQueue dequeue();  // remove least recently-added element
	
	int front();  // return, but don't remove, least-recently added element
	
	
	/*
	 * Example: Assume that we added elements 7, 4, and 5 to a new queue (in that order). 
	 * Calling dequeue would produce a queue containing 4 and 5. Calling front on that stack 
	 * would produce 4. Calling dequeue on that stack again would produce a stack containing 5.
	 */
	
}
