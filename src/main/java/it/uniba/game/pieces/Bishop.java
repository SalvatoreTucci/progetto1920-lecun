package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Bishop <br>
 * Class type: &#60;Entity&#62; <br><br>
 * 
 * Responsibilities: <br>
 * 
 * 	Knows:
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the Bishop</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Bishop could
 * 			possibly be found, given the
 * 			target position</li>
 * 		</ul>
 * 
 * @author LeCun group <br>
*/



public final class Bishop extends Piece {

	/**
	 * Constructor for the class Bishop. It initializes the piece's color and symbol.
	 * If <code>col==null</code> then the set color is Color.WHITE and the symbol
	 * is Constants.W_BISHOP.
	 * 
	 * @param col color of the piece.
	 */
	public Bishop(final Color col) {

		super(col);

		if (col == Color.BLACK) {

			this.setSymbol(Constants.B_BISHOP);
		} else {

			this.setSymbol(Constants.W_BISHOP);
		}

	}

	/**
	 * Wrapper method for the class method <i>reverseBishopMove</i>.
	 * 
	 * @param target The move of a bishop, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a bishop.
	 * 
	 */
	public LinkedList<Coordinates> reverseMove(final Move target) {

		return reverseBishopMove(target);
	}

	/**
	 * Method returning all the possible starting position of a bishop on a chessboard
	 * given the ending position in a List. If the ending position exceeds the bounds of the
	 * chessboard (from (0,0) to (7,7)), the returned list is empty. The method assumes
	 * that <code>target</code> is a bishop move.
	 * 
	 * @param target The move of a bishop, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a bishop.
	 * 
	 */
	public static LinkedList<Coordinates> reverseBishopMove(final Move target) {

		LinkedList<Coordinates> possibleSquares = new LinkedList<Coordinates>();

		if (checkOutOfBound(target)) {

			return possibleSquares;
		}

		int i = target.getEndingPos().getRow() + Constants.RIGHT_DIRECTION;
		int j = target.getEndingPos().getColumn() + Constants.DOWN_DIRECTION;

		while (i <= Constants.LAST_ROW && j <= Constants.LAST_COLUMN) {

			possibleSquares.add(new Coordinates(j, i));
			j++;
			i++;

		}

		i = target.getEndingPos().getRow() + Constants.LEFT_DIRECTION;
		j = target.getEndingPos().getColumn() + Constants.UP_DIRECTION;

		while (i >= Constants.FIRST_ROW && j >= Constants.FIRST_COLUMN) {

			possibleSquares.add(new Coordinates(j, i));
			j--;
			i--;

		}

		i = target.getEndingPos().getRow() + Constants.RIGHT_DIRECTION;
		j = target.getEndingPos().getColumn() + Constants.UP_DIRECTION;

		while (i <= Constants.LAST_ROW && j >= Constants.FIRST_COLUMN) {

			possibleSquares.add(new Coordinates(j, i));
			j--;
			i++;

		}

		i = target.getEndingPos().getRow() + Constants.LEFT_DIRECTION;
		j = target.getEndingPos().getColumn() + Constants.DOWN_DIRECTION;

		while (i >= Constants.FIRST_ROW  && j <= Constants.LAST_COLUMN) {

			possibleSquares.add(new Coordinates(j, i));
			j++;
			i--;

		}


		return possibleSquares;
	}

}
