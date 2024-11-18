/**
 * A sortable DoublyLinkedList.  The fields and the DLLNode class in the
 * COMP232DoublyLinkedList class are protected fields and can be accessed
 * directly in this class.
 * 
 * @author William Goble
 * @author Dickinson College
 * 
 */
public class COMP232SortableLinkedList<E extends Comparable<E>> extends COMP232DoublyLinkedList<E> {

	/**
	 * Implementation of insertion sort for the LinkedList. The elements of the
	 * list will be sorted according to the order imposed by their compareTo
	 * method.
	 */
	//This is an optimized version of insertion sort, since we only have to "insert" the element once instead of swapping it multiple times.
	//It is possible to go back to the "normal" version, simply by changing the inner body of the while loop.
	public void insertionSortList() {
		// Intentionally not implemented - see homework assignment.

		//cursor1 used to iterate forward. If the list have less than 2 element, it does not need to be sorted, hence cursor1 should be tail making the method do nothing.
		DLLNode<E> cursor1 = super.tail;
		if (super.size > 1) {
			cursor1 = super.head.next.next;
		}

		//cursor2 used to iterate backward
		DLLNode<E> cursor2;

		//current is the node we are currently trying to put in the sorted part of the array
		DLLNode<E> current;

		while(cursor1 != super.tail){
			current= cursor1;
			cursor2=current.prev;
			cursor1 = cursor1.next;

			while(cursor2 != super.head && cursor2.element.compareTo(current.element) > 0 ){
				boolean rightInsertSpot = (cursor2.prev == super.head  || cursor2.prev.element.compareTo(current.element) <= 0);

				//insert the node in between cursor2 and cursor2.prev. Before that Node.prev will be connected to Node.next
				if(rightInsertSpot){
					current.prev.next = current.next;
					current.next.prev = current.prev;

					current.next = cursor2;
					current.prev = cursor2.prev;
					cursor2.prev.next=current;
					cursor2.prev=current;

				}

				cursor2=cursor2.prev;


				//below are the code that would be used for the body of the while loop if we want "normal" insertion sort
//					E dummyVal = cursor2.element;
//					cursor2.element=current.element;
//					current.element=dummyVal;
//
//					current=current.prev;
//					cursor2=cursor2.prev;
			}
		}
	}
}
