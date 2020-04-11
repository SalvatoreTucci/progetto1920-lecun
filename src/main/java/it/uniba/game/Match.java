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
/*
		Move parsedMove = parseMove(toParse);
		Coordinates startingPos = findToMove(parsedMove);
		
		if(parsedMove.getCaptureFlag()){
			insertCapture(parsedMove);
		}
		
		field.setMove(parsedMove);
		
		moves.add(toParse);
*/
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
		boolean validMove = Pattern.matches(Constants.GENERAL_MOVE_REGEX, toParse);
		
		if(validMove) {
			boolean capture = toParse.contains("x");
			Coordinates finalPos = new Coordinates((int) (toParse.charAt(toParse.length() - 2) - Constants.CHAR_COLUMN_OFFSET),
					Math.abs((int) toParse.charAt(toParse.length() - 1) - Constants.ROW_OFFSET));
			
			Piece toMove = null;
			int offsetDisambiguation = 0;
			
			if(Pattern.matches(Constants.PIECE_MOVE_REGEX, toParse)) {
				switch(toParse.charAt(0)) {
					case 'R': 	toMove = new King(currentPlayer);
								break;
					case 'D':	toMove = new Queen(currentPlayer);
								break;
					case 'T':	toMove = new Rook(currentPlayer);
								break;
					case 'A':	toMove = new Bishop(currentPlayer);
								break;
					case 'C':	toMove = new Knight(currentPlayer);
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
