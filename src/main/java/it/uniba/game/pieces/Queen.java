package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Queen <br>
 * Class type: &#60; Entity &#62; <br><br>
 * 
 * Responsibilities: <br>
 * 
 * 	Knows:
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the Queen</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Queen could
 * 			possibly be found, given the
 * 			target position</li>
 * 		</ul>
 * 
 * @author LeCun group <br>
*/



public final class Queen extends Piece {

	/**
	 * Constructor for the class Queen. It initializes the piece's color and symbol,
	 * If <code>col==null</code> then the set color is Color.WHITE and the symbol
	 * is Constants.W_QUEEN.
	 * 
	 * @param col color of the piece.
	 */
	public Queen(final Color col) {

		super(col);

		if (col == Color.BLACK) {

			this.setSymbol(Constants.B_QUEEN);
		} else {

			this.setSymbol(Constants.W_QUEEN);
		}

	}

	/**
	 * Method returning all the possible starting position of a queen on a chessboard
	 * given the ending position in a List. If the ending position exceeds the bounds of the
	 * chessboard (from (0,0) to (7,7)), the returned list is empty. The method assumes
	 * that <code>target</code> is a queen move. Also it checks if the move is a capture or not.
	 * 
	 * @param target The move of a pawn, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a queen.
	 * 
	 */
	public LinkedList<Coordinates> reverseMove(final Move target) {
		/*
		 *  The starting position of the Queen can be traced through the same checks done
		 *  for the Rook and the Bishop
		 */

		LinkedList<Coordinates> possibleSquares = Rook.reverseRookMove(target);

		possibleSquares.addAll(Bishop.reverseBishopMove(target));

		return possibleSquares;
	}

}
