package pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		ArrayList<Position> canMove = new ArrayList<Position>();
		for (Direction direction : Direction.linearDirection()) {
			List<Position> ListFound = super.position.findsPosition(direction);
			for (Position position : ListFound) {
				canMove.add(position);
			}
		}
		
		return canMove;
	}
}
