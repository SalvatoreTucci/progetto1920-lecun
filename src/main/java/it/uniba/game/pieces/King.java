package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the King <br>
 * Class type: Entity <br>
 * 
 * Responsibilities: <br>
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
*/
public final class King extends Piece {

	private boolean moved = false;

	// Constructor
	public King(final Color col) {

		super(col);

		if (col == Color.BLACK) {

			this.setSymbol(Constants.B_KING);
		} else {

			this.setSymbol(Constants.W_KING);
		}

	}

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

	public boolean isMoved() {

		return moved;
	}

	public void setMoved(final boolean hasMoved) {

		this.moved = hasMoved;
	}

}
