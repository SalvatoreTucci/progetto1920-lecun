package it.uniba.game;

/**
* Coordinates <br>
* Class type : Entity <br>
* Responsibilities : <br>
* 	Knows : <br>
* 		<ul>
* 		<li>A pair of coordinates of a Cartesian-like plain (as the ChessBoard)</li>
* 		</ul>
*	Does : <br>
*		<ul>
* 		</ul>
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
    
    public boolean equals(Coordinates toCheck) {
    	
    	return row == toCheck.row && column == toCheck.column;
    }
    
}