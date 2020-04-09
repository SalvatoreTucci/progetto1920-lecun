package it.uniba.game;

public class Coordinates{
    // Class used to represent a position in the chessboard

    // Attributes
    private int row;
    private int column;

    // Methods
    public Coordinates(int x, int y) {

        setRow(x);
        setColumn(y);
    }

    public int getRow() {

        return row;
    }

    public int getColumn() {

        return column;
    }

    public void setRow(int x){

        row = x;
    }

    public void setColumn(int y){

        column = y;
    }
}