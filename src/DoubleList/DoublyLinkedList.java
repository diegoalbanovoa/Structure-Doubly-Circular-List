package DoubleList;

/**
 * Clase encargada de Manejar el objeto de tipo T
 *
 * @author Diego Fernando Alba Novoa
 * @date 6 Sep 2021
 * @version 1.0
 * @param <T>
 */
public class DoublyLinkedList<T> {
	protected Node<T> head; // the first node of the list
	protected Node<T> tail; // the last node of the list
	protected Node<T> location; // true if element found, else false
	protected int numElements; // Number of elements in this list
	protected boolean found; // true if element found, else false

	/**
	 * default constructor
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
		numElements = 0;
		location = null;
	}

	/**
	 * @return true if list is empty, else false
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * @return Determines the number of elements on this list
	 */
	public int size() {
		return numElements;
	}

	/**
	 * Searches list for an occurrence of an element. If successful, sets instance
	 * variables found to true, location to node containing the element, and
	 * previous to the node that links to location. If not successful, sets found to
	 * false.
	 * 
	 * @param target
	 */
	protected void find(T target) {
		location = head;
		found = false;
		if (!isEmpty()) {
			do {
				if (location.getData().equals(target)) // if they match
				{
					found = true;
					return;
				} else {
					location = location.getNext();
				}
			} while (location != tail.getNext());
		}

	}

	/**
	 * @param element
	 * @return true if this list contains an element e such that
	 */
	public boolean contains(T element) {
		find(element);
		return found;
	}

	/**
	 * finds position in this list Assumes Zero based indexing
	 * 
	 * @param position
	 */
	protected void findPosition(int position) {
		int start = 0;
		location = head;
		found = false;

		if ((!isEmpty()) && (position >= 0) && (position <= size())) {
			do {
				// move search to the next node
				location = location.getNext();
				start++;

			} while ((location != head) && start < position);
			found = true;
		}

	}

	/**
	 * @param data
	 * @return an element e from this list such if no such element exists, returns
	 *         null.
	 */
	public T get(T data) {
		find(data);
		if (found)
			return location.getData();
		else
			return null;
	}

	/**
	 * Initializes current position for an iteration through this list, to the first
	 * element on this list.
	 */
	public void reset() {
		location = head;
	}

	/**
	 * Adds element to this list.
	 * 
	 * @param data
	 */
	public void add(T data) {
		Node<T> newNode = new Node<T>(data); // Reference to the new node being added

		if (isEmpty()) // Adding into an empty list
		{
			head = newNode;
			tail = newNode;
			head.setPrevious(tail);
			tail.setNext(head);
		} else // Adding into a non-empty list
		{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			tail.setNext(head);
		}
		numElements++;
	}

	/**
	 * adds new element to the front of the list
	 * 
	 * @param data
	 */
	public void addFront(T data) {
		Node<T> newNode = new Node<T>(data); // Reference to the new node being added

		if (isEmpty()) // Adding into an empty list
		{
			head = newNode;
			tail = newNode;
			head.setPrevious(tail);
			tail.setNext(head);
		} else // Adding into a non-empty list
		{
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
			head.setPrevious(tail);
			tail.setNext(head);
		}
		numElements++;

	}

	/**
	 * adds new element to the back of the list
	 * 
	 * @param data
	 */
	public void addBack(T data) {
		Node<T> newNode = new Node<T>(data); // Reference to the new node being added

		if (isEmpty()) // Adding into an empty list
		{
			head = newNode;
			tail = newNode;
			head.setPrevious(tail);
			tail.setNext(head);
		} else // Adding into a non-empty list
		{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			tail.setNext(head);
		}
		numElements++;

	}

	/**
	 * adds new element to the specified position
	 * 
	 * @param data
	 * @param position
	 */
	public void addAtPosition(T data, int position) {
		Node<T> newNode = new Node<T>(data);

		if (isEmpty()) {
			// add element to an empty list
			head = newNode;
			tail = newNode;
			head.setPrevious(tail);
			tail.setNext(head);

		} else if (position <= 0) {
			// insert at front of the list
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
			head.setPrevious(tail);
			tail.setNext(head);

		} else if (position >= size()) {
			// if position does not exist, perform add at the most efficient
			// position for circular doubly linked list, the most efficient position is
			// at the end.
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			tail.setNext(head);

		} else {
			/* General Case */
			// determine location where to perform insert
			findPosition(position);

			// inserts the elements to the specified position
			newNode.setPrevious(location.getPrevious());
			newNode.setNext(location);
			location.getPrevious().setNext(newNode);
			location.setPrevious(newNode);

		}
		numElements++;
	}

	/**
	 * Removes an element e from this list such that e.equals(element)
	 * 
	 * @param element
	 * @return true; if no such element exists, returns false
	 */
	public boolean remove(T element) {
		find(element);
		if (found) {
			if (location == head && size() == 1) // removes the only existing element
													// empties the list
			{
				head = null;
				tail = null;

			} else if (location == head) // removes first node
			{
				head = head.getNext();
				head.setPrevious(tail);
				tail.setNext(head);

			} else if (location == tail) // removes last node
			{

				tail = tail.getPrevious();
				tail.setNext(head);
				head.setPrevious(tail);
			} else { // removes node at location
				location.getPrevious().setNext(location.getNext());
				location.getNext().setPrevious(location.getPrevious());
			}
			numElements--;
		}
		return found;
	}

	/**
	 * removes the first element in the list
	 */
	public void removeFront() {

		if (!isEmpty()) {

			if (head.getNext() == head) { // if the first element is the only element in the list, //it empties the list
				head = null;
				tail = null;
			} else { // removes the first element
				head = head.getNext();
				head.setPrevious(tail);
				tail.setNext(head);
			}
		}
		numElements--;
	}

	/**
	 * removes the last element in this list
	 */
	public void removeBack() {

		if (!isEmpty()) {

			if (head.getNext() == head) { // if the last element is the only element in the list,
				// it empties the list
				head = null;
				tail = null;
			} else { // removes the last element
				tail = tail.getPrevious();
				tail.setNext(head);
				head.setPrevious(tail);
			}
		}
		numElements--;
	}

	/**
	 * removes the element in the specified position
	 * 
	 * @param position
	 */
	public void removeAtPosition(int position) {
		if (position <= 0) { // removes front element
			head = head.getNext();
			head.setPrevious(tail);
			tail.setNext(head);
		} else if (position >= size() - 1) { // remove last element

			tail = tail.getPrevious();
			tail.setNext(head);
			head.setPrevious(tail);

		} else {
			// general case
			// determines the position
			findPosition(position);

			// removes the element in the specified position
			location.getPrevious().setNext(location.getNext());
			location.getNext().setPrevious(location.getPrevious());
		}
		numElements--;
	}

	/**
	 * prints the elements of the list in a nicely formated manner in forward order
	 */
	public String toString() {
		String item = "List: [ ";

		Node<T> current = head;

		if (!isEmpty()) {

			do {
				item += current.getData() + " ";
				current = current.getNext();
			} while (current != head);

		}
		item += "]";
		return item;

	}

	/**
	 * prints the elements of the list in a nicely formated manner in reverse order
	 * 
	 * @return item
	 */
	public String printReverse()
	//
	{

		String item = "List: [ ";

		Node<T> current = tail;

		if (!isEmpty()) {
			do {
				item += current.getData() + " ";
				current = current.getPrevious();
			} while (current != tail);
		}
		item += "]";
		return item;

	}

}
