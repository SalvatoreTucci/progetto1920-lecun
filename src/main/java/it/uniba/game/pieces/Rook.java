package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Rook, <br>
 * Class type: &#60;Entity&#62; <br>
 * 
 * Responsibilities: <br><br>
 * 
 * 	Knows:
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the Rook</li>
 * 		<li>If an instance of a Rook has been moved</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Rook could
 * 			possibly be found, given the
 * 			target position</li>
 * 		<li>Reports if an instance of Rook has been moved</li>
 * 		</ul>
 * 
 * @author LeCun group <br>
*/



public final class Rook extends Piece {

	/**
	 * <code>boolean</code> indicating whether the piece has been moved for the first time.
	 * It's an important information for the <i>castling</i> moves.
	 * It is initialized as <code>false</code>.
	 */
	private boolean moved = false;

	/**
	 * Constructor for the class rook. It initializes the piece's color and symbol,
	 * If <code>col==null</code> then the set color is Color.WHITE and the symbol 
	 * is Constants.W_ROOK.
	 * 
	 * @param col color of the piece. 
	 */
	public Rook(final Color col) {

		super(col);

		if (col == Color.BLACK) {

			this.setSymbol(Constants.B_ROOK);
		} else {

			this.setSymbol(Constants.W_ROOK);
		}

	}

	/**
	 * Wrapper method for the class method <i>reverseRookMove</i>.
	 * 
	 * @param target The move of a rook, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a rook.
	 * 
	 */
	public LinkedList<Coordinates> reverseMove(final Move target) {

		LinkedList<Coordinates> possibleSquares = reverseRookMove(target);

		return possibleSquares;

	}

	/**
	 * Method returning all the possible starting position of a rook on a chessboard
	 * given the ending position in a List. If the ending position exceeds the bounds of the 
	 * chessboard (from (0,0) to (7,7)), the returned list is empty. The method assumes
	 * that <code>target</code> is a rook move.
	 * 
	 * @param target The move of a rook, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a rook.
	 * 
	 */
	public static LinkedList<Coordinates> reverseRookMove(final Move target) {

		LinkedList<Coordinates> possibleSquares = new LinkedList<Coordinates>();

		if (checkOutOfBound(target)) {

			return possibleSquares;
		}

		int row = target.getEndingPos().getRow();
		int col = target.getEndingPos().getColumn();

		for (int i = 0; i <= Constants.LAST_ROW; i++) {

			if (i != col) {

				possibleSquares.add(new Coordinates(i, row));
			}

			if (i != row) {

				possibleSquares.add(new Coordinates(col, i));
			}

		}


		return possibleSquares;
	}

	/**
	 * Method returning the status of a rook piece.
	 * 
	 * @return true if the rook has been moved, false otherwise
	 */
	public boolean isMoved() {

		return moved;
	}

	/**
	 * Method setting the status of a rook piece.
	 * 
	 * @param hasMoved boolean indicating whether the rook has been moved (true) or not (false)
	 * 		  for the first time, to set
	 */
	public void setMoved(final boolean hasMoved) {

		this.moved = hasMoved;
	}

}
