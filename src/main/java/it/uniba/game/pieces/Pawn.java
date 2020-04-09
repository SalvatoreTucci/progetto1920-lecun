package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.*;


public final class Pawn extends Piece {
	/*
	 * Subclass of Piece representing the Pawn
	 */
	private boolean enPassant;
	
	// Constructor
	public Pawn(Color col) {
		
		super(col);
		
		if(col == Piece.Color.BLACK) {
			this.symbol = Constants.B_PAWN;
			
		}
		else {
			this.symbol = Constants.W_PAWN;
			
		}
		
		enPassant = false;
		
	}
	
	public Vector<Coordinates> reverseMove(Coordinates endingPos) {
		
		Vector<Coordinates> startingPos = new Vector<Coordinates>();
		
		/*
		 * If the color is BLACK, you can move the pawn down, so it will be B_DIRECTION_ROW
		 * If the color is WHITE, you can move the pawn up, so it will be W_DIRECTION_ROW
		 */
		int addInRow = (pieceColor == Piece.Color.BLACK) ? Constants.B_DIRECTION_ROW : Constants.W_DIRECTION_ROW;
		
		/*
		 * If the color is BLACK, you can move the pawn, the first time, to the row 3
		 * If the color is WHITE, you can move the pawn, the first time, to the row 4
		 */
		int initialMoveRow = (pieceColor == Piece.Color.BLACK) ? Constants.B_MID_ROW : Constants.W_MID_ROW;
		
		// Check if the pawn is moving in the right direction
		if((pieceColor == Piece.Color.BLACK && endingPos.getRow() == Constants.FIRST_ROW) ||
				(pieceColor == Piece.Color.WHITE && endingPos.getRow() == Constants.LAST_ROW)) {
			return startingPos;
			
		}
		
		// Add the basic movement of the pawn
		startingPos.add(new Coordinates(endingPos.getColumn(), endingPos.getRow() + addInRow));
		
		// If the ending position has the row 3, add the initial movement of the pawn (2 square up or down)
		if(endingPos.getRow() == initialMoveRow) {
			startingPos.add(new Coordinates(endingPos.getColumn(), endingPos.getRow() + (addInRow * 2)));
			
		}
		
		/* 
		 * If the ending position has the column > 0, we add the normal capture of the pawn on the left
		 * If the ending position has the column < 7, we add the normal capture of the pawn on the right
		 */
		if(endingPos.getColumn() > 0) {
			startingPos.add(new Coordinates(endingPos.getColumn() - 1, endingPos.getRow() + addInRow));
			
		}
		else if(endingPos.getColumn() < 7) {
			startingPos.add(new Coordinates(endingPos.getColumn() + 1, endingPos.getRow() + addInRow));
			
		}
		
		return startingPos;
	}

	public boolean isEnPassant() {
		return enPassant;
	}

	public void setEnPassant(boolean enPassant) {
		this.enPassant = enPassant;
	}
	
	
}
