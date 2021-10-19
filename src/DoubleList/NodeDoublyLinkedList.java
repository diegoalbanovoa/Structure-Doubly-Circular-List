package DoubleList;

/**
 * Clase encargada de manejar el nodo de tipo T
 *
 * @author Diego Fernando Alba Novoa
 * @date 6 Sep 2021
 * @version 1.0
 * @param <T>
 */
public class NodeDoublyLinkedList<T> {
	protected NodeDoublyLinkedList<T> next; // siguiente referencia de nodo
	protected NodeDoublyLinkedList<T> previous; // referencia de nodo anterior
	protected T data; // datos en el nodo

	public NodeDoublyLinkedList(T data) {
		this.data = data;
		next = null;
		previous = null;
	}

	/**
	 * <h1>Metodo getNext</h1><br>
	 * Metodo encargado de retornar el nodo siguiente de la lista
	 * 
	 * @return Nodo siguinte
	 */
	public NodeDoublyLinkedList<T> getNext() {
		return next;
	}

	/**
	 * <h1>Metodo setNext</h1><br>
	 * Metodo encargado de retornar el siguiente nodo de la lista
	 * 
	 * @param next Siguiente
	 */
	public void setNext(NodeDoublyLinkedList<T> next) {
		this.next = next;
	}

	/**
	 * <h1>Metodo getData</h1><br>
	 * Metodo encargado de retornar los datos de este nodo
	 * 
	 * @return los datos en este nodo
	 */
	public T getData() {
		return data;
	}

	/**
	 * <h1>Metodo setData</h1><br>
	 * Metodo encargado de retornar los datos en este nodo
	 * 
	 * @param data Data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * <h1>Metodo getPrevious</h1><br>
	 * Metodo encargado de retornar el nodo anterior en esta lista
	 * 
	 * @return el nodo anterior en esta lista
	 */
	public NodeDoublyLinkedList<T> getPrevious() {
		return previous;
	}

	/**
	 * <h1>Metodo setPrevious</h1><br>
	 * Metodo encargado de retornar el nodo anterior en esta lista
	 * 
	 * @param previous
	 */
	public void setPrevious(NodeDoublyLinkedList<T> previous) {
		this.previous = previous;
	}

}
