package pieces;

import java.util.List;

public interface PieceOperations {
	public char getSymbol();
	public Piece leave();
	public Piece move(Position target);
	public abstract List<Position> getPossibleMoves();
	public boolean isWhite();
	
}
