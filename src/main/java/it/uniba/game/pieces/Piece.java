package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;
import it.uniba.game.Constants;

/**
 * Abstract class representing a generic chess piece <br>
 * Class type: Entity <br>
 * 
 * Responsibilities: <br>
 * 
 * 	Knows: 
 * 		<ul>
 * 		<li>Which colors are used</li>
 * 		<li>The symbol (and so the color) of the instance of
 * 			a Piece</li>
 * 		</ul>
 * 
 * 	Does:
 * 		<ul>
 * 		<li>Generates a list of coordinates where a Piece could
 * 			possibly be found, given the 
 * 			target position</li>
 * 		<li>Converts a Piece object into his symbol (in UTF-8)</li>
 * 		<li>Computes if two Pieces are equal</li>
 * 		<li>Can compute if a Piece had a target move out of bound</li>
 * 		</ul>
 * 
*/


public abstract class Piece {
    /*
    Abstract class representing a generic chess piece
     */

    public enum Color {
        // Enumerated type used to represent the color of the piece
        WHITE,
        BLACK;
    }

    // Attributes
    private Color pieceColor;
    private String symbol;

    // Methods
    public Piece(Color col) {
    	
    	if (col == Color.BLACK) {
    		
    		pieceColor = col;
    		
    	} else {
    		
    		pieceColor = Color.WHITE;
    	}
    }
    
    void setSymbol(String sym) {
    	
    	symbol = sym;
    }
    
    // will be specified in the sub-classes 
    abstract public LinkedList<Coordinates> reverseMove(Move target);

    public Color getColor() {

        return pieceColor;
    }

    public String toString() {

        return symbol;
    }


    public boolean equals(Object toCompare) {
    	
    	if (toCompare != null && this.toString().equals(((Piece)toCompare).toString())) {
    		
    		return true;
    	}
    	return false;
    }
    
    protected static Boolean checkOutOfBound(Move target) {
    	
    	return target.getEndingPos().getRow() > Constants.LAST_ROW || target.getEndingPos().getRow() < Constants.FIRST_ROW
    			|| target.getEndingPos().getColumn() > Constants.LAST_COLUMN || target.getEndingPos().getColumn() < Constants.FIRST_COLUMN;
    }

}