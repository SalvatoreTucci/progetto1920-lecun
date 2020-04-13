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
	
	//Constructor
	public Bishop(Color col) {

		super(col);
		
		if(pieceColor == Color.BLACK) {
			
			symbol = Constants.B_BISHOP;
		} else {
			
			symbol = Constants.W_BISHOP;
		}
	}
	
	public Vector<Coordinates> reverseMove(Move target) {
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		return possibleSquares;
	}
	
}
