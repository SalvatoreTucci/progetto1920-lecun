package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

/**
 * Subclass of Piece representing the Queen 
 * Class type: <<Entity>>
 * 
 * Responsibilities:
 * 
 * 	Knows: 
 * 		<ul>
 * 		<li>The symbol (and so the color) of the instance of
 * 			the Queen</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Queen could
 * 			possibly be found, given the 
 * 			target position</li>
 * 		</ul>
 * 
*/
public final class Queen extends Piece {
	
	// Constructor
	public Queen(Color col) {
		
		super(col);
		
		if (pieceColor == Color.BLACK) {
			
			symbol = Constants.B_QUEEN;
		} else {
			
			symbol = Constants.W_QUEEN;	
		}
		
	}
	
	public Vector<Coordinates> reverseMove(Move target){
		/*
		 *  The starting position of the Queen can be traced through the same checks done
		 *  for the Rook and the Bishop
		 */
		
		Vector<Coordinates> possibleSquares = Rook.reverseRookMove(target);
		
		possibleSquares.addAll(Bishop.reverseBishopMove(target));
		
		return possibleSquares;
	}
	
}
