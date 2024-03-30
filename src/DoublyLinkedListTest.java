import static org.junit.Assert.fail;

public class DoublyLinkedListTest {

	@org.junit.Test
	public void addTest1 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		try {
			doublyLinkedList.add( 0, null );
			fail( String.format( "add(0, null) did not throw IllegalArgumentException." ) );
		} catch ( IllegalArgumentException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void addTest2 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		try {
			doublyLinkedList.add( -1, 1 );
			fail( String.format( "add(-1, 1) did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void addTest3 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( doublyLinkedList.size (), i );
		}
		try {
			doublyLinkedList.add( doublyLinkedList.size ()+1, 1 );
			fail( String.format( "add(size( ) + 1, 1) did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void addTest4 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 1 );
		Integer result = doublyLinkedList.get ( 0 );
		int expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then get(0) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest5 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 1 );
		doublyLinkedList.add ( 0, 0 );
		Integer result = doublyLinkedList.get ( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then get(0) returned %d expected %d.", result, expected ) );
		}
		result = doublyLinkedList.get ( 1 );
		expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then add(0, 0) and get(1) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest6 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 0 );
		doublyLinkedList.add ( 1, 1 );
		Integer result = doublyLinkedList.get ( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 1) and get(0) returned %d expected %d.", result, expected ) );
		}
		result = doublyLinkedList.get ( 1 );
		expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 1) and get(1) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest7 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 0 );
		doublyLinkedList.add ( 1, 2 );
		doublyLinkedList.add ( 1, 1 );
		Integer result = doublyLinkedList.get ( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 2) then add(1, 1) and get(0) returned %d expected %d.", result, expected ) );
		}
		result = doublyLinkedList.get ( 1 );
		expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 2) then add(1, 1) and get(1) returned %d expected %d.", result, expected ) );
		}
		result = doublyLinkedList.get ( 2 );
		expected = 2;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 2) then add(1, 1) and get(2) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest8 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 0 );
		doublyLinkedList.add ( 1, 2 );
		doublyLinkedList.add ( 1, 1 );
		int result = doublyLinkedList.size ();
		int expected = 3;
		if ( result != expected ) {
			fail ( String.format ( "Added 3 elements size=%d expected %d", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest9 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 1 );
		doublyLinkedList.add ( 0, 0 );
		DoublyLinkedList.Node currentNode = doublyLinkedList.getNode ( 1 );
		Integer result = currentNode.getValue ();
		int expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then add(0, 0) and getNode(1) returned %d expected %d.", result, expected ) );
		}
		currentNode = currentNode.getPrevious ();
		result = currentNode.getValue ();
		expected = 0;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then add(0, 0) and getNode(0) returned %d expected %d.", result, expected ) );
		}
		currentNode = currentNode.getPrevious ();
		if ( currentNode != null ) {
			fail( String.format( "getNode(0).getPrevious returned %s expected %s.", currentNode, null ) );
		}
	}

	@org.junit.Test
	public void getTest1 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		try {
			doublyLinkedList.get( 0 );
			fail( String.format( "Get on empty list did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest2 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0,1 );
		try {
			doublyLinkedList.get( -1 );
			fail( String.format( "Get where index < 0 did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest3 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0,1 );
		try {
			doublyLinkedList.get( 1 );
			fail( String.format( "Get where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest4 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		try {
			doublyLinkedList.get( doublyLinkedList.size () );
			fail( String.format( "Get where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest5 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for( int i = 0; i < n; i++ ) {
			Integer result = doublyLinkedList.get( i );
			if ( (int) result != i ) {
				fail ( String.format (
						  "get(%d) returned %d expected %d.", i, result, i ) );
			}
		}
	}

	@org.junit.Test
	public void getTest6 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for( int i = n - 1; i >= 0; i-- ) {
			Integer result = doublyLinkedList.get( i );
			if ( (int) result != i ) {
				fail ( String.format (
						  "get(%d) returned %d expected %d.", i, result, i ) );
			}
		}
	}

	@org.junit.Test
	public void getTest7 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for( int i = n - 1; i > 0; i-- ) {
			doublyLinkedList.remove ( 0 );
		}
		Integer result = doublyLinkedList.get( 0 );
		int expected = (n - 1);
		if ( (int) result != expected ) {
			fail ( String.format (
					  "get(%d) returned %d expected %d.", 0, result, expected ) );
		}
	}

	@org.junit.Test
	public void getTest8 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for( int i = n - 1; i > 0; i-- ) {
			doublyLinkedList.remove ( i );
		}
		Integer result = doublyLinkedList.get( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail ( String.format (
					  "get(%d) returned %d expected %d.", 0, result, expected ) );
		}
	}

	@org.junit.Test
	public void removeTest1 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		try {
			doublyLinkedList.remove ( 0 );
			fail( String.format( "Remove on empty list did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest2 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0,1 );
		try {
			doublyLinkedList.remove ( 1 );
			fail( String.format( "Remove where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest3 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		try {
			doublyLinkedList.remove ( doublyLinkedList.size () );
			fail( String.format( "Remove where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest4 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for ( int i = n - 1; i >= 0; i-- ) {
			Integer result = doublyLinkedList.remove ( i );
			if ( result == null ) {
				fail( String.format( "remove(%d) returned null expecting %d", i, i ) );
			}
			if ( (int) result != i ) {
				fail( String.format( "remove(%d) returned %d expecting %d", i, result, i ) );
			}
		}
	}

	@org.junit.Test
	public void removeTest5 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for ( int i = 0; i < n; i++ ) {
			Integer result = doublyLinkedList.remove ( 0 );
			if ( result == null ) {
				fail( String.format( "remove(%d) returned null expecting %d", i, i ) );
			}
			if ( (int) result != i ) {
				fail( String.format( "remove(%d) returned %d expecting %d", i, result, i ) );
			}
		}
	}

	@org.junit.Test
	public void removeTest6 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for ( int i = 50; i < n; i++ ) {
			Integer result = doublyLinkedList.remove ( 50 );
			if ( result == null ) {
				fail( String.format( "remove(%d) returned null expecting %d", i, i ) );
			}
			if ( (int) result != i ) {
				fail( String.format( "remove(%d) returned %d expecting %d", i, result, i ) );
			}
		}
	}

	@org.junit.Test
	public void removeTest7 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 0 );
		doublyLinkedList.add ( 1, 1 );
		doublyLinkedList.add ( 2, 2 );
		Integer result = doublyLinkedList.remove ( 1 );
		if ( result == null ) {
			fail( String.format( "remove(%d) returned null expecting %d", 1, 1 ) );
		}
		if ( (int) result != 1 ) {
			fail( String.format( "remove(%d) returned %d expecting %d", 1, result, 1 ) );
		}
		if ( (int) doublyLinkedList.get ( 0 ) != 0 || (int) doublyLinkedList.get ( 1 ) != 2 ) {
			fail( String.format( "After remove, newly adjacent nodes had wrong values." ) );
		}
	}

	@org.junit.Test
	public void removeTest8 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0,1 );
		try {
			doublyLinkedList.remove ( -1 );
			fail( String.format( "Remove where index< 0 did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest9 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		doublyLinkedList.add ( 0, 0 );
		doublyLinkedList.add ( 1, 2 );
		doublyLinkedList.add ( 1, 1 );
		for( int i = 0; i < 100; i++ ) {
			try {
				doublyLinkedList.remove ( 0 );
			} catch ( IndexOutOfBoundsException e ) {

			}
		}
		doublyLinkedList.add ( 0, 3 );
		int result = doublyLinkedList.size ();
		int expected = 1;
		if ( result != expected ) {
			fail ( String.format ( "Added 3 elements, removed 100, added 1 size=%d expected %d", result, expected ) );
		}
	}

	@org.junit.Test( timeout = 5000)
	public void removeTest10 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList( );
		for( int i = 0; i < 100; i++) {
			doublyLinkedList.add ( 0, i );
		}
		DoublyLinkedList.Node currentNode = doublyLinkedList.getNode ( doublyLinkedList.size () - 1 );
		for( int i = 0; i < 5; i++ ) {
			try {
				doublyLinkedList.remove ( 50 );
			} catch ( IndexOutOfBoundsException e ) {

			}
		}
		DoublyLinkedList.Node head = doublyLinkedList.getNode( 0 );
		while ( currentNode != head ) {
			currentNode = currentNode.getPrevious ();
		}
		int result = currentNode.getValue ();
		int expected = 99;
		if ( result != expected ) {
			fail ( String.format ( "Walked from tail to head head=%d expected %d", result, expected ) );
		}
	}

	@org.junit.Test
	public void isEmptyTest1 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList ( );
		if ( !doublyLinkedList.isEmpty () ) {
			fail( String.format ( "Error new singly linked list not empty." ));
		}
	}

	@org.junit.Test
	public void isEmptyTest2 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList ( );
		doublyLinkedList.add ( 0,1 );
		if ( doublyLinkedList.isEmpty () ) {
			fail( String.format ( "Error singly linked list with 1 element is empty." ));
		}
	}

	@org.junit.Test
	public void isEmptyTest3 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList ( );
		int n = 100;
		for( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		if ( doublyLinkedList.isEmpty () ) {
			fail( String.format ( "Error singly linked list with %d elements is empty.", n ));
		}
	}

	@org.junit.Test
	public void sizeTest1 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList ( );
		int size = doublyLinkedList.size ();
		int expected = 0;
		if ( size != expected ) {
			fail( String.format ( "Error size of empty list = %d.", size ));
		}
	}

	@org.junit.Test
	public void sizeTest2 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList ( );
		doublyLinkedList.add ( 0, 0 );
		int size = doublyLinkedList.size ();
		int expected = 1;
		if ( size != expected ) {
			fail( String.format ( "Error size of one element list = %d.", size ));
		}
	}

	@org.junit.Test
	public void sizeTest3 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList ( );
		int n = 100;
		for( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		int size = doublyLinkedList.size ();
		int expected = n;
		if ( size != expected ) {
			fail( String.format ( "Error size of %d element list = %d.", n, size ));
		}
	}

	@org.junit.Test
	public void sizeTest4 ( ) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList ( );
		int n = 100;
		for( int i = 0; i < n; i++ ) {
			doublyLinkedList.add ( i, i );
		}
		for( int i = 0; i < n; i++ ) {
			doublyLinkedList.remove ( 0 );
		}
		int size = doublyLinkedList.size ();
		int expected = 0;
		if ( size != expected ) {
			fail( String.format ( "Error size of %d element list = %d.", n, size ));
		}
	}
}