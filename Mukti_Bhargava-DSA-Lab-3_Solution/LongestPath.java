import java.util.ArrayList;

public class LongestPath {
	static class Node {
		int data;
		Node left, right;
		
		public Node( int data ) {
			this.data = data;
			left = right = null; 
		}
	}
	
	private static ArrayList findLongestPath( Node root ) {
		// reached a leaf node
		if( root.left == null && root.right == null ) {
			ArrayList a = new ArrayList();
			a.add( root.data );
			return a;
		}
		
		// example, let's say root is 20
		// L = the longest path in the left subtree (root.left) - make a recursive call (eg. L = 120, 80, 40)
		ArrayList L = findLongestPath( root.left );
		// R = the longest path in the right subtree (root.right) - make a recursive call (eg. R = 100, 50)
		ArrayList R = findLongestPath( root.left );
		
		// compare the size of L, R (use the size() method)
		if( L.size() > R.size() ) {
			// pick the longer list, and add() to that list
			// return that list
			L.add( root.data );
			return L;
		} else {
			R.add( root.data );
			return R;
		}
	}
	
	public static void main( String[] args ) {
		Node root = new Node( 10 );
		root.left = new Node( 20 );
		root.right = new Node( 30 );
		root.left.left = new Node( 40 );
		root.left.right = new Node( 50 );
		root.right.left = new Node( 60 );
		root.right.right = new Node( 70 );
		root.left.left.left = new Node( 80 );
		root.left.left.right = new Node( 90 );
		root.left.right.left = new Node( 100 );
		root.left.right.right = new Node( 110 );
		root.left.left.left.left = new Node( 120 );
		
		ArrayList longestPath = findLongestPath( root );
		System.out.println( longestPath.size() );
		
		for( int i = longestPath.size() - 1; i >= 0; i-- ) {
			System.out.print( longestPath.get( i ) + "  " );
		}
	}
}

