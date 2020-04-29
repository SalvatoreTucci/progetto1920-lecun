package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

public final class Bishop extends Piece {
	/*
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
	
	// Constructor
	public Bishop(Color col) {

		super(col);
		
		if (pieceColor == Color.BLACK) {
			
			symbol = Constants.B_BISHOP;
		} else {
			
			symbol = Constants.W_BISHOP;
		}
		
	}
	
	public Vector<Coordinates> reverseMove(Move target) {
		
		return reverseBishopMove(target);
	}
	
	public static Vector<Coordinates> reverseBishopMove(Move target) {
		 
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		int i = target.getEndingPos().getRow() + 1;
		int j = target.getEndingPos().getColumn() + 1;
		
		while (i <= Constants.LAST_ROW && j <= Constants.LAST_COLUMN) {
			
			possibleSquares.add(new Coordinates(j, i));
			j++;
			i++;
		} 
		
		i = target.getEndingPos().getRow() - 1;
		j = target.getEndingPos().getColumn() - 1;
		
		while (i>= Constants.FIRST_ROW && j >= Constants.FIRST_COLUMN) {
			
			possibleSquares.add(new Coordinates(j, i));
			j--;
			i--;
		} 
		
		i = target.getEndingPos().getRow() + 1;
		j = target.getEndingPos().getColumn() - 1;
		
		while (i <= Constants.LAST_ROW && j >= Constants.FIRST_COLUMN) {
			
			possibleSquares.add(new Coordinates(j, i));
			j--;
			i++;
		} 
		
		i = target.getEndingPos().getRow() - 1;
		j = target.getEndingPos().getColumn() + 1;
		
		while (i>= Constants.FIRST_ROW  && j <= Constants.LAST_COLUMN) {
			
			possibleSquares.add(new Coordinates(j, i));
			j++;
			i--;
		} 
		
		
		return possibleSquares;
	}

}
