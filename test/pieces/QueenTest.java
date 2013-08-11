package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class QueenTest extends TestCase {
	Position position = new Position(4, 4);
	Queen testQueen = new Queen(Color.BLACK, position);
	Rook testRook = new Rook(Color.BLACK, position);
	Bishop testBishop = new Bishop(Color.BLACK, position);
	
	public void testGetPossibleMove() throws Exception {
		for (Position position : testRook.getPossibleMoves()) {
			assertTrue(testQueen.getPossibleMoves().contains(position));
		}
		for (Position position : testBishop.getPossibleMoves()) {
			assertTrue(testQueen.getPossibleMoves().contains(position));
		}
	}
}