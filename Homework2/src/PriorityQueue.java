
public interface PriorityQueue {
	
	PriorityQueue addElt(int elem); // adds element
	
	PriorityQueue remMinElt(); // remove smallest element
	
	int getMinElt();  // return, but don’t remove, smallest elt
	
	/*
	 * Example: Assume we added elements 7, 4, and 5 to a new priority queue (in that order). 
	 * Calling getMinElt on the resulting priority queue should return 4. Calling remMinElt 
	 * should produce a priority queue containing only 5 and 7.
	 */
	
}
