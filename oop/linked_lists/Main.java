package oop.linked_lists;

// Import the LinkedList class
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList<String> cars = new LinkedList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }
}

// addFirst()	Adds an item to the beginning of the list.	
// addLast()	Add an item to the end of the list	
// removeFirst()	Remove an item from the beginning of the list.	
// removeLast()	Remove an item from the end of the list	
// getFirst()	Get the item at the beginning of the list	
// getLast()	Get the item at the end of the list
