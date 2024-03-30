import static org.junit.Assert.*;

public class SinglyLinkedListTest {

	@org.junit.Test
	public void addTest1 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		try {
			singlyLinkedList.add( 0, null );
			fail( String.format( "add(0, null) did not throw IllegalArgumentException." ) );
		} catch ( IllegalArgumentException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void addTest2 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		try {
			singlyLinkedList.add( -1, 1 );
			fail( String.format( "add(-1, 1) did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void addTest3 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( singlyLinkedList.size (), i );
		}
		try {
			singlyLinkedList.add( singlyLinkedList.size ()+1, 1 );
			fail( String.format( "add(size( ) + 1, 1) did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void addTest4 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0, 1 );
		Integer result = singlyLinkedList.get ( 0 );
		int expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then get(0) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest5 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0, 1 );
		singlyLinkedList.add ( 0, 0 );
		Integer result = singlyLinkedList.get ( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then get(0) returned %d expected %d.", result, expected ) );
		}
		result = singlyLinkedList.get ( 1 );
		expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 1) then add(0, 0) and get(1) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest6 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0, 0 );
		singlyLinkedList.add ( 1, 1 );
		Integer result = singlyLinkedList.get ( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 1) and get(0) returned %d expected %d.", result, expected ) );
		}
		result = singlyLinkedList.get ( 1 );
		expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 1) and get(1) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest7 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0, 0 );
		singlyLinkedList.add ( 1, 2 );
		singlyLinkedList.add ( 1, 1 );
		Integer result = singlyLinkedList.get ( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 2) then add(1, 1) and get(0) returned %d expected %d.", result, expected ) );
		}
		result = singlyLinkedList.get ( 1 );
		expected = 1;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 2) then add(1, 1) and get(1) returned %d expected %d.", result, expected ) );
		}
		result = singlyLinkedList.get ( 2 );
		expected = 2;
		if ( (int) result != expected ) {
			fail( String.format( "add(0, 0) then add(1, 2) then add(1, 1) and get(2) returned %d expected %d.", result, expected ) );
		}
	}

	@org.junit.Test
	public void addTest8 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0, 0 );
		singlyLinkedList.add ( 1, 2 );
		singlyLinkedList.add ( 1, 1 );
		int result = singlyLinkedList.size ();
		int expected = 3;
		if ( result != expected ) {
			fail ( String.format ( "Added 3 elements size=%d expected %d", result, expected ) );
		}
	}

	@org.junit.Test
	public void getTest1 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		try {
			singlyLinkedList.get( 0 );
			fail( String.format( "Get on empty list did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest2 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0,1 );
		try {
			singlyLinkedList.get( -1 );
			fail( String.format( "Get where index < 0 did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest3 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0,1 );
		try {
			singlyLinkedList.get( 1 );
			fail( String.format( "Get where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest4 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		try {
			singlyLinkedList.get( singlyLinkedList.size () );
			fail( String.format( "Get where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void getTest5 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for( int i = 0; i < n; i++ ) {
			Integer result = singlyLinkedList.get( i );
			if ( (int) result != i ) {
				fail ( String.format (
						  "get(%d) returned %d expected %d.", i, result, i ) );
			}
		}
	}

	@org.junit.Test
	public void getTest6 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for( int i = n - 1; i >= 0; i-- ) {
			Integer result = singlyLinkedList.get( i );
			if ( (int) result != i ) {
				fail ( String.format (
						  "get(%d) returned %d expected %d.", i, result, i ) );
			}
		}
	}

	@org.junit.Test
	public void getTest7 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for( int i = n - 1; i > 0; i-- ) {
			singlyLinkedList.remove ( 0 );
		}
		Integer result = singlyLinkedList.get( 0 );
		int expected = (n - 1);
		if ( (int) result != expected ) {
			fail ( String.format (
					  "get(%d) returned %d expected %d.", 0, result, expected ) );
		}
	}

	@org.junit.Test
	public void getTest8 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for( int i = n - 1; i > 0; i-- ) {
			singlyLinkedList.remove ( i );
		}
		Integer result = singlyLinkedList.get( 0 );
		int expected = 0;
		if ( (int) result != expected ) {
			fail ( String.format (
					  "get(%d) returned %d expected %d.", 0, result, expected ) );
		}
	}

	@org.junit.Test
	public void removeTest1 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		try {
			singlyLinkedList.remove ( 0 );
			fail( String.format( "Remove on empty list did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest2 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0,1 );
		try {
			singlyLinkedList.remove ( 1 );
			fail( String.format( "Remove where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest3 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		try {
			singlyLinkedList.remove ( singlyLinkedList.size () );
			fail( String.format( "Remove where index == size did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest4 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for ( int i = n - 1; i >= 0; i-- ) {
			Integer result = singlyLinkedList.remove ( i );
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
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for ( int i = 0; i < n; i++ ) {
			Integer result = singlyLinkedList.remove ( 0 );
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
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		int n = 100;
		for ( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for ( int i = 50; i < n; i++ ) {
			Integer result = singlyLinkedList.remove ( 50 );
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
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0, 0 );
		singlyLinkedList.add ( 1, 1 );
		singlyLinkedList.add ( 2, 2 );
		Integer result = singlyLinkedList.remove ( 1 );
		if ( result == null ) {
			fail( String.format( "remove(%d) returned null expecting %d", 1, 1 ) );
		}
		if ( (int) result != 1 ) {
			fail( String.format( "remove(%d) returned %d expecting %d", 1, result, 1 ) );
		}
		if ( (int) singlyLinkedList.get ( 0 ) != 0 || (int) singlyLinkedList.get ( 1 ) != 2 ) {
			fail( String.format( "After remove, newly adjacent nodes had wrong values." ) );
		}
	}

	@org.junit.Test
	public void removeTest8 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0,1 );
		try {
			singlyLinkedList.remove ( -1 );
			fail( String.format( "Remove where index< 0 did not throw IndexOutOfBoundsException." ) );
		} catch ( IndexOutOfBoundsException e ) {
			// Expected
		}
	}

	@org.junit.Test
	public void removeTest9 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList( );
		singlyLinkedList.add ( 0, 0 );
		singlyLinkedList.add ( 1, 2 );
		singlyLinkedList.add ( 1, 1 );
		for( int i = 0; i < 100; i++ ) {
			try {
				singlyLinkedList.remove ( 0 );
			} catch ( IndexOutOfBoundsException e ) {

			}
		}
		singlyLinkedList.add ( 0, 3 );
		int result = singlyLinkedList.size ();
		int expected = 1;
		if ( result != expected ) {
			fail ( String.format ( "Added 3 elements, removed 100, added 1 size=%d expected %d", result, expected ) );
		}
	}

	@org.junit.Test
	public void isEmptyTest1 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
		if ( !singlyLinkedList.isEmpty () ) {
			fail( String.format ( "Error new singly linked list not empty." ));
		}
	}

	@org.junit.Test
	public void isEmptyTest2 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
		singlyLinkedList.add ( 0,1 );
		if ( singlyLinkedList.isEmpty () ) {
			fail( String.format ( "Error singly linked list with 1 element is empty." ));
		}
	}

	@org.junit.Test
	public void isEmptyTest3 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
		int n = 100;
		for( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		if ( singlyLinkedList.isEmpty () ) {
			fail( String.format ( "Error singly linked list with %d elements is empty.", n ));
		}
	}

	@org.junit.Test
	public void sizeTest1 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
		int size = singlyLinkedList.size ();
		int expected = 0;
		if ( size != expected ) {
			fail( String.format ( "Error size of empty list = %d.", size ));
		}
	}

	@org.junit.Test
	public void sizeTest2 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
		singlyLinkedList.add ( 0, 0 );
		int size = singlyLinkedList.size ();
		int expected = 1;
		if ( size != expected ) {
			fail( String.format ( "Error size of one element list = %d.", size ));
		}
	}

	@org.junit.Test
	public void sizeTest3 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
		int n = 100;
		for( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		int size = singlyLinkedList.size ();
		int expected = n;
		if ( size != expected ) {
			fail( String.format ( "Error size of %d element list = %d.", n, size ));
		}
	}

	@org.junit.Test
	public void sizeTest4 ( ) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList ( );
		int n = 100;
		for( int i = 0; i < n; i++ ) {
			singlyLinkedList.add ( i, i );
		}
		for( int i = 0; i < n; i++ ) {
			singlyLinkedList.remove ( 0 );
		}
		int size = singlyLinkedList.size ();
		int expected = 0;
		if ( size != expected ) {
			fail( String.format ( "Error size of %d element list = %d.", n, size ));
		}
	}
}