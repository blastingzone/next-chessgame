package chess;

public class InitializeEmpty implements InitializeBoard {

	@Override
	public void initialize(Board board) {
		for (int i = 0; i < Board.ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			board.ranks.add(rank);
		}
	}

}
