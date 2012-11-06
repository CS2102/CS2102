
interface ISet {
	// returns set containing all existing elements and the given element
    ISet addElem(int newElem) ;
 // returns set containing all existing elements except the given element
    ISet remElem(int newElem);
 // returns the number of distinct elements in the set
    int size();
 // determines whether given element is in the set
    boolean hasElem(int elem);
}