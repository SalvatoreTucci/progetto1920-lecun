package it.uniba.game;
import it.uniba.game.pieces.Piece;
import it.uniba.game.board.Chessboard;
import java.util.Vector;

class Match {
	/*
	 * Class used to manage the flow of the game
	 */

	// Attributes
	private Chessboard field;
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
		Coordinates startingPos = findToMove(parsedMove);
		
		if(parsedMove.getCaptureFlag())
			insertCapture(parsedMove);
		
		field.setMove(parsedMove);
		
		moves.add(toParse);
	}
	
	void insertCapture(Move captureMove) {
		
		Coordinates endingSquare = captureMove.getEndingPos();
		Piece capturedPiece = field.getPiece(endingSquare.getRow(), endingSquare.getColumn());
		
		if(capturedPiece.getColor() == Piece.Color.BLACK)
			whiteCaptured.add(capturedPiece);
		else
			blackCaptured.add(capturedPiece);
		
	}
	
	public String getPrintableCaptures(Piece.Color side) {
		
		if(side == Piece.Color.WHITE)
			return whiteCaptured.toString();
		else
			return blackCaptured.toString();
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
		
		if(currentPlayer == Piece.Color.BLACK)
			currentPlayer = Piece.Color.WHITE;
		else
			currentPlayer = Piece.Color.BLACK;
	}
	
	private Move parseMove(String toParse) {
	
		
	}
	
	private Coordinates findToMove(Move toMove) {
		
	}
	
}
