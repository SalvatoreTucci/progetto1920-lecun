package it.uniba.game.board;

import it.uniba.game.pieces.Piece;

/**
 * Class representing a single square of the chessboard <br>
 * Class type : Entity <br>
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
	/*
	 * This class represents the single square of the chessboard,
	 * where pieces are placed
	*/

	// Attributes
	private Piece placed;

	// Constructor
	public Square(final Piece toPlace) {

		placed = toPlace;
	}

	// Methods
	public Piece getPiece() {

		return placed;
	}

	void setPiece(final Piece toPlace) {

		placed = toPlace;
	}

	public boolean isOccupied() {

		return (getPiece() != null);
	}
}
