package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Constants;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;

/**
 * Subclass of Piece representing the Knight <br>
 * Class type: Entity <br>
 * 
 * Responsibilities: <br>
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
	
	public LinkedList<Coordinates> reverseMove(Move target) {
		
		return reverseKnightMove(target);
	}
	
	public static LinkedList<Coordinates> reverseKnightMove(Move target) {
		
		LinkedList<Coordinates> possibleSquares = new LinkedList<Coordinates>();
		
		int endingR = target.getEndingPos().getRow();
		int endingC = target.getEndingPos().getColumn();
		
		if (endingR + Constants.DOWN_DIRECTION <= Constants.LAST_ROW) {
			
			if (endingC + Constants.KN_RIGHT_DIRECTION <= Constants.LAST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC + Constants.KN_RIGHT_DIRECTION,
						endingR + Constants.DOWN_DIRECTION ));
				
			}
			if (endingC + Constants.KN_LEFT_DIRECTION >= Constants.FIRST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC + Constants.KN_LEFT_DIRECTION, 
						endingR + Constants.DOWN_DIRECTION));
				
			}
			
			if (endingR + Constants.KN_DOWN_DIRECTION <= Constants.LAST_ROW) {
				
				if (endingC + Constants.RIGHT_DIRECTION <= Constants.LAST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC + Constants.RIGHT_DIRECTION, 
							endingR + Constants.KN_DOWN_DIRECTION));
					
				}
				if (endingC + Constants.LEFT_DIRECTION >= Constants.FIRST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC + Constants.LEFT_DIRECTION, 
							endingR + Constants.KN_DOWN_DIRECTION));
					
				}
			}
		
		}
		
		if (endingR + Constants.UP_DIRECTION >= Constants.FIRST_ROW) {
			
			if (endingC + Constants.KN_RIGHT_DIRECTION <= Constants.LAST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC + Constants.KN_RIGHT_DIRECTION, 
						endingR + Constants.UP_DIRECTION));
				
			}
			if (endingC + Constants.KN_LEFT_DIRECTION >= Constants.FIRST_COLUMN) {
				
				possibleSquares.add( new Coordinates(endingC + Constants.KN_LEFT_DIRECTION, 
						endingR + Constants.UP_DIRECTION));
				
			}
			
			if (endingR + Constants.KN_UP_DIRECTION >= Constants.FIRST_ROW) {
				
				if (endingC + Constants.RIGHT_DIRECTION <= Constants.LAST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC + Constants.RIGHT_DIRECTION, 
							endingR + Constants.KN_UP_DIRECTION));
					
				}
				if (endingC + Constants.LEFT_DIRECTION >= Constants.FIRST_COLUMN) {
					
					possibleSquares.add( new Coordinates(endingC + Constants.LEFT_DIRECTION,
							endingR + Constants.KN_UP_DIRECTION));
					
				}
			}
		
		}
		return possibleSquares;
	}
	
	
}
