package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	Position position = new Position(4, 4);
	Pawn testBlackPawn = new Pawn(Color.BLACK, position);
	Pawn testWhitePawn = new Pawn(Color.WHITE, position);
	
	public void testGetPossibleMoves() throws Exception {
//		System.out.println(testBlackPawn.getPossibleMoves());
//		System.out.println(testWhitePawn.getPossibleMoves());
		assertTrue(testBlackPawn.getPossibleMoves().contains(new Position(4, 3)));
		assertTrue(testWhitePawn.getPossibleMoves().contains(new Position(4, 5)));
	}
	
	public void testStartPositionMove() throws Exception {
		Position blackStart = new Position(2, 6);
		Position whiteStart = new Position(4, 1);
		Pawn blackPawnStart = new Pawn(Color.BLACK, blackStart);
		Pawn whitePawnStart = new Pawn(Color.WHITE, whiteStart);
//		System.out.println(blackPawnStart.getPossibleMoves());
//		System.out.println(whitePawnStart.getPossibleMoves());
		assertTrue(blackPawnStart.getPossibleMoves().contains(new Position(2, 4)));
		assertTrue(whitePawnStart.getPossibleMoves().contains(new Position(4, 3)));
		
	}
}