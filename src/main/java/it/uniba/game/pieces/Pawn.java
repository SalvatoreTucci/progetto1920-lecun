package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.*;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Pawn <br>
 * Class type: Entity
 * 
 * Responsibilities: <br>
 * 
 * 	Knows: 
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the Pawn</li>
 * 		<li>If it's possible to do the En Passant move
 * 			on an instance of a Pawn</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Pawn could
 * 			possibly be found, given the 
 * 			target position</li>
 * 		</ul>
 * 
*/
public final class Pawn extends Piece {
	
	
	// Constructor
	public Pawn(Color col) {
		
		super(col);
		
		if (col == Piece.Color.BLACK) {
			
			this.setSymbol(Constants.B_PAWN);
		} else {
			
			this.setSymbol(Constants.W_PAWN);
		}
		
	}
	
	public LinkedList<Coordinates> reverseMove(Move target) {
		
		LinkedList<Coordinates> startingPos = new LinkedList<Coordinates>();
		
		/*
		 * If the color is BLACK, you can move the pawn down, so it will be B_DIRECTION_ROW
		 * If the color is WHITE, you can move the pawn up, so it will be W_DIRECTION_ROW
		 */
		int addInRow = (this.getColor() == Piece.Color.BLACK) 
				? Constants.UP_DIRECTION : Constants.DOWN_DIRECTION;
		
		/*
		 * If the color is BLACK, you can move the pawn, the first time, to the row B_MID_ROW
		 * If the color is WHITE, you can move the pawn, the first time, to the row W_MID_ROW
		 */
		int initialMoveRow = (this.getColor() == Piece.Color.BLACK) 
				? Constants.B_MID_ROW : Constants.W_MID_ROW;
		
		// Check if the pawn is moving in the right direction
		if ((this.getColor() == Piece.Color.BLACK && target.getEndingPos().getRow() == Constants.FIRST_ROW) 
				|| (this.getColor() == Piece.Color.WHITE && target.getEndingPos().getRow() == Constants.LAST_ROW)) {
			
			return startingPos;
		}
		
		if (!target.getCaptureFlag()) {
			// Add the basic movement of the pawn
			startingPos.add(new Coordinates(target.getEndingPos().getColumn(),
					target.getEndingPos().getRow() + addInRow));
		
		
			// If the ending position has the row B_MID_ROW or W_MID_ROW, add the initial movement of the pawn (2 square up or down)
			if (target.getEndingPos().getRow() == initialMoveRow) {
				
				startingPos.add(new Coordinates(target.getEndingPos().getColumn(),
						target.getEndingPos().getRow() + (addInRow * 2)));
			}
			
		} else {
			/* 
			 * If the ending position has the column > FIRST_ROW, we add the normal capture of the pawn on the left
			 * If the ending position has the column < LAST_ROW, we add the normal capture of the pawn on the right
			 */
			if (target.getEndingPos().getColumn() > Constants.FIRST_ROW) {
				
				startingPos.add(new Coordinates(target.getEndingPos().getColumn() - 1,
						target.getEndingPos().getRow() + addInRow));	
			}
			
			if (target.getEndingPos().getColumn() < Constants.LAST_ROW) {
				
				startingPos.add(new Coordinates(target.getEndingPos().getColumn() + 1
						, target.getEndingPos().getRow() + addInRow));
			}
			
		}
		
		return startingPos;
		
	}
	
	
}
