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
	
	//Constructor
	public Knight(Color col) {

		super(col);
		
		if(pieceColor == Color.BLACK) {
			
			symbol = Constants.B_KNIGHT;
		} else {
			
			symbol = Constants.W_KNIGHT;
		}
	}
	
	public Vector<Coordinates> reverseMove(Move target) {
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		return possibleSquares;
	}
	
}
