package it.uniba.game;
import it.uniba.game.pieces.*;
import it.uniba.game.board.ChessBoard;
import java.util.Vector;
import java.util.regex.Pattern;

class Match {
	/*
	 * Class used to manage the flow of the game
	 */

	// Attributes
	private ChessBoard field;
	private Vector<Piece> blackCaptured;
	private Vector<Piece> whiteCaptured;
	private Vector<String> moves;
	private Piece.Color currentPlayer;
	
	// Methods
	public Match() {
		
		currentPlayer = Piece.Color.WHITE;
		blackCaptured = new Vector<Piece>();
		whiteCaptured = new Vector<Piece>();
		moves = new Vector<String>();
		
	}
	
	public void inputMove(String toParse) {

		Move parsedMove = parseMove(toParse);
		parsedMove = findToMove(parsedMove);
		
		if(parsedMove.getCaptureFlag()){
			insertCapture(parsedMove);
		}
		
		field.setMove(parsedMove);
		
		moves.add(toParse);
	}
	
	void insertCapture(Move captureMove) {
/*		
		Coordinates endingSquare = captureMove.getEndingPos();
		Piece capturedPiece = field.getPiece(endingSquare);
		
		if(capturedPiece.getColor() == Piece.Color.BLACK){
			whiteCaptured.add(capturedPiece);
		}
		else{
			blackCaptured.add(capturedPiece);
		}
*/	
	}
	
	public String getPrintableCaptures(Piece.Color side) {
		
		if(side == Piece.Color.WHITE) {
			return whiteCaptured.toString();			
		}
		else {
			return blackCaptured.toString();	
		}
	}
	
	public String getPrintableMoves() {
		// returns a printable version of the move history, as in
		// 1. e3, b6
		// 2. c4, f6
		
		String printableHistory = "";

		int i = 0;
		int j = 1;
		while(i < moves.size()) {
			
			if(i % 2 == 0) {
				printableHistory += "\n" + j + ". ";
				j++;
			}
			
			printableHistory += moves.elementAt(i);
			
			if(i % 2 == 0) {
				printableHistory += ", ";
			}
			
			i++;
		}
		
		return printableHistory;
	}
	
	public String getPrintableChessboard() {
		
		return field.toString();
	}
	
	public Piece.Color getCurrentPlayer(){
		
		return currentPlayer;
	}
	
	public void nextTurn() {
		// method used to proceed in the game flow
		
		if(currentPlayer == Piece.Color.BLACK) {
			currentPlayer = Piece.Color.WHITE;	
		}
		else {
			currentPlayer = Piece.Color.BLACK;
		}
		
	}

	private Move parseMove(String toParse) {
		// parses a move from a user entered string, following the algebraic notation
		// the general form for a recognized move is:
		// [Piece][Disambiguation coordinate][Capture][Landing square column][Landing square row]
		
		boolean validMove = Pattern.matches(Constants.GENERAL_MOVE_REGEX, toParse);
		
		if(validMove) {
			boolean capture = toParse.contains(Constants.MOVE_CAPTURE);
			Coordinates finalPos = new Coordinates((int) (toParse.charAt(toParse.length() - 2) - Constants.CHAR_COLUMN_OFFSET),
					Math.abs((int) toParse.charAt(toParse.length() - 1) - Constants.ROW_OFFSET));
			
			Piece toMove = null;
			int offsetDisambiguation = 0;
			
			if(Pattern.matches(Constants.PIECE_MOVE_REGEX, toParse)) {
				switch(toParse.charAt(0)) {
					case Constants.CHAR_KING: 	toMove = new King(currentPlayer);
												break;
					case Constants.CHAR_QUEEN:	toMove = new Queen(currentPlayer);
												break;
					case Constants.CHAR_ROOK:	toMove = new Rook(currentPlayer);
												break;
					case Constants.CHAR_BISHOP:	toMove = new Bishop(currentPlayer);
												break;
					case Constants.CHAR_KNIGHT:	toMove = new Knight(currentPlayer);
												break;
				}
				offsetDisambiguation = 1;
				
			}
			else {
				toMove = new Pawn(currentPlayer);
				
			}
			
			Coordinates startPos = new Coordinates(Constants.INVALID_POS, Constants.INVALID_POS);
			
			if(Pattern.matches(Constants.DISAMBIGUATION_REGEX, toParse)) {
				
				if((int) toParse.charAt(offsetDisambiguation) >= Constants.CHAR_COLUMN_OFFSET) {
					startPos.setColumn((int) (toParse.charAt(offsetDisambiguation) - Constants.CHAR_COLUMN_OFFSET));
					
				}
				else {
					startPos.setRow(Math.abs((int) toParse.charAt(offsetDisambiguation) - Constants.ROW_OFFSET));
					
				}
				
			}
			
			return new Move(toMove, startPos, finalPos, capture);
			
		}
		else {
			return null;
			
		}
	}

/*
	private Coordinates findToMove(Move toMove) {
		
	}
*/
	
}
