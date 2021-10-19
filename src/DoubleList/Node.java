package DoubleList;

/**
 * Clase encargada de manejar el nodo de tipo T
 *
 * @author Diego Fernando Alba Novoa
 * @date 6 Sep 2021
 * @version 1.0
 * @param <T>
 */
public class Node<T> {
	protected Node<T> next; // next node reference
	protected Node<T> previous; // previous node reference
	protected T data; // data in the node

	public Node(T data) {
		this.data = data;
		next = null;
		previous = null;
	}

	/**
	 * @return the next node in this list
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * sets the next node in the list
	 * 
	 * @param next
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @return the data in this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * sets the data in this node
	 * 
	 * @param data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the previous node in this list
	 */
	public Node<T> getPrevious() {
		return previous;
	}

	/**
	 * sets the previous node in this list
	 * 
	 * @param previous
	 */
	public void setPrevious(Node<T> previous)	{
		this.previous = previous;
	}

}
