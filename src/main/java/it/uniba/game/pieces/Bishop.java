package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

public final class Bishop extends Piece {
	/*
	 * Subclass of Piece representing the Bishop, 
	 * the method reverseMove will be extended later
	*/
	
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
