/**
 * @author Vita.Wiebe@seattlecolleges.edu
 * A class to test our MinHeap implementation
 */
public class MinHeapTestClient {
	
	public static void main(String[] args) {
	
		// Test #1:
		MinHeap<String> testHeap1 = new MinHeap<>();
		
		// Add folx to our heap;
		testHeap1.add("Jared");
		testHeap1.add("Brittany");
		testHeap1.add("Brett");
		testHeap1.add("Doug");
		testHeap1.add("Megan");
		testHeap1.add("Jim");
		testHeap1.add("Whitney");
		testHeap1.add("Matt");
		testHeap1.add("Regis");
		
		// Test method implementations of MinHeapInterface;
		if(!testHeap1.isEmpty()) {
			System.out.println("The heap 1 is not empty. It contains " + testHeap1.getSize() + " elements.");
		} else {
			System.out.println("Test 1 isn't working; freak out!");
		}
		System.out.println("It contains " + testHeap1.getSize() + " elements");
		System.out.println("The smallest entry is " + testHeap1.getMin() + ".");
		System.out.println("Removing entries in ascending order: ");
		while(!testHeap1.isEmpty()) {
			System.out.println("Removing " + testHeap1.removeMin());
		}
		System.out.println("Heap 1 is now empty: " + testHeap1.isEmpty());
		System.out.println();
		System.out.println();
		
		// Test #2:
		System.out.println("Testing constructor with the array parameter: ");
		// Our array to test the one-arg constructor;
		String[] nameArray = {"Banana", "Watermelon", "Orange", "Apple", "Kiwi"};
		MinHeap<String> testHeap2 = new MinHeap<>(nameArray);
		
		if(!testHeap2.isEmpty()) {
			System.out.println("The heap 2 is not empty. It contains " + testHeap2.getSize() + " elements.");
		} else {
			System.out.println("Test 2 isn't working: freak out!");
		}
		System.out.println("The smallest entry is " + testHeap2.getMin());
		System.out.println("Removing entries in ascending order: ");
		while(!testHeap2.isEmpty()) {
			System.out.println("Removing " + testHeap2.removeMin());
		}
		System.out.println("Heap 2 is now empty: " + testHeap2.isEmpty());


		
	}
}



