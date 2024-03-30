/**
 * Basic operations performed by a linked list.
 */
public interface SimpleList {
	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * Prohibits the insertion of a null value into the list.
	 * @param index - index at which the specified element is to be inserted
	 * @param value - value to be inserted
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	 * @throws IllegalArgumentException - if the value specified is null
	 */
	public void add( int index, Integer value ) throws IndexOutOfBoundsException, IllegalArgumentException;

	/**
	 * Returns the value at the specified position in this list.
	 * @param index - index of the element to return
	 * @return the value at the specified position in this list or null if empty
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public Integer get( int index ) throws IndexOutOfBoundsException;

	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices). Returns the value that was removed from the list.
	 * @param index - the index of the element to be removed
	 * @return the value previously at the specified position
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	public Integer remove( int index ) throws IndexOutOfBoundsException;

	/**
	 * Returns true if this collection contains no elements.
	 * @return true if this collection contains no elements
	 */
	public boolean isEmpty( );

	/**
	 * Returns the number of elements in this collection. If this collection
	 * contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * @return the number of elements in this collection
	 */
	public int size( );
}
