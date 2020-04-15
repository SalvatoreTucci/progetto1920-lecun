package it.uniba.game.board;

import it.uniba.game.pieces.Piece;

public class Square {
	/* 
	 * This class represents the single square of the chessboard,
	 * where pieces are placed
	*/
	
	// Attributes
	private Piece placed;
	
	// Constructor
	public Square(Piece toPlace) {
		
		placed = toPlace;
	}
	
	// Methods
	public Piece getPiece() {
		
		return placed;
	}
	
	void setPiece(Piece toPlace) {
		
		placed = toPlace;
	}
	
	
	public boolean isOccupied() {
		
		if (getPiece() == null) {
			
			return false;
		} else {
			
			return true;
		}
	}
	
}
