package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece.Color;
import pieces.PieceOperations;
import pieces.Position;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
		board.setInitialize(new Initialize());
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.setInitialize(new InitializeEmpty());
		board.initialize();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		PieceOperations sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
	public void testEmptyPieceMove() throws Exception {
		board.initialize();
		Position source = new Position("a3");
		PieceOperations sourcePiece = board.findPiece(source);
		assertEquals(new Empty(Color.NOCOLOR, source), sourcePiece);
		
		Position target = new Position("a4");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
		assertEquals(sourcePiece.getSymbol(), board.findPiece(target).getSymbol());
	}
	
	public void testWrongTargetMove() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("g9");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
	}
	
	public void testSameColorAttack() throws Exception {
		board.initialize();
		Position source = new Position("a1");
		Position target = new Position("a2");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
		source = new Position("a8");
		target = new Position("a7");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
	}
	
	public void testImpossibleMovement() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("a5");
		board.movePiece(source, target);
		System.out.println(board.generateBoard());
	}
}
