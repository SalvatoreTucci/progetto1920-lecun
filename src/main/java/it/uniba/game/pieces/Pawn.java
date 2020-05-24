package it.uniba.game.pieces;

import java.util.LinkedList;

import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Pawn <br>
 * Class type: &#60; Entity &#62; <br><br>
 * 
 * Responsibilities: <br>
 * 
 * 	Knows:
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the Pawn</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Pawn could
 * 			possibly be found, given the
 * 			target position</li>
 * 		</ul>
 * 
 * @author LeCun group <br>
*/



public final class Pawn extends Piece {


	/**
	 * Constructor for the class Pawn. It initializes the piece's color and symbol,
	 * If <code>col==null</code> then the set color is Color.WHITE and the symbol
	 * is Constants.W_PAWN.
	 * 
	 * @param col color of the piece.
	 */
	public Pawn(final Color col) {

		super(col);

		if (col == Piece.Color.BLACK) {

			this.setSymbol(Constants.B_PAWN);
		} else {

			this.setSymbol(Constants.W_PAWN);
		}

	}

	/**
	 * Method returning all the possible starting position of a pawn on a chessboard
	 * given the ending position in a List. If the ending position exceeds the bounds of the
	 * chessboard (from (0,0) to (7,7)), the returned list is empty. The method assumes
	 * that <code>target</code> is a pawn move. Also it checks if the move is a capture or not.
	 * 
	 * @param target The move of a pawn, which starting position has to be determined.
	 * 
	 * @return A LinkedList of possible starting Coordinates of a pawn.
	 * 
	 */
	public LinkedList<Coordinates> reverseMove(final Move target) {

		LinkedList<Coordinates> startingPos = new LinkedList<Coordinates>();

		if (checkOutOfBound(target)) {

			return startingPos;
		}

		/*
		 * If the color is BLACK, you can move the pawn down, so the starting position can be found
		 * 	by moving in the UP_DIRECTION, otherwise, if the color is WHITE,
		 *  by moving in the DOWN_DIRECTION.
		 */
		int addInRow;

		if (this.getColor() == Piece.Color.BLACK) {

			addInRow = Constants.UP_DIRECTION;
		} else {

			addInRow = Constants.DOWN_DIRECTION;
		}

		/*
		 * If the color is BLACK, you can move the pawn, the first time, to the row B_MID_ROW
		 * If the color is WHITE, you can move the pawn, the first time, to the row W_MID_ROW
		 */
		int initialMoveRow;

		if (this.getColor() == Piece.Color.BLACK) {

			initialMoveRow = Constants.B_MID_ROW;
		} else {

			initialMoveRow = Constants.W_MID_ROW;
		}

		// Check if the pawn is moving in the right direction
		if ((this.getColor() == Piece.Color.BLACK
				&& target.getEndingPos().getRow() == Constants.FIRST_ROW)
				|| (this.getColor() == Piece.Color.WHITE
				&& target.getEndingPos().getRow() == Constants.LAST_ROW)) {

			return startingPos;
		}

		if (!target.getCaptureFlag()) {
			// Add the basic movement of the pawn
			startingPos.add(new Coordinates(target.getEndingPos().getColumn(),
					target.getEndingPos().getRow() + addInRow));


			// If the ending position has the row B_MID_ROW or W_MID_ROW,
			// add the initial movement of the pawn (2 square up or down)
			if (target.getEndingPos().getRow() == initialMoveRow) {

				startingPos.add(new Coordinates(target.getEndingPos().getColumn(),
						target.getEndingPos().getRow() + (addInRow * 2)));
			}

		} else {
			/*
			 * If the ending position has the column > FIRST_ROW,
			 *   we add the normal capture of the pawn on the left
			 * 
			 * If the ending position has the column < LAST_ROW,
			 *   we add the normal capture of the pawn on the right
			 */
			if (target.getEndingPos().getColumn() > Constants.FIRST_ROW) {

				startingPos.add(new Coordinates(target.getEndingPos().getColumn() - 1,
						target.getEndingPos().getRow() + addInRow));
			}

			if (target.getEndingPos().getColumn() < Constants.LAST_ROW) {

				startingPos.add(new Coordinates(target.getEndingPos().getColumn() + 1,
						target.getEndingPos().getRow() + addInRow));
			}
		}

		return startingPos;
	}
}
