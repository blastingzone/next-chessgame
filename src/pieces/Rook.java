package pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	public	List<Position> getPossibleMoves() {
		ArrayList<Position> canMove = new ArrayList<Position>();
		for (Direction direction : Direction.linearDirection()) {
			List<Position> foundPosition = this.position.findsPosition(direction);
			for (Position position : foundPosition) {
				canMove.add(position);
			}
		}
		
		return canMove;
	}
}
