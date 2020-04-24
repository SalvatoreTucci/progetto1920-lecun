package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

public final class Rook extends Piece {
	/*
	 * Subclass of Piece representing the Bishop, 
	 * the method reverseMove will be extended later
	*/
	
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
	static Vector<Coordinates> reverseRookMove(Move target) {
		
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

}
