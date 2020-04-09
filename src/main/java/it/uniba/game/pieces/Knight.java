package it.uniba.game.pieces;

import java.util.Vector;

public final class Knight extends Piece{
	/*
	 * Subclass of Piece representing the Knight, 
	 * the method reverseMove will be extended later
	*/
	
	//Constructor
	public Knight(Color col) {

		super(col);
		
		if(pieceColor == Color.BLACK) {
			
			symbol = "♞";
		} else {
			
			symbol = "♘";
		}
	}
	
	public Vector<it.uniba.game.Coordinates> reverseMove(it.uniba.game.Coordinates endingPos) {
		
		Vector<it.uniba.game.Coordinates> possibleSquares = new Vector<it.uniba.game.Coordinates>();
		
		return possibleSquares;
	}
	
}
