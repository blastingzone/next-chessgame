package pieces;

import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		Piece tempRook = new Rook(Color.BLACK, this.position);
		Piece tempBishop = new Bishop(Color.BLACK, this.position);
		List<Position> canMove = tempRook.getPossibleMoves();
		
		for(Position position : tempBishop.getPossibleMoves()) {
			canMove.add(position);
		}
		
		return canMove;
	}
}