public class SinglyLinkedList implements SimpleList {
	private class Node {
		Integer value = null;
		Node next = null;

		public Node ( Integer value ) {
			this.value = value;
		}

		public Integer getValue ( ) {
			return value;
		}

		public void setValue ( Integer value ) {
			this.value = value;
		}

		public Node getNext ( ) {
			return next;
		}

		public void setNext ( Node next ) {
			this.next = next;
		}
	}

	// The beginning of the list
	private Node head = null;
	// The number of elements in the list
	private int size = 0;

	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * Prohibits the insertion of a null value into the list.
	 *
	 * @param index - index at which the specified element is to be inserted
	 * @param value - value to be inserted
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	 * @throws IllegalArgumentException  - if the value specified is null
	 */
	@Override
	public void add ( int index, Integer value )
			  throws IndexOutOfBoundsException, IllegalArgumentException {
		// validate value argument
		if ( value == null ) {
			throw new IllegalArgumentException( "Illegal Argument: value cannot be null." );
		}
		// validate index argument
		if ( index < 0 || index > size ) {
			throw new IndexOutOfBoundsException( "Index Out Of Bounds: " + index );
		}
		Node newNode = new Node( value );
		if ( index == 0 ) {
			// add to front
			newNode.setNext( head );
			head = newNode;
		} else {
			// add after node at index - 1
			Node currentNode = head;
			for( int i = 1; i < index; i++ ) {
				currentNode = currentNode.getNext( );
			}
			newNode.setNext( currentNode.getNext( ) );
			currentNode.setNext( newNode );
		}
		size++;
	}

	/**
	 * Returns the value at the specified position in this list.
	 *
	 * @param index - index of the element to return
	 * @return the value at the specified position in this list or null if empty
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	@Override
	public Integer get ( int index ) throws IndexOutOfBoundsException {
		// validate index argument
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException( "Index Out Of Bounds: " + index );
		}
		// Check if list is empty
		if ( isEmpty( ) ) {
			return null;
		}
		Node currentNode = find( index );
		return currentNode.getValue( );
	}

	private Node find( int index ) throws IndexOutOfBoundsException {
		// validate index argument
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException( "Index Out Of Bounds: " + index );
		}
		Node currentNode = head;
		for( int i = 0; i < index; i++ ) {
			currentNode = currentNode.getNext( );
		}
		return currentNode;
	}

	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their
	 * indices). Returns the value that was removed from the list.
	 *
	 * @param index - the index of the element to be removed
	 * @return the value previously at the specified position
	 * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= size())
	 */
	@Override
	public Integer remove ( int index ) throws IndexOutOfBoundsException {
		// validate index argument
		if ( index < 0 || index >= size ) {
			throw new IndexOutOfBoundsException( "Index Out Of Bounds: " + index );
		}
		Node target = null;
		if ( index == 0 ) {
			// remove the first node
			target = head;
			head = head.getNext ();
		} else {
			// remove any node after the first node
			Node currentNode = head;
			for( int i = 1; i < index; i++ ) {
				currentNode = currentNode.getNext( );
			}
			target = currentNode.getNext ();
			currentNode.setNext ( currentNode.getNext ().getNext () );
		}
		size--;
		return target.getValue ();
	}

	/**
	 * Returns true if this collection contains no elements.
	 *
	 * @return true if this collection contains no elements
	 */
	@Override
	public boolean isEmpty ( ) {
		return size( ) == 0;
	}

	/**
	 * Returns the number of elements in this collection. If this collection
	 * contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 *
	 * @return the number of elements in this collection
	 */
	@Override
	public int size ( ) {
		return size;
	}
}
