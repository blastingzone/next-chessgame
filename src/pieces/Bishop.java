package pieces;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece {
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		ArrayList<Position> canMove = new ArrayList<Position>();
		for (Direction direction : Direction.diagonalDirection()) {
			List<Position> foundPosition = this.position.findsPosition(direction);
			for (Position position : foundPosition) {
				canMove.add(position);
			}
		}
		
		return canMove;
	}
}