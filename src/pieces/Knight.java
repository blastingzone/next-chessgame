package pieces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	public	List<Position> getPossibleMoves() {
		Set<Position> canMove = new HashSet<Position>();
		for (Direction LDirection : Direction.linearDirection()) {
			Position firstStep = this.position.move(LDirection);

			if (firstStep.isValid()) {
				for (Direction DDirection : Direction.diagonalDirection()) {
					if (firstStep.move(DDirection).isValid())
						canMove.add(firstStep.move(DDirection));
				}
			}
		}
			for (Direction LDirection : Direction.linearDirection()) {
				canMove.remove(this.position.move(LDirection));
		}

		return new ArrayList<Position>(canMove);
	}
}
