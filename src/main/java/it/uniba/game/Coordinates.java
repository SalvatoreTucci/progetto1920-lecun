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
public class Coordinates {
    // Class used to represent a position in the ChessBoard <br>

    // Attributes <br>
    private int row;
    private int column;

    // Methods <br>
    public Coordinates(int x, int y) {

    	setColumn(x);
        setRow(y);
    }

    public int getRow() {

        return row;
    }

    public int getColumn() {

        return column;
    }

    public void setRow(int y) {

        row = y;
    }

    public void setColumn(int x) {

        column = x;
    }
    
    public String toString() {
    	
    	return new String("(" + column + ", " + row + ")");
    }
    
    public boolean equals(Object toCheck) {
    	
    	return ((row == ((Coordinates) toCheck).getRow()) && (column == ((Coordinates)toCheck).getColumn()));
    }
    
}