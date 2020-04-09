package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.*;



class Pawn extends Piece {
	/*
	 * Subclass of Piece representing the Pawn
	 */
	
	
	// Constructor
	public Pawn(Color col) {
		
		super(col);
		
		if(col == Piece.Color.BLACK) {
			this.symbol = "♟";
			
		}
		else {
			this.symbol = "♙";
			
		}
		
	}
	
	public Vector<Coordinates> reverseMove(Coordinates endingPos) {
		
		Vector<Coordinates> startingPos = new Vector<Coordinates>();
		
		/*
		 * If the color is BLACK, you can move the pawn down, so it will be - 1
		 * If the color is WHITE, you can move the pawn up, so it will be + 1
		 */
		int addInRow = (pieceColor == Piece.Color.BLACK) ? -1 : 1;
		
		/*
		 * If the color is BLACK, you can move the pawn, the first time, to the row 3
		 * If the color is WHITE, you can move the pawn, the first time, to the row 4
		 */
		int initialMoveRow = (pieceColor == Piece.Color.BLACK) ? 3 : 4; 
		
		// Check if the pawn is moving in the right direction
		if((pieceColor == Piece.Color.BLACK && endingPos.getRow() == 0) ||
				(pieceColor == Piece.Color.WHITE && endingPos.getRow() == 7)) {
			return startingPos;
			
		}
		
		// Add the bamovement of the pawn
		startingPos.add(new Coordinates(endingPos.getColumn(), endingPos.getRow() + addInRow));
		
		// If the ending position has the row 3, add the initial movement of the pawn (2 square up or down)
		if(endingPos.getRow() == initialMoveRow) {
			startingPos.add(new Coordinates(endingPos.getColumn(), endingPos.getRow() + (addInRow * 2)));
			
		}
		
		/* 
		 * If the ending position has the column > 0, we add the normal capture of the pawn on the left
		 * If the ending position has the column < 7, we add the normal capture of the pawn on the right
		 * In each of the two cases, if the row's ending position is 3, we add the capture 'en passant' of the pawn
		 */
		if(endingPos.getColumn() > 0) {
			startingPos.add(new Coordinates(endingPos.getColumn() - 1, endingPos.getRow() + addInRow));
			if(endingPos.getRow() == initialMoveRow) {
				startingPos.add(new Coordinates(endingPos.getColumn() - 1, endingPos.getRow() + (addInRow * 2)));
			
			}
			
		}
		else if(endingPos.getColumn() < 7) {
			startingPos.add(new Coordinates(endingPos.getColumn() + 1, endingPos.getRow() + addInRow));
			if(endingPos.getRow() == initialMoveRow) {
				startingPos.add(new Coordinates(endingPos.getColumn() + 1, endingPos.getRow() + (addInRow * 2)));
				
			}
		}
		
		return startingPos;
	}
	
	
}
