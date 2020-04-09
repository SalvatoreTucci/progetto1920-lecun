package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;

public final class Rook extends Piece{
	/*
	 * Subclass of Piece representing the Bishop, 
	 * the method reverseMove will be extended later
	*/
	
	//Constructor
	public Rook(Color col) {
		
		super(col);
		if (pieceColor == Color.BLACK) {
			
			symbol=Constants.B_ROOK;
		} else {
			
			symbol=Constants.W_ROOK;
		}
		
	}
	
	public Vector<it.uniba.game.Coordinates> reverseMove(it.uniba.game.Coordinates endingPos){
		
		Vector<it.uniba.game.Coordinates> possibleSquares = new Vector<it.uniba.game.Coordinates>();
		
		return possibleSquares;
	}

}
