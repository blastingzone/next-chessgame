package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class KnightTest extends TestCase {
	Position position = new Position(4, 4);
	Knight testKnight = new Knight(Color.BLACK, position);
	
	public void testGetPossibleMoves() throws Exception {
//		System.out.println(testKnight.getPossibleMoves());
		assertEquals(8, testKnight.getPossibleMoves().size());
		assertTrue(testKnight.getPossibleMoves().contains(new Position(2, 5)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(2, 3)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(3, 2)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(3, 6)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(5, 2)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(5, 6)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(6, 3)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(6, 5)));
	}
	
	public void testImpossiblePosition() throws Exception {
		position = new Position(0,0);
		testKnight = new Knight(Color.BLACK, position);
//		System.out.println(testKnight.getPossibleMoves());
		assertEquals(2, testKnight.getPossibleMoves().size());
		assertTrue(testKnight.getPossibleMoves().contains(new Position(2, 1)));
		assertTrue(testKnight.getPossibleMoves().contains(new Position(1, 2)));
		
	}
}
