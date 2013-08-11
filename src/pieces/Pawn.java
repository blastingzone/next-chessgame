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
			if (this.position.getY() == 6) {
				canMove.add(moveBlackPawn.move(Direction.SOUTH));
			}
		}
		else if (this.isWhite() && moveWhitePawn.isValid()) {
			canMove.add(moveWhitePawn);
			if (this.position.getY() == 1) {
				canMove.add(moveWhitePawn.move(Direction.NORTH));
			}
		}
		
		return canMove;
	}
}
