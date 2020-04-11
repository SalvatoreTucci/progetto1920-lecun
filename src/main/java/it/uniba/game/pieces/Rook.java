package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

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
	
	public Vector<Coordinates> reverseMove(Move endingPos){
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		return possibleSquares;
	}

}
