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
	
	private GenerateBoard generateBoard = new BoardConsolePrint();
	private InitializeBoard initialBoard = new Initialize();
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	Board() {
	}

	void initialize() {
		initialBoard.initialize(this);
	}
	
	void setInitialize(InitializeBoard initialBoard) {
		this.initialBoard = initialBoard;
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

	void setGenerateBoard(GenerateBoard generateBoard) {
		this.generateBoard = generateBoard;
	}
	
	String generateBoard() {
		return generateBoard.generateBoard(this);
	}
	
}
