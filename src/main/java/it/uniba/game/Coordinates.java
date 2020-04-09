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

        int MIN_ROW = 0;
        int MAX_ROW = 7;

        if(x >= MIN_ROW & x <= MAX_ROW)
            row = x;
        /*
        else
            aggiungere exception
         */
    }

    public void setColumn(int y){

        int MIN_COLUMN = 0;
        int MAX_COLUMN = 7;

        if(y >= MIN_COLUMN & y <= MAX_COLUMN)
            column = y;
        /*
        else
            aggiungere exception
         */
    }
}