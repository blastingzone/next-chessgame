package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> canMove = new ArrayList<Position>();
		Position moveBlackPawn = this.position.move(Direction.SOUTH);
		Position moveWhitePawn = this.position.move(Direction.NORTH);
		
		if (this.isBlack() && moveBlackPawn.isValid()) {
			canMove.add(moveBlackPawn);
		}
		else if (this.isWhite() && moveWhitePawn.isValid()) {
			canMove.add(moveWhitePawn);
		}
		
		return canMove;
	}
}
