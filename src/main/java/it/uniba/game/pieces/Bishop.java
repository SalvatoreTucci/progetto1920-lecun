package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Bishop
 * Class type: <<Entity>>
 * 
 * Responsibilities:
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
*/
public final class Bishop extends Piece {
	
	// Constructor
	public Bishop(Color col) {

		super(col);
		
		if (col == Color.BLACK) {
			
			this.setSymbol(Constants.B_BISHOP);
		} else {
			
			this.setSymbol(Constants.W_BISHOP);
		}
		
	}
	
	public Vector<Coordinates> reverseMove(Move target) {
		
		return reverseBishopMove(target);
	}
	
	public static Vector<Coordinates> reverseBishopMove(Move target) {
		 
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		int i = target.getEndingPos().getRow() + Constants.RIGHT_DIRECTION;
		int j = target.getEndingPos().getColumn() + Constants.DOWN_DIRECTION;
		
		while (i <= Constants.LAST_ROW && j <= Constants.LAST_COLUMN) {
			
			possibleSquares.add(new Coordinates(j, i));
			j++;
			i++;
		} 
		
		i = target.getEndingPos().getRow() + Constants.LEFT_DIRECTION;
		j = target.getEndingPos().getColumn() + Constants.UP_DIRECTION;
		
		while (i>= Constants.FIRST_ROW && j >= Constants.FIRST_COLUMN) {
			
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
		
		while (i>= Constants.FIRST_ROW  && j <= Constants.LAST_COLUMN) {
			
			possibleSquares.add(new Coordinates(j, i));
			j++;
			i--;
		} 
		
		
		return possibleSquares;
	}

}
