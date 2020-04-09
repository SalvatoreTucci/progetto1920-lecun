package it.uniba.game;

public class Move {
	
	private Piece toMove;
	private Coordinates startingPos;
	private Coordinates endingPos;
	private boolean isCapture;
	
	Move(Piece pieceToSet, Coordinates startPos, Coordinates endPos, boolean cap) {
		
		setPiece(pieceToSet);
		setStartingPos(startPos);
		setEndingPos(endPos);
		setCaptureFlag(cap);
	}
	
	void setPiece(Piece pieceToSet) {
		
		Move.toMove = pieceToSet;
	}
	
	Piece getPiece() {
		
		return Piece.toMove;
	}
	
	Coordinates getEndingPos() {
		
		return Move.endingPos;
	}
	
	void setEndingPos(Coordinates posToSet) {
		
		Move.endingPos = posToSet;
	}
	
	Coordinates getStartingPos() {
		
		return Move.startingPos;
	}
	
	void setStartingPos(Coordinates posToSet) {
		
		Move.startingPos = posToSet;
	}
	
	private void setCaptureFlag(boolean flagToSet) {
		
		isCapture = flagToSet;
	}
	
	boolean getCaptureFlag() {
		
		return Move.isCapture;
	}
}
