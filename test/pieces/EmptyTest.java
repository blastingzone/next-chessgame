package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class EmptyTest extends TestCase {
	Position position = new Position(1,1);
	Empty emptyBlock = new Empty(Color.NOCOLOR, position);
	
	@Override
	protected void setUp() throws Exception {
		Position position = new Position(1, 1);
		Empty emptyBlock = new Empty(Color.NOCOLOR, position);
	}
	
	public void testCreate() throws Exception {
		assertEquals(new Empty(Color.NOCOLOR, position), emptyBlock );
	}
	
	public void testGetPossibleMoves() throws Exception {
		assertEquals(null, emptyBlock.getPossibleMoves());
	}
}
