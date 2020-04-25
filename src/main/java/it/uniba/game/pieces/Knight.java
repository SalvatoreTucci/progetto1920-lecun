package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;

public final class Knight extends Piece{
	/*
	 * Subclass of Piece representing the Knight, 
	 * the method reverseMove will be extended later
	*/
	
	// Constructor
	public Knight(Color col) {

		super(col);
		
		if (pieceColor == Color.BLACK) {
			
			symbol = Constants.B_KNIGHT;
		} else {
			
			symbol = Constants.W_KNIGHT;
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
