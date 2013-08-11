package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> canMove = new ArrayList<Position>();
		for (Direction direction : Direction.values()) {
			if(this.position.move(direction).isValid()) {
				canMove.add(this.position.move(direction));
			}
		}
		
		return canMove;
	}
}

