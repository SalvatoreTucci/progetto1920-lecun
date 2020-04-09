package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.*;



class Pawn extends Piece {
	// Pawn class
	
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
		
		// Add the basic movement of the pawn
		startingPos.add(new Coordinates(endingPos.getRow() + addInRow, endingPos.getColumn()));
		
		// If the ending position has the row 3, add the initial movement of the pawn (2 square up or down)
		if(endingPos.getRow() == 3) {
			startingPos.add(new Coordinates(endingPos.getRow() + (addInRow * 2), endingPos.getColumn()));
			
		}
		
		/* 
		 * If the ending position has the column > 0, we add the normal capture of the pawn on the left
		 * If the ending position has the column < 7, we add the normal capture of the pawn on the right
		 * In each of the two cases, if the row's ending position is 3, we add the capture 'en passant' of the pawn
		 */
		if(endingPos.getColumn() > 0) {
			startingPos.add(new Coordinates(endingPos.getRow() + addInRow, endingPos.getColumn() - 1));
			if(endingPos.getRow() == 3) {
				startingPos.add(new Coordinates(endingPos.getRow() + (addInRow * 2), endingPos.getColumn() - 1));
			
			}
			
		}
		else if(endingPos.getColumn() < 7) {
			startingPos.add(new Coordinates(endingPos.getRow() + addInRow, endingPos.getColumn() + 1));
			if(endingPos.getRow() == 3) {
				startingPos.add(new Coordinates(endingPos.getRow() + (addInRow * 2), endingPos.getColumn() + 1));
				
			}
		}
		
		return startingPos;
	}
	
	
}
