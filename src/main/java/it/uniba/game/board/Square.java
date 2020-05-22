package it.uniba.game.board;

import it.uniba.game.pieces.Piece;

/**
 * Class representing a single square of the chessboard <br>
 * Class type : &#60; Entity &#62; <br><br>
 * 
 * Responsibilities : <br>
 * 
 * 	Knows :
 * 		<ul>
 *			<li>The piece placed on the square</li>
 * 		</ul>
 * 
 * 	Does :
 * 		<ul>
 *			<li>Places a new piece on the square</li>
 *			<li>Gets the piece placed on the square</li>
 *			<li>Checks if there is a piece placed on the square</li>
 * 		</ul>
 * 
 * @author LeCun group
 */



public final class Square {

	/**
	 * <code> placed </code> represents the piece placed on the square.
	 * If the square is empty, placed is initialized to null.
	 */
	private Piece placed;

	/**
	 * Constructor for the class Square.
	 * 
	 * @param toPlace piece to place on the Square.
	 */
	public Square(final Piece toPlace) {

		placed = toPlace;
	}

	// Methods
	/**
	 * Getter method for the attribute placed.
	 * 
	 * @return the piece placed on the square
	 */
	public Piece getPiece() {

		return placed;
	}

	/**
	 * Setter method for the attribute placed.
	 * 
	 * @param toPlace the new piece to place on the square
	 */
	void setPiece(final Piece toPlace) {

		placed = toPlace;
	}

	/**
	 * Return a boolean, true if there is a piece placed on the square, false otherwise.
	 * 
	 * @return a boolean:
	 * <ul>
	 * 		<li> true if there is a piece placed on the square
	 * 		<li> false otherwise
	 * </ul>
	 */
	public boolean isOccupied() {

		return (getPiece() != null);
	}
}
