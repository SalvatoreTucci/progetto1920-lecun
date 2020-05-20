package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the King <br>
 * Class type: &#60;Entity&#62; <br>
 * 
 * Responsibilities: <br><br>
 * 
 * 	Knows:
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the King</li>
 * 		<li>If an instance of a King has been moved</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a King could
 * 			possibly be found, given the
 * 			target position</li>
 * 		<li>Reports if an instance of King has been moved</li>
 * 		</ul>
 * 
 * @author LeCun group <br>
*/



public final class King extends Piece {

	/**
	 * <code>boolean</code> indicating whether the piece has been moved for the first time.
	 * It's an important information for the <i>castling</i> moves.
	 * It is initialized as <code>false</code>.
	 */
	private boolean moved = false;

	/**
	 * Constructor for the class King. It initializes the piece's color and symbol.
	 * If <code>col==null</code> then the set color is Color.WHITE and the symbol
	 * is Constants.W_KING.
	 * 
	 * @param col color of the piece.
	 */
	public King(final Color col) {

		super(col);

		if (col == Color.BLACK) {

			this.setSymbol(Constants.B_KING);
		} else {

			this.setSymbol(Constants.W_KING);
		}

	}

	/**
	 * Method returning all the possible starting position of a king on a chessboard
	 * given the ending position in a List. If the ending position exceeds the bounds of the
	 * chessboard (from (0,0) to (7,7)), the returned list is empty. The method assumes
	 * that <code>target</code> is a king move.
	 * 
	 * @param target The move of a king, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a king.
	 * 
	 */
	public LinkedList<Coordinates> reverseMove(final Move target) {

		LinkedList<Coordinates> possibleSquares = new LinkedList<Coordinates>();

		if (checkOutOfBound(target)) {

			return possibleSquares;
		}

		int endColumn = target.getEndingPos().getColumn();
		int endRow    = target.getEndingPos().getRow();

		for (int i = Constants.START_ROW_KING_REVERSE; i <= Constants.MAX_ROW_KING_REVERSE; i++) {

			for (int j = Constants.START_COL_KING_REVERSE; j <= Constants.MAX_COL_KING_REVERSE; j++) {

				if (endRow + i > Constants.LAST_ROW
						|| endRow + i < Constants.FIRST_ROW
						|| endColumn + j > Constants.LAST_COLUMN
						|| endColumn + j < Constants.FIRST_COLUMN
						|| (i == 0 && j == 0)) {

					continue;
				}

				possibleSquares.add(new Coordinates(endColumn + j, endRow + i));

			}

		}


		return possibleSquares;

	}

	/**
	 * Method returning the status of a king piece.
	 * 
	 * @return true if the king has been moved, false otherwise
	 */
	public boolean isMoved() {

		return moved;
	}

	/**
	 * Method setting the status of a king piece.
	 * 
	 * @param hasMoved boolean indicating whether the king has been moved (true) or not (false)
	 * 		  for the first time, to set
	 */
	public void setMoved(final boolean hasMoved) {

		this.moved = hasMoved;
	}

}
