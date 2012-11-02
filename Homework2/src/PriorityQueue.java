
public interface PriorityQueue {
	
	PriorityQueue newPQ(); // produces a priority queue with no elements
	
	PriorityQueue addElt(PriorityQueue q, int elem); // adds element
	
	PriorityQueue remMinElt(PriorityQueue q); // remove smallest element
	
	int getMinElt(PriorityQueue q);  // return, but don’t remove, smallest elt
	
}
