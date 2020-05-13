package it.uniba.game;

import it.uniba.game.pieces.Piece;

/**
 * Class representing a game move <br>
 * Class type : Entity <br>
 * 
 * Responsibilities : <br>
 * 
 * 	Knows :
 * 		<ul>
 * 			<li>The types of castling</li>
 *			<li>The piece to move on the ChessBoard</li>
 *			<li>The starting position of the piece to move</li>
 *			<li>The ending position of the piece to move</li>
 *			<li>If the piece to move captures a piece</li>
 *			<li>If the move is "en passant"</li>
 *			<li>If the move is a castling</li>
 * 		</ul>
 * 
 * 	Does :
 * 		<ul>
 *			<li>Gets or changes the piece to move</li>
 *			<li>Gets or changes the starting and ending position of the piece to move</li>
 *			<li>Gets or changes if the move is a capture</li>
 *			<li>Gets or changes if the move is "en passant"</li>
 *			<li>Gets or changes if the move is a castling</li>
 * 		</ul>
 *  
 * @author LeCun group
 */
public class Move {
	/*
	 * This class represent a generic move converted from the string inserted by the user
	 * (there will be an external method which will do this particular conversion from string to Move)
	*/
	public enum Castling {
		
		NO_CASTLING,
		KINGSIDE_CASTLING,
		QUEENSIDE_CASTLING
    }
	
	
	// Attributes
	private Piece toMove;
	private Coordinates startingPos;
	private Coordinates endingPos;
	private boolean isCapture;
	private boolean isEnPassant = false;
	private Castling typeCastling = Castling.NO_CASTLING;
	
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
	
	public void setCastling(Castling newCastling) {
		
		typeCastling = newCastling;
	}
	
	public Castling getCastling() {
		
		return typeCastling;
	}
}
