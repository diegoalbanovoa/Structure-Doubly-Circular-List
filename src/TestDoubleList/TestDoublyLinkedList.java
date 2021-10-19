package TestDoubleList;

import DoubleList.DoublyLinkedList;

/**
 * Clase encargada de Probar los metodos de las clases DoublyLinkedList y Node
 *
 * @author Diego Fernando Alba Novoa
 * @date 6 Sep 2021
 * @version 1.0
 */
public class TestDoublyLinkedList {
	public static void main(String[] args) {
		System.out.println(
				"----------------------------------------> Casos de prueba <-----------------------------------------\n");

		DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<Integer>();

		doublyLinkedList.addElement(1); // adds items to the list
		doublyLinkedList.addElement(2);
		doublyLinkedList.addElement(3);
		doublyLinkedList.addElement(4);
		System.out.println(
				"----------------------------------------> Lista Original <------------------------------------------\n");
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"-----------------------> Agregar el elemento 9 al frente de la lista <------------------------------");
		doublyLinkedList.addFront(9);
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"---------------------> Agregar el elemento 8 al final de la lista <---------------------------------");
		doublyLinkedList.addBack(8);
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");

		System.out.println(
				"-------------------> Agregar el elemento en la posicion 2 elemento 6 <------------------------------");
		doublyLinkedList.addAtPosition(6, 2);
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"----------------------------> Remover el elemento 4 de la lista <-----------------------------------");
		doublyLinkedList.remove(4);
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"-------------------------> Remover el primer elemento de la lista <---------------------------------");
		doublyLinkedList.removeFront();
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"------------------------> Remover el ultimo elemento de la lista <----------------------------------");
		doublyLinkedList.removeBack();
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
		System.out.println(
				"------------------------> Remover el elemento en la posicion 1 de la lista <------------------------");
		doublyLinkedList.removeAtPosition(1);
		System.out.println(doublyLinkedList.ShowList());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
		System.out.println("-------------------------------> Mostrar lista en orden inverso <-----------------------------------");

		System.out.println(doublyLinkedList.showPrintReverse());
		System.out.println(
				"----------------------------------------------------------------------------------------------------\n");
	}

}
