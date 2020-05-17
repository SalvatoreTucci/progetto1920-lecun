package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Rook, <br>
 * Class type: Entity <br>
 * 
 * Responsibilities: <br>
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
*/
public final class Rook extends Piece {

	private boolean moved = false;

	// Constructor
	public Rook(final Color col) {

		super(col);

		if (col == Color.BLACK) {

			this.setSymbol(Constants.B_ROOK);
		} else {

			this.setSymbol(Constants.W_ROOK);
		}

	}

	public LinkedList<Coordinates> reverseMove(final Move target) {

		LinkedList<Coordinates> possibleSquares = reverseRookMove(target);

		return possibleSquares;

	}

	/*
	 * Method used to calculate all the possible starting squares in a rook
	 * move, given the ending square
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

	public boolean isMoved() {

		return moved;
	}

	public void setMoved(final boolean hasMoved) {

		this.moved = hasMoved;
	}

}
