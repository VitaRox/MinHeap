/**
 * A interface outlining the basic methods of a MinHeap implementation;
 * Assignment 7, Data Structures & Algorithms, Thursday;
 * @author Vita.Wiebe@seattlecolleges.edu
 * @param <T>
 */
public interface MinHeapInterface<T extends Comparable<? super T>> {
	public void add(T anEntry);
	public T removeMin();
	public T getMin();
	public boolean isEmpty();
	public int getSize();
	public void clear();
}
