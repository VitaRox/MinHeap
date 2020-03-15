import java.util.Arrays;

/**
 * A simple class to implement the methods of the MinHeap interface;
 * For every node in Heap:
 *    root is at heap[1],
 *    parentNode is at heap[i],
 *    leftChild will be at heap[2i],
 *    rightChild will be at heap[2i + 1];
 * Assignment 7, Data Structures & Algorithms, Thursday class, Winter 2020;
 * @param <T>
 * @author Vita.Wiebe@seattlecolleges.edu
 */
public final class MinHeap<T extends Comparable<? super T>> implements MinHeapInterface<T> {
	
	// Fields;
	private T[] heap;
	private int lastIndex;
	private boolean integrityOK = false;
	
	// Constants;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	/**
	 * Default constructor;
	 */
	public MinHeap() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * One-arg constructor;
	 * Construct an empty MinHeap of specific initial size;
	 * @param initialCapacity A desired initial number of entries tree can hold;
	 */
	public MinHeap(int initialCapacity) {
		// Check that user not passing in an illegally-small or -large capacity;
		checkCapacity(initialCapacity);
		// The cast is safe because the new array contains null entries;
		@SuppressWarnings("unchecked")
		T[] tempHeap =(T[]) new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
		integrityOK = true;
	}
	
	/**
	 * A constructor using an input array;
	 * @param entries The array of values to be input into our heap;
	 */
	public MinHeap(T[] entries) {
		this(entries.length);
		lastIndex = entries.length;
		// Copy input array into our heap implementation;
		for (int i = 0; i < entries.length; i++) {
			heap[i + 1] = entries[i];
		}
		// Build heap;
		for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--) {
			reheap(rootIndex);
		}
	}
	
	/**
	 * Pre: a non-empty heap;
	 * @return the lowest data value in the heap, the root in a MinHeap;
	 */
	public T getMin() {
		checkIntegrity();
		T root = null;
		if (!isEmpty()) {
			root = heap[1];
		}
		return root;
	}
	
	/**
	 * @return True if heap is empty (contains no elements);
	 */
	public boolean isEmpty() {
		return lastIndex < 1;
	}
	
	/**
	 *
	 * @return The number of elements in our MinHeap
	 */
	public int getSize() {
		return lastIndex;
	}
	
	/**
	 * Add a new element to the appropriate place in our MinHeap;
	 * Pre: non-corrupt MinHeap;
	 * @param newEntry The new element to be added;
	 */
	public void add(T newEntry) {
		// Ensure data fields of constructor initialized properly;
		checkIntegrity();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while ((parentIndex > 0) && (newEntry.compareTo(heap[parentIndex]) < 0)) {
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
		}
		heap[newIndex] = (T) newEntry;
		lastIndex++;
		ensureCapacity();
	}
	
	/**
	 * Pre: non-empty MinHeap;
	 * Remove the root, the lowest value in a MinHeap;
	 * @return The removed, formerly-lowest value of our MinHeap;
	 */
	public T removeMin() {
		checkIntegrity();
		T root = null;
		if(!isEmpty()) {
			root = heap[1];
			heap[1] = heap[lastIndex];
			// Decrement the number of elements in heap;
			lastIndex--;
			// "heap" property is now broken at root; call reheap(newValue) to repeat process;
			reheap(1);
		}
		return root;
	}
	
	/**
	 * Pre: heap is not corrupt;
	 * Post: heap is now empty;
	 */
	public void clear() {
		checkIntegrity();
		while (lastIndex > -1) {
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;
	}
	
	/**
	 * Resize our heap's underlying array if an add/remove op puts it in an illegal state;
	 */
	private void ensureCapacity() {
		int numberOfEntries = lastIndex;
		int capacity = heap.length - 1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity);
			heap = Arrays.copyOf(heap, newCapacity + 1);
		}
	}
	
	// Throw exception if object is corrupt;
	private void checkIntegrity() {
		if (!integrityOK) {
			throw new SecurityException("MinHeap object is corrupt.");
		}
	}
	
	/**
	 *
	 * @param capacity The capacity of the underlying array structure after an op such as add/remove performed;
	 */
	private void checkCapacity(int capacity){
		if (capacity < DEFAULT_CAPACITY) {
			capacity = DEFAULT_CAPACITY;
		} else if (capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a heap whose capacity larger than " + MAX_CAPACITY);
		}
	}
	
	/**
	 * Pre: heap is in a "semi-heap" state, root removed;
	 * Post: heap is returned to heap state; new root established;
	 * @param rootIndex The root of the current semi-heap;
	 */
	private void reheap(int rootIndex) {
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;
		
		while(!done && (leftChildIndex <= lastIndex)) {
			// Assume left child has smaller value;
			int smallerChildIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			
			if ((rightChildIndex <= lastIndex) && (heap[rightChildIndex].compareTo(heap[smallerChildIndex]) < 0)) {
				smallerChildIndex = rightChildIndex;
			}
			if(orphan.compareTo(heap[smallerChildIndex]) < 0) {
				heap[rootIndex] = heap[smallerChildIndex];
				rootIndex = smallerChildIndex;
				leftChildIndex = 2 * rootIndex;
			} else {
				done = true;
			}
		}
		heap[rootIndex] = orphan;
	}
	
}