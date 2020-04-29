package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;

/**
 * Subclass of Piece representing the Knight
 * Class type: <<Entity>>
 * 
 * Responsibilities:
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
*/
public final class Knight extends Piece{	
	
	// Constructor
	public Knight(Color col) {

		super(col);
		
		if (col == Color.BLACK) {
			
			this.setSymbol(Constants.B_KNIGHT);
		} else {
			
			this.setSymbol(Constants.W_KNIGHT);
		}
		
	}
	
	public Vector<Coordinates> reverseMove(Move target) {
		
		return reverseKnightMove(target);
	}
	
	public static Vector<Coordinates> reverseKnightMove(Move target) {
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		int endingR = target.getEndingPos().getRow();
		int endingC = target.getEndingPos().getColumn();
		
		if (endingR + 1 <= Constants.LAST_ROW) {
			
			if (endingC + 2 <= Constants.LAST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC + 2, endingR +1 ) );
			}
			if (endingC - 2 >= Constants.FIRST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC - 2, endingR + 1) );
			}
			
			if (endingR + 2 <= Constants.LAST_ROW) {
				
				if (endingC + 1 <= Constants.LAST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC + 1, endingR + 2) );
				}
				if (endingC - 1 >= Constants.FIRST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC - 1, endingR + 2) );
				}
			}
		
		}
		
		if (endingR - 1 >= Constants.FIRST_ROW) {
			
			if (endingC + 2 <= Constants.LAST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC + 2, endingR - 1) );
			}
			if (endingC - 2 >= Constants.FIRST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC - 2, endingR - 1) );
			}
			
			if (endingR - 2 >= Constants.FIRST_ROW) {
				
				if (endingC + 1 <= Constants.LAST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC + 1, endingR - 2) );
				}
				if (endingC - 1 >= Constants.FIRST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC - 1, endingR - 2) );
				}
			}
		
		}
		return possibleSquares;
	}
	
	
}
