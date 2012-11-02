
public interface PriorityQueue {
	
	PriorityQueue newPQ(); // produces a priority queue with no elements
	
	PriorityQueue addElt(int elem); // adds element
	
	PriorityQueue remMinElt(); // remove smallest element
	
	int getMinElt();  // return, but don’t remove, smallest elt
	
}
