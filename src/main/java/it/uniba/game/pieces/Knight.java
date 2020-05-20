package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;

/**
 * Subclass of Piece representing the Knight <br>
 * Class type: &#60;Entity&#62; <br>
 * 
 * Responsibilities: <br><br>
 * 
 * 	Knows:
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the Knight</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Knight could
 * 			possibly be found, given the
 * 			target position</li>
 * 		</ul>
 * 
 * @author LeCun group <br>
*/



public final class Knight extends Piece {

	/**
	 * Constructor for the class Knight. It initializes the piece's color and symbol.
	 * If <code>col==null</code> then the set color is Color.WHITE and the symbol 
	 * is Constants.W_KNIGHT
	 * .
	 * @param col color of the piece. 
	 */
	public Knight(final Color col) {

		super(col);

		if (col == Color.BLACK) {

			this.setSymbol(Constants.B_KNIGHT);
		} else {

			this.setSymbol(Constants.W_KNIGHT);
		}

	}

	/**
	 * Wrapper method for the class method <i>reverseKnightMove</i>.
	 * 
	 * @param target The move of a knight, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a knight.
	 * 
	 */
	public LinkedList<Coordinates> reverseMove(final Move target) {

		return reverseKnightMove(target);
	}

	/**
	 * Method returning all the possible starting position of a knight on a chessboard
	 * given the ending position in a List. If the ending position exceeds the bounds of the 
	 * chessboard (from (0,0) to (7,7)), the returned list is empty. The method assumes
	 * that <code>target</code> is a knight move.
	 * 
	 * @param target The move of a knight, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a knight.
	 * 
	 */
	public static LinkedList<Coordinates> reverseKnightMove(final Move target) {

		LinkedList<Coordinates> possibleSquares = new LinkedList<Coordinates>();

		if (checkOutOfBound(target)) {

			return possibleSquares;
		}

		int endingR = target.getEndingPos().getRow();
		int endingC = target.getEndingPos().getColumn();

		if (endingR + Constants.DOWN_DIRECTION <= Constants.LAST_ROW) {

			if (endingC + Constants.KN_RIGHT_DIRECTION <= Constants.LAST_COLUMN) {

				possibleSquares.add(new Coordinates(endingC + Constants.KN_RIGHT_DIRECTION,
						endingR + Constants.DOWN_DIRECTION));

			}

			if (endingC + Constants.KN_LEFT_DIRECTION >= Constants.FIRST_COLUMN) {

				possibleSquares.add(new Coordinates(endingC + Constants.KN_LEFT_DIRECTION,
						endingR + Constants.DOWN_DIRECTION));

			}


			if (endingR + Constants.KN_DOWN_DIRECTION <= Constants.LAST_ROW) {

				if (endingC + Constants.RIGHT_DIRECTION <= Constants.LAST_COLUMN) {

					possibleSquares.add(new Coordinates(endingC + Constants.RIGHT_DIRECTION,
							endingR + Constants.KN_DOWN_DIRECTION));

				}

				if (endingC + Constants.LEFT_DIRECTION >= Constants.FIRST_COLUMN) {

					possibleSquares.add(new Coordinates(endingC + Constants.LEFT_DIRECTION,
							endingR + Constants.KN_DOWN_DIRECTION));

				}

			}

		}

		if (endingR + Constants.UP_DIRECTION >= Constants.FIRST_ROW) {

			if (endingC + Constants.KN_RIGHT_DIRECTION <= Constants.LAST_COLUMN) {

				possibleSquares.add(new Coordinates(endingC + Constants.KN_RIGHT_DIRECTION,
						endingR + Constants.UP_DIRECTION));

			}

			if (endingC + Constants.KN_LEFT_DIRECTION >= Constants.FIRST_COLUMN) {

				possibleSquares.add(new Coordinates(endingC + Constants.KN_LEFT_DIRECTION,
						endingR + Constants.UP_DIRECTION));

			}


			if (endingR + Constants.KN_UP_DIRECTION >= Constants.FIRST_ROW) {

				if (endingC + Constants.RIGHT_DIRECTION <= Constants.LAST_COLUMN) {

					possibleSquares.add(new Coordinates(endingC + Constants.RIGHT_DIRECTION,
							endingR + Constants.KN_UP_DIRECTION));

				}

				if (endingC + Constants.LEFT_DIRECTION >= Constants.FIRST_COLUMN) {

					possibleSquares.add(new Coordinates(endingC + Constants.LEFT_DIRECTION,
							endingR + Constants.KN_UP_DIRECTION));

				}

			}

		}


		return possibleSquares;
	}

}
