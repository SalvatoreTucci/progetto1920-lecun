package it.uniba.game;

/**
* Class representing the coordinates used when accessing the chessboard <br>
* Class type : Entity <br>
* Responsibilities : <br>
* 	Knows :
* 		<ul>
* 		<li>A pair of coordinates of a Cartesian-like plain (as the ChessBoard)</li>
* 		</ul>
*	Does :
*
*
* @author LeCun group <br>
*/
public final class Coordinates {
    // Class used to represent a position in the ChessBoard <br>

    // Attributes <br>
    private int row;
    private int column;

    // Methods <br>
    public Coordinates(final int x, final int y) {

    	setColumn(x);
        setRow(y);
    }

    public int getRow() {

        return row;
    }

    public int getColumn() {

        return column;
    }

    public void setRow(final int y) {

        row = y;
    }

    public void setColumn(final int x) {

        column = x;
    }

    public String toString() {

    	return "(" + column + ", " + row + ")";
    }

    public boolean equals(final Object toCheck) {

    	return (toCheck != null) && (toCheck instanceof Coordinates)
    			&& ((row == ((Coordinates) toCheck).getRow())
    					&& (column == ((Coordinates) toCheck).getColumn()));
    }

    public int hashCode() {

    	assert false : "hashCode not designed";
    	return Constants.INVALID_HASHCODE;
    }
}
