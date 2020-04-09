package it.uniba.game;
import it.uniba.game.pieces.Piece;
import java.util.Vector;

public class Match {
	/*
	 * Class used to manage the flow of the game
	 */

	// Attributes
	Chessboard field;
	Vector<Piece> blackCaptured;
	Vector<Piece> whiteCaptured;
	Vector<String> moves;
	Piece.Color currentPlayer;
	
	// Methods
	public Match() {
		
		currentPlayer = Piece.Color.WHITE;
	}
	
	public void inputMove(String toParse) {
		
		
	}
	
	void insertCapture(Move captureMove) {
		
	}
	
	public String getPrintableCaptures(Piece.Color side) {
		
		if(side == Piece.Color.WHITE)
			return whiteCaptured.toString();
		else
			return blackCaptured.toString();
	}
	
	public String getPrintableMoves() {
		// returns a printable version of the move history, as in
		// 1: e3, b6
		// 2: c4, f6
		

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
