package pieces;

import java.util.List;

import junit.framework.TestCase;
import pieces.Piece.Color;

public class KingTest extends TestCase {
	Position position = new Position(4,4);
	King testKing = new King(Color.BLACK, position);
	
	public void testGetPossibleMoves() throws Exception {
		List<Position> possibleMove = testKing.getPossibleMoves();
		assertTrue(possibleMove.contains(new Position(3,4)));
		assertTrue(possibleMove.contains(new Position(3,3)));
		assertTrue(possibleMove.contains(new Position(3,5)));
		assertTrue(possibleMove.contains(new Position(4,3)));
		assertTrue(possibleMove.contains(new Position(4,5)));
		assertTrue(possibleMove.contains(new Position(5,4)));
		assertTrue(possibleMove.contains(new Position(5,3)));
		assertTrue(possibleMove.contains(new Position(5,5)));
//		System.out.println(possibleMove);
	}
	
	public void testImpossiblePosition() throws Exception {
		testKing.move(new Position(0,0));
		List<Position> possibleMove = testKing.getPossibleMoves();
		assertFalse(possibleMove.contains(new Position(-1, -1)));
		assertFalse(possibleMove.contains(new Position(0, -1)));
		assertFalse(possibleMove.contains(new Position(-1, 0)));
		assertFalse(possibleMove.contains(new Position(-1, 1)));
		assertFalse(possibleMove.contains(new Position(1, -1)));
//		System.out.println(possibleMove);
	}
}
