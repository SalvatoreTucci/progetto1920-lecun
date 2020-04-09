package it.uniba.game.pieces;

import java.util.Vector;

public final class King extends Piece {
	/*
	 * Subclass of Piece representing the King, 
	 * the method reverseMove will be extended later
	 * also new attributes could be added
	*/
	
	//Constructor
	public King(Color col) {
		
		super(col);
		
		if (col == Color.BLACK) {
			
			symbol="♚";
		} else {
			
			symbol="♔";
		}
		//eventually there will be introduced other inits
	}
	
	public Vector<it.uniba.game.Coordinates> reverseMove(it.uniba.game.Coordinates endingPos){
		
		Vector<it.uniba.game.Coordinates> possibleSquares = new Vector<it.uniba.game.Coordinates>();
		
		return possibleSquares;
	}

}
