package it.uniba.game.pieces;

import java.util.Vector;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

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
    Color pieceColor;
    String symbol;

    // Methods
    public Piece(Color col) {

        pieceColor = col;
    }
    
    // will be specified in the sub-classes 
    abstract public Vector<Coordinates> reverseMove(Move target);

    public Color getColor() {

        return pieceColor;
    }

    public String toString() {

        return symbol;
    }


    public boolean equal(Piece toCompare) {
    	
    	if (this.toString().equals(toCompare.toString())) {
    		
    		return true;
    	}
    	return false;
    }
}