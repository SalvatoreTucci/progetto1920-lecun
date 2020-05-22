package it.uniba.game;

/**
* Class representing the coordinates used when accessing the chessboard <br>
* Class type : &#60; Entity &#62; <br>
*
* Responsibilities : <br>
*
* 	Knows :
* 		<ul>
* 		<li>A pair of coordinates of a Cartesian-like plain (as the ChessBoard)</li>
* 		</ul>
*	Does : <br>
*
*
* @author LeCun group
*/



public final class Coordinates {

	/**
	 * <code>row</code> holds the value of the vertical coordinate.
	 */
    private int row;

    /**
	 * <code>column</code> holds the value of the horizontal coordinate.
	 */
    private int column;

    /**
     * Constructor for the class Coordinates
     * 
     * @param x value set to the <code>column</code> attribute
     * @param y value set to the <code>row</code> attribute
     */
    public Coordinates(final int x, final int y) {

    	setColumn(x);
        setRow(y);
    }

    /**
     * Getter method for the attribute row.
     *
     * @return the value of the row in the coordinate.
     */
    public int getRow() {

        return row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the column in the coordinate.
     */
    public int getColumn() {

        return column;
    }

    /**
     * Sets the value of the row.
     * 
     * @param y value set as the row in the coordinate.
     */
    public void setRow(final int y) {

        row = y;
    }

    /**
     * Sets the value of the column.
     * 
     * @param x value set as the column in the coordinate.
     */
    public void setColumn(final int x) {

        column = x;
    }

    /**
     * toString Override for the class Coordinates.
     * 
     * @return a string representing the coordinate, in the format (column, row).
     */
    @Override
    public String toString() {

    	return "(" + column + ", " + row + ")";
    }

    /**
     * Compares the values of two coordinates.
     * 
     * @param toCheck object to compare to the coordinate.
     * @return true if the two coordinates are equal, false if otherwise.
     */
    @Override
    public boolean equals(final Object toCheck) {

    	return (toCheck != null) && (toCheck instanceof Coordinates)
    			&& ((row == ((Coordinates) toCheck).getRow())
    					&& (column == ((Coordinates) toCheck).getColumn()));
    }

    /**
     * hashCode override's definition
     * it will be not implemented for now, but it must be written in
     * order to conform the style as required.
     * 
     * @return Constants.INVALID_HASHCODE
     */
    @Override
    public int hashCode() {

    	assert false : "hashCode not designed";
    	return Constants.INVALID_HASHCODE;
    }
}
