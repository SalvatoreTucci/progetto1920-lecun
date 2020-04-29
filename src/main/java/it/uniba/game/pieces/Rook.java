package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Rook, 
 * Class type: <<Entity>>
 * 
 * Responsibilities:
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
	public Rook(Color col) {
		
		super(col);
		
		if (pieceColor == Color.BLACK) {
			
			symbol = Constants.B_ROOK;
		} else {
			
			symbol = Constants.W_ROOK;
		}
	}
	
	public Vector<Coordinates> reverseMove(Move target) {
		
		Vector<Coordinates> possibleSquares = reverseRookMove(target);
		
		return possibleSquares;
	}
	
	/*
	 * Method used to calculate all the possible starting squares in a rook
	 * move, given the ending square
	 */
	public static Vector<Coordinates> reverseRookMove(Move target) {
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		int row = target.getEndingPos().getRow();
		int col = target.getEndingPos().getColumn();
		
		for(int i = 0; i <= Constants.LAST_ROW; i++) {
			
			if(i != col) {
				
				possibleSquares.add(new Coordinates(i, row));
			}
			
			if(i != row) {
				
				possibleSquares.add(new Coordinates(col, i));
			}
			
		}
		
		return possibleSquares;
	}
	
	public boolean isMoved() {
		
		return moved;
	}

	public void setMoved(boolean moved) {
		
		this.moved = moved;
	}

}
