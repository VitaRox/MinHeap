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
		System.out.println("The heap is empty: " + testHeap1.isEmpty());
		System.out.println("It contains " + testHeap1.getSize() + " elements");
		System.out.println("The smallest entry is " + testHeap1.getMin() + ".");
		System.out.println("Removing entries in ascending order: ");
		while(!testHeap1.isEmpty()) {
			System.out.println("Removing " + testHeap1.removeMin());
		}
	}
}



