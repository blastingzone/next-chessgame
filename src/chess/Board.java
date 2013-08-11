package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.PieceOperations;
import pieces.Position;

public class Board {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i==0) {
				rank.initializeWhiteExceptPawn();
			} else if (i==1) {
				rank.initializeWhitePawn();
			} else if (i==6) {	
				rank.initializeBlackPawn();
			} else if (i==7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		PieceOperations targetPiece = findPiece(source);
		if (targetPiece.getSymbol() == Piece.Type.EMPTY.getSymbol()) {
			System.out.println("No Piece Error!");
			return;
		}

		if (!target.isValid()) {
			System.out.println("Target Position Error!");
			return;
		}
		
		//true == true 혹은 false == false라면 둘은 같은 색이다.
		if (findPiece(target).isWhite() == findPiece(source).isWhite()) {
			System.out.println("Friendly Fire Error!");
			return;
		}
		
		if (!findPiece(source).getPossibleMoves().contains(target)) {
			System.out.println("Impossible Movement Error!");
			return;
		}
		
		PieceOperations sourcePiece = targetPiece.leave();
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);
		
		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);
	}
	
	String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	String generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i-1) + NEW_LINE);
		}
		return sb.toString();
	}
}
