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
			
			symbol = Constants.B_KING;
		} else {
			
			symbol = Constants.W_KING;
		}
		//eventually there will be introduced other inits
	}
	
	public Vector<Coordinates> reverseMove(Move target){
		
		Vector<Coordinates> possibleSquares = new Vector<Coordinates>();
		
		int endColumn = target.getEndingPos().getColumn();
		int endRow    = target.getEndingPos().getRow();
		
		for(int i = Constants.START_ROW_KING_REVERSE; i < Constants.MAX_ROW_KING_REVERSE; i++) {
			
			for(int j = Constants.START_COL_KING_REVERSE; j < Constants.MAX_COL_KING_REVERSE; j++) {
				
				if(endRow + i > Constants.LAST_ROW || endRow + i < Constants.FIRST_ROW
						|| endColumn + j > Constants.LAST_COLUMN || endColumn + j < Constants.FIRST_COLUMN
						|| (i == 0 && j == 0)) {
					
					continue;
				}
				
				possibleSquares.add(new Coordinates(endColumn + j, endRow + i));
			}
			
		}
		
		return possibleSquares;
	}

}
