
public interface Stack {
	
	Stack newStk();  // produces a Stack with no elements
	
	Stack push(int elem);  // adds element
	
	Stack pop();  // remove most recently-added element
	
	int top();  // return, but don't remove, most-recently added element
	
	/*
	 * Example: Assume that we added elements 7, 4, and 5 to a new stack (in that order). 
	 * Calling pop would produce a stack containing 4 and 7. Calling top on that stack would 
	 * produce 4. Calling pop on that stack again would produce a stack containing 7.
	 */
	
}
