package it.uniba.game.pieces;

import java.util.LinkedList;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;
import it.uniba.game.Constants;

/**
 * Abstract class representing a generic chess piece <br>
 * Class type: &#60; Entity &#62; <br><br>
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
 * @author LeCun group <br>
*/



public abstract class Piece {

	/**
	 *  Enumerated type used to represent the color of the piece
	 */
    public enum Color {

        WHITE,
        BLACK;
    }

    /**
     * The piece's color
     */
    private Color pieceColor;

    /**
     * The piece's distinctive symbol. Since it is the attribute on which
     * each piece is evaluated, each piece of a specific color must have a different
     * symbol.
     */
    private String symbol;

	/**
	 * Constructor for the class Piece. It is applied in each sub-class constructor.
	 * It initializes the piece's color. If <code>col==null</code> then the set color
	 * is Color.WHITE.
	 * 
	 * @param col color of the piece.
	 */
    public Piece(final Color col) {

    	if (col == Color.BLACK) {

    		pieceColor = col;
    	} else {

    		pieceColor = Color.WHITE;
    	}

    }

    /**
     * Sets the UTF-8 symbol for the chess piece.
     * 
     * @param sym The symbol to be assigned to the piece.
     * 			  It doesn't make checks on the color/string and on the symbol itself.
     */
    void setSymbol(final String sym) {

    	symbol = sym;
    }

    /**
     * Abstract method returning the list of possible starting position of a piece being moved
     * given the Coordinates of its ending position, contained in <code>target</code>.
     * If <code>target</code>'s ending position is out of the chessboard bounds (from (0,0)
     * to (7,7)), then the returned list is empty.
     * 
     * @param target The piece's move, which starting position has to be determined.
     * 
     * @return A LinkedList of Coordinates of the possible starting positions
     */
    public abstract LinkedList<Coordinates> reverseMove(Move target);

    /**
     * Gets the color of the piece.
     * 
     * @return this piece's color.
     */
    public Color getColor() {

        return pieceColor;
    }


    /**
     * Piece class' toString method
     * 
     * @return A string containing the piece's symbol, assuming it is different
     * 		   for each color.
     */
    @Override
    public String toString() {

        return symbol;
    }

    /**
     * Piece class' equals method
     * @param  toCompare the piece that has to be compared with "this"
     * 
     * @return true if the two pieces have the same symbol (since it identifies the piece's type),
     * 		   false otherwise
     * 
     * @throws ClassCastException If toCompare can't be casted to a Piece Object
     */
    @Override
    public boolean equals(final Object toCompare) {

    	return ((toCompare != null) && (toCompare instanceof Piece)
    			&& this.toString().equals(((Piece) toCompare).toString()));
    }

    protected static Boolean checkOutOfBound(final Move target) {

    	return target.getEndingPos().getRow() > Constants.LAST_ROW
    			|| target.getEndingPos().getRow() < Constants.FIRST_ROW
    			|| target.getEndingPos().getColumn() > Constants.LAST_COLUMN
    			|| target.getEndingPos().getColumn() < Constants.FIRST_COLUMN;
    }

    /**
     * hashCode override's definition
     * it will be not implemented for now, but it must be written in
     * order to conform the style as required
     */
    @Override
    public int hashCode() {

        assert false : "hashCode not designed";

        return Constants.INVALID_HASHCODE;
    }

}
