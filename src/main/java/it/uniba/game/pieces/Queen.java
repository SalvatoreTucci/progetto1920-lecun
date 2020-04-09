package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;

public final class Queen extends Piece {
	/*
	 * Subclass of Piece representing the Queen, 
	 * the method reverseMove will be extended later
	*/
	
	//Constructor
	public Queen(Color col) {
		
		super(col);
		
		if (pieceColor == Color.BLACK) {
			
			symbol = Constants.B_QUEEN;
		} else {
			
			symbol = Constants.W_QUEEN;	
		}
		
	}
	
	public Vector<it.uniba.game.Coordinates> reverseMove(it.uniba.game.Coordinates endingPos){
		
		Vector<it.uniba.game.Coordinates> possibleSquares = new Vector<it.uniba.game.Coordinates>();
		
		return possibleSquares;
	}
	
}
