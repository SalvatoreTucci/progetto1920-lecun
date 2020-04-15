package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

public final class Queen extends Piece {
	/*
	 * Subclass of Piece representing the Queen, 
	 * the method reverseMove will be extended later
	*/
	
	// Constructor
	public Queen(Color col) {
		
		super(col);
		
		if (pieceColor == Color.BLACK) {
			
			symbol = Constants.B_QUEEN;
		} else {
			
			symbol = Constants.W_QUEEN;	
		}
		
	}
	
	public Vector<Coordinates> reverseMove(Move target){
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		return possibleSquares;
	}
	
}
