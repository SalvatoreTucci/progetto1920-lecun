package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

public final class King extends Piece {
	/*
	 * Subclass of Piece representing the King, 
	 * the method reverseMove will be extended later
	 * also new attributes could be added
	*/
	
	//Constructor
	public King(Color col) {
		
		super(col);
		
		if (pieceColor == Color.BLACK) {
			
			symbol=Constants.B_KING;
		} else {
			
			symbol=Constants.W_KING;
		}
		//eventually there will be introduced other inits
	}
	
	public Vector<Coordinates> reverseMove(Move endingPos){
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		return possibleSquares;
	}

}
