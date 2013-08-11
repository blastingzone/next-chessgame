package pieces;

import java.util.List;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class BishopTest extends TestCase {
	Position position = new Position(4, 4);
	Bishop testBishop = new Bishop(Color.BLACK, position);
	
	public void testGetPossibleMove() throws Exception {
		List<Position> possibleMoves = testBishop.getPossibleMoves();
		assertTrue(possibleMoves.contains(new Position(3,3)));
		assertTrue(possibleMoves.contains(new Position(2,2)));
		assertTrue(possibleMoves.contains(new Position(1,1)));
		assertTrue(possibleMoves.contains(new Position(0,0)));
		assertTrue(possibleMoves.contains(new Position(5,5)));
		assertTrue(possibleMoves.contains(new Position(6,6)));
		assertTrue(possibleMoves.contains(new Position(7,7)));
		assertTrue(possibleMoves.contains(new Position(3,5)));
		assertTrue(possibleMoves.contains(new Position(3,5)));
		assertTrue(possibleMoves.contains(new Position(2,6)));
		assertTrue(possibleMoves.contains(new Position(1,7)));
		assertTrue(possibleMoves.contains(new Position(5,3)));
		assertTrue(possibleMoves.contains(new Position(6,2)));
		assertTrue(possibleMoves.contains(new Position(7,1)));
//		System.out.println(possibleMoves);
	}
}
