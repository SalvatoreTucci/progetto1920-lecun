package it.uniba.game;

import it.uniba.game.pieces.Piece;

public class Move {
	/*
	 * This class represent a generic move converted from the string inserted by the user
	 * (there will be an external method which will do this particular conversion from string to Move)
	*/
	
	// Attributes
	private Piece toMove;
	private Coordinates startingPos;
	private Coordinates endingPos;
	private boolean isCapture;
	private boolean isEnPassant = false;
	
	// Methods
	public Move(Piece pieceToSet, Coordinates startPos, Coordinates endPos, boolean cap) {
		
		setPiece(pieceToSet);
		setStartingPos(startPos);
		setEndingPos(endPos);
		isCapture = cap;
		
	}
	
	public void setPiece(Piece pieceToSet) {
		
		this.toMove = pieceToSet;
	}
	
	public Piece getPiece() {
		
		return this.toMove;
	}
	
	public Coordinates getEndingPos() {
		
		return this.endingPos;
	}
	
	public void setEndingPos(Coordinates posToSet) {
		
		this.endingPos = posToSet;
	}
	
	public Coordinates getStartingPos() {
		
		return this.startingPos;
	}
	
	public void setStartingPos(Coordinates posToSet) {
		
		this.startingPos = posToSet;
	}
	
	
	public boolean getCaptureFlag() {
		
		return this.isCapture;
	}
	
	public boolean getEnPassant() {
		
		return isEnPassant;
	}
	
	public void setEnPassant() {
		
		isEnPassant = true;
	}
}
