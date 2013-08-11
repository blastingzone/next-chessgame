package pieces;

import java.util.List;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class RookTest extends TestCase {
	Position position = new Position(0, 1);
	Rook testRook = new Rook(Color.BLACK, position);
	
	public void testGetPossibleMoves() throws Exception {
		List<Position> possibleMoves = testRook.getPossibleMoves();
		assertTrue(possibleMoves.contains(new Position(0,2)));
		assertTrue(possibleMoves.contains(new Position(0,3)));
		assertTrue(possibleMoves.contains(new Position(0,4)));
		assertTrue(possibleMoves.contains(new Position(0,5)));
		assertTrue(possibleMoves.contains(new Position(0,6)));
		assertTrue(possibleMoves.contains(new Position(0,7)));
		assertTrue(possibleMoves.contains(new Position(1,1)));
		assertTrue(possibleMoves.contains(new Position(2,1)));
		assertTrue(possibleMoves.contains(new Position(3,1)));
		assertTrue(possibleMoves.contains(new Position(4,1)));
		assertTrue(possibleMoves.contains(new Position(5,1)));
		assertTrue(possibleMoves.contains(new Position(6,1)));
		//System.out.println(possibleMoves);
	}
}
