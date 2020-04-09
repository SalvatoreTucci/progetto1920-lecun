package it.uniba.game;
import it.uniba.game.pieces;



public class Move {
	/*
	 * This class represent a generic move converted from the string inserted by the user
	 * (there will be an external method which will do this particular conversion from string to Move)
	*/
	//Attributes
	private Piece toMove;
	private Coordinates startingPos;
	private Coordinates endingPos;
	private boolean isCapture;
	
	
	//Methods
	Move(Piece pieceToSet, Coordinates startPos, Coordinates endPos, boolean cap) {
		
		setPiece(pieceToSet);
		setStartingPos(startPos);
		setEndingPos(endPos);
		setCaptureFlag(cap);
	}
	
	void setPiece(Piece pieceToSet) {
		
		this.toMove = pieceToSet;
	}
	
	Piece getPiece() {
		
		return this.toMove;
	}
	
	Coordinates getEndingPos() {
		
		return this.endingPos;
	}
	
	void setEndingPos(Coordinates posToSet) {
		
		this.endingPos = posToSet;
	}
	
	Coordinates getStartingPos() {
		
		return this.startingPos;
	}
	
	void setStartingPos(Coordinates posToSet) {
		
		this.startingPos = posToSet;
	}
	
	private void setCaptureFlag(boolean flagToSet) {
		
		isCapture = flagToSet;
	}
	
	boolean getCaptureFlag() {
		
		return this.isCapture;
	}
}
