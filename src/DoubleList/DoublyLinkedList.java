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
	protected Node<T> head; // el primer nodo de la lista
	protected Node<T> tail; // el �ltimo nodo de la lista
	protected Node<T> location; // verdadero si se encuentra el elemento, de lo contrario falso
	protected int numElements; // N�mero de elementos en esta lista
	protected boolean found; // verdadero si se encuentra el elemento, de lo contrario falso

	/**
	 * Constructor predeterminado
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
		numElements = 0;
		location = null;
	}

	/**
	 * <h1>Metodo isEmpty</h1><br>
	 * Metodo encargado de si la lista esta vacia
	 * 
	 * @return Es <code>True</code> si la lista est� vac�a, de lo contrario es
	 *         <code>False</code>
	 */
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * <h1>Metodo size</h1><br>
	 * Metodo encargado de determina el n�mero de elementos de esta lista.
	 * 
	 * @return numero de elementos de la lista.
	 */
	public int size() {
		return numElements;
	}

	/**
	 * <h1>Metodo find</h1><br>
	 * Busca en la lista una aparici�n de un elemento. Si tiene �xito, establece la
	 * instancia variables encontradas como verdaderas, ubicaci�n al nodo que
	 * contiene el elemento, y anterior al nodo que enlaza con la ubicaci�n. Si no
	 * tiene �xito, los conjuntos encontrados falso.
	 * 
	 * @param target El elemento que se busca
	 */
	protected void find(T target) {
		location = head;
		found = false;
		if (!isEmpty()) {
			do {
				if (location.getData().equals(target)) // si coinciden
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
	 * <h1>Metodo contains</h1><br>
	 * 
	 * M�todo encargado de buscar si un elemento est� en la lista
	 * 
	 * @param element El elemneto buscado
	 * @return verdadero si esta lista contiene un elemento e tal que
	 */
	public boolean contains(T element) {
		find(element);
		return found;
	}

	/**
	 * <h1>Metodo findPosition</h1><br>
	 * buscar posici�n en esta lista Asume indexaci�n basada en cero
	 * 
	 * @param position Posicion del elemento
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
	 * <h1>Metodo searchElement</h1><br>
	 * 
	 * M�todo encargado de buscar un elemento en la lista valida si el elemento
	 * esta, y en llegado caso de estar se retorna la data de este elemento y en el
	 * caso de no estar se retorna null
	 * 
	 * @param data elemento
	 * @return un elemento e de esta lista, tal si no existe tal elemento, devuelve
	 *         nulo.
	 */
	public T searchElement(T data) {
		find(data);
		if (found)
			return location.getData();
		else
			return null;
	}

	/**
	 * <h1>Metodo reset</h1><br>
	 * M�todo encargado de inicializa la posici�n actual para una iteraci�n a trav�s
	 * de esta lista, a la primera elemento en esta lista.
	 */
	public void reset() {
		location = head;
	}

	/**
	 * <h1>Metodo addElement</h1><br>
	 * M�todo encargado de agrega un elemento a esta lista.
	 * 
	 * @param data Data
	 */
	public void addElement(T data) {
		Node<T> newNode = new Node<T>(data);// Referencia al nuevo nodo que se agrega

		if (isEmpty()) // A�adiendo a una lista vac�a
		{
			head = newNode;
			tail = newNode;
			head.setPrevious(tail);
			tail.setNext(head);
		} else // Agregar a una lista no vac�a
		{
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			tail.setNext(head);
		}
		numElements++;
	}

	/**
	 * <h1>Metodo addFront</h1><br>
	 * M�todo encargado de agrega un nuevo elemento al principio de la lista
	 * 
	 * @param data Data
	 */
	public void addFront(T data) {
		Node<T> newNode = new Node<T>(data);// Referencia al nuevo nodo que se agrega

		if (isEmpty()) // A�adiendo a una lista vac�a
		{
			head = newNode;
			tail = newNode;
			head.setPrevious(tail);
			tail.setNext(head);
		} else // Agregar a una lista no vac�a
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
	 * <h1>Metodo addBack</h1><br>
	 * M�todo encargado de agrega un nuevo elemento al final de la lista
	 * 
	 * @param data Data
	 */
	public void addBack(T data) {
		Node<T> newNode = new Node<T>(data); // Referencia al nuevo nodo que se agrega

		if (isEmpty()) // A�adiendo a una lista vac�a
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
	 * <h1>Metodo addAtPosition</h1><br>
	 * M�todo encargado de agrega un nuevo elemento a la posici�n especificada
	 * 
	 * @param data     Data
	 * @param position Posicion
	 */
	public void addAtPosition(T data, int position) {
		Node<T> newNode = new Node<T>(data);

		if (isEmpty()) {
			// agregar elemento a una lista vac�a
			head = newNode;
			tail = newNode;
			head.setPrevious(tail);
			tail.setNext(head);

		} else if (position <= 0) {
			// insertar al principio de la lista
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
			head.setPrevious(tail);
			tail.setNext(head);

		} else if (position >= size()) {
			// si la posici�n no existe, realice la adici�n de la forma m�s eficiente
			// posici�n para lista circular doblemente enlazada, la posici�n m�s eficiente
			// es al final.
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode;
			tail.setNext(head);

		} else {
			/* Caso general */
			// determina la ubicaci�n donde realizar la inserci�n
			findPosition(position);

			// inserta los elementos en la posici�n especificada
			newNode.setPrevious(location.getPrevious());
			newNode.setNext(location);
			location.getPrevious().setNext(newNode);
			location.setPrevious(newNode);

		}
		numElements++;
	}

	/**
	 * <h1>Metodo remove</h1><br>
	 * M�todo encargado de elimina un elemento e de esta lista tal que e.equals
	 * (elemento)
	 * 
	 * @param element Elemento
	 * @return <code>True</code>; si no existe tal elemento , devuelve
	 *         <code>False</code>
	 */
	public boolean remove(T element) {
		find(element);
		if (found) {
			if (location == head && size() == 1) // elimina el �nico elemento existente vac�a la lista
			{
				head = null;
				tail = null;

			} else if (location == head) // elimina el primer nodo
			{
				head = head.getNext();
				head.setPrevious(tail);
				tail.setNext(head);

			} else if (location == tail) // elimina el �ltimo nodo
			{

				tail = tail.getPrevious();
				tail.setNext(head);
				head.setPrevious(tail);
			} else { // elimina el nodo en la ubicaci�n
				location.getPrevious().setNext(location.getNext());
				location.getNext().setPrevious(location.getPrevious());
			}
			numElements--;
		}
		return found;
	}

	/**
	 * <h1>Metodo removeFront</h1><br>
	 * M�todo encargado de elimina el primer elemento de la lista
	 */
	public void removeFront() {

		if (!isEmpty()) {

			if (head.getNext() == head) { // si el primer elemento es el �nico elemento de la lista,se vac�a la lista
				head = null;
				tail = null;
			} else { // elimina el primer elemento
				head = head.getNext();
				head.setPrevious(tail);
				tail.setNext(head);
			}
		}
		numElements--;
	}

	/**
	 * <h1>Metodo removeBack</h1><br>
	 * M�todo encargado de elimina el �ltimo elemento de esta lista
	 */
	public void removeBack() {

		if (!isEmpty()) {

			if (head.getNext() == head) { // si el �ltimo elemento es el �nico elemento de la lista,se vac�a la lista
				head = null;
				tail = null;
			} else { // elimina el �ltimo elemento
				tail = tail.getPrevious();
				tail.setNext(head);
				head.setPrevious(tail);
			}
		}
		numElements--;
	}

	/**
	 * <h1>Metodo removeAtPosition</h1><br>
	 * M�todo encargado de elimina el elemento en la posici�n especificada
	 * 
	 * @param position Posicion
	 */
	public void removeAtPosition(int position) {
		if (position <= 0) { // elimina el elemento frontal
			head = head.getNext();
			head.setPrevious(tail);
			tail.setNext(head);
		} else if (position >= size() - 1) { // remove last element

			tail = tail.getPrevious();
			tail.setNext(head);
			head.setPrevious(tail);

		} else {
			// caso general determina la posici�n
			findPosition(position);

			// elimina el elemento en la posici�n especificada
			location.getPrevious().setNext(location.getNext());
			location.getNext().setPrevious(location.getPrevious());
		}
		numElements--;
	}

	/**
	 * <h1>Metodo ShowList</h1><br>
	 * M�todo encargado de imprime los elementos de la lista con un formato
	 * agradable en orden de avance
	 */
	public String ShowList() {
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
	 * <h1>Metodo showPrintReverse</h1><br>
	 * M�todo encargado de imprime los elementos de la lista en un formato agradable
	 * en orden inverso
	 * 
	 * @return item
	 */
	public String showPrintReverse() {

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
