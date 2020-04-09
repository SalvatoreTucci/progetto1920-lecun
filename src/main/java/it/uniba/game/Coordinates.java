package it.uniba.game;

public class Coordinates{
    // Class used to represent a position in the chessboard

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

    public void setRow(int y){

        row = y;
    }

    public void setColumn(int x){

        column = x;
    }
}