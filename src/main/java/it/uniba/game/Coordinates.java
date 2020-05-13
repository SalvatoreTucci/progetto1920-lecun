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
* @author LeCun group
*/
public class Coordinates {
    // Class used to represent a position in the ChessBoard

    // Attributes
    private int row;
    private int column;

    // Methods
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
    
    public boolean equals(Coordinates toCheck) {
    	
    	return row == toCheck.row && column == toCheck.column;
    }
    
}