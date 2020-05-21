package it.uniba.game;

import it.uniba.game.pieces.Piece;

/**
 * Class representing a generic move converted from the string inserted by the user.<br>
 * Class type : &#60; Entity &#62; <br><br>
 * 
 * Responsibilities : <br>
 *
 * 
 * 	Knows :<br>
 * 		<ul>
 * 			<li>The types of castling</li>
 *			<li>The piece to move on the ChessBoard</li>
 *			<li>The starting position of the piece to move</li>
 *			<li>The ending position of the piece to move</li>
 *			<li>If the piece to move captures a piece</li>
 *			<li>If the move is <i>en passant</i></li>
 *			<li>If the move is a castling</li>
 * 		</ul>
 * 
 * 	Does :<br>
 * 		<ul>
 *			<li>Gets or changes the piece to move</li>
 *			<li>Gets or changes the starting and ending position of the piece to move</li>
 *			<li>Gets or changes if the move is a capture</li>
 *			<li>Gets or changes if the move is <i>en passant</i></li>
 *			<li>Gets or changes if the move is a castling</li>
 * 		</ul>
 * 
 * @author LeCun group<br>
 */



public final class Move {

	/**
	 *	Enumerated type used to represent the castling of the move
	 */
	public enum Castling {

		NO_CASTLING,
		KINGSIDE_CASTLING,
		QUEENSIDE_CASTLING
    }

	// Attributes

	/**
	 * This is the piece moved by the player.
	 */
	private Piece toMove;

	/**
	 * Coordinates of the starting square of the piece being moved.
	 */
	private Coordinates startingPos;

	/**
	 * Coordinates of the ending square of the piece being moved.
	 */
	private Coordinates endingPos;

	/**
	 * Flag indicating whether the move involves a capture (<code>true</code>) or not.
	 */
	private boolean isCapture;

	/**
	 * Flag indicating whether the move involves a <i>en passant</i>capture
	 * (<code>true</code>) or not.
	 */
	private boolean isEnPassant = false;

	/**
	 * Flag indicating if the move is a Castling or not (<code>Castling.NO_CASTLING</code>).
	 * It is usually initialized as <code>Castling.NO_CASTLING</code>, otherwise it can
	 * indicate whether the castling is on the king side (<code>Castling.KINGSIDE_CASTLING</code>)
	 * or on the queen side (<code>Castling.QUEENSIDE_CASTLING</code>).
	 */
	private Castling typeCastling = Castling.NO_CASTLING;


	// Methods <br>
	/**
	 * Constructor for the class Move. If the move is a castling, input parameters can be null
	 * and the type of the castling should be set after the construction, since it is initialized as
	 * Castling.NO_CASTLING.
	 * Otherwise both startPos and endPos are assumed to be between (0,0) and (7,7) or Constants.EMPTY_COORD
	 * since this class doesn't have the responsibility to check their correctness.
	 * Finally, it also initializes the flag <i>en passant</i> as <code>false</code>
	 * 
	 * @param pieceToSet The piece involved in the move to be set.
	 * @param startPos The coordinates of the starting square of the piece to be set.
	 * @param endPos The coordinates of the ending square of the piece to be set.
	 * @param cap Boolean indicating whether the move is a capture to be set.
	 */
	public Move(final Piece pieceToSet, final Coordinates startPos,
			final Coordinates endPos, final boolean cap) {

		setPiece(pieceToSet);
		setStartingPos(startPos);
		setEndingPos(endPos);
		isCapture = cap;
	}

	/**
	 * Setter method for the piece of the move
	 * 
	 * @param pieceToSet The piece to set as the one moving.
	 */
	public void setPiece(final Piece pieceToSet) {

		this.toMove = pieceToSet;
	}

	/**
	 * Getter method for the piece of the move
	 * 
	 * @return A reference the the piece being moved
	 * 		   (which is usually different from the one on the chessboard)
	 */
	public Piece getPiece() {

		return this.toMove;
	}

	/**
	 * Getter method for the ending position of the move.
	 * 
	 * @return A Coordinates object containing the ending position of the move
	 */
	public Coordinates getEndingPos() {

		return this.endingPos;
	}

	/**
	 * Getter method for the ending position of the move.
	 * 
	 * @param posToSet The Coordinates object containing the position of the ending position to be set.
	 */
	public void setEndingPos(final Coordinates posToSet) {

		this.endingPos = posToSet;
	}

	/**
	 * Getter method for the starting position of the move.
	 * 
	 * @return A Coordinates object containing the starting position of the move
	 */
	public Coordinates getStartingPos() {

		return this.startingPos;
	}

	/**
	 * Getter method for the starting position of the move.
	 * 
	 * @param posToSet The Coordinates object containing the position of the starting position to be set.
	 */
	public void setStartingPos(final Coordinates posToSet) {

		this.startingPos = posToSet;
	}

	/**
	 * Getter method for the capture flag.
	 * 
	 * @return <code>true</code> if the move is a capture, <code>false</code> otherwise
	 */
	public boolean getCaptureFlag() {

		return this.isCapture;
	}

	/**
	 * Getter method for the <i>en passant</i> flag.
	 * 
	 * @return <code>true</code> if the move is an <i>en passant</i> capture, <code>false</code> otherwise
	 */
	public boolean getEnPassant() {

		return isEnPassant;
	}
	/**
	 * Sets the <i>en passant</i> flag as true.
	 */
	public void setEnPassant() {

		isEnPassant = true;
	}

	/**
	 * Sets the type of the castling. If <code>newCastling==null</code> then the method
	 * does nothing.
	 * 
	 * @param newCastling Castling enumeration to be set
	 */
	public void setCastling(final Castling newCastling) {
		if (newCastling != null) {

			typeCastling = newCastling;
		}
	}

	/**
	 * Getter method for the castling type.
	 * 
	 * @return A Castling enumeration indicating whether and which castling the move is.
	 */
	public Castling getCastling() {

		return typeCastling;
	}
}
