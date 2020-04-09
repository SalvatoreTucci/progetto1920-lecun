package it.uniba.game.pieces;

public abstract class Piece{
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

    public Color getColor() {

        return pieceColor;
    }

    public String toString() {

        return symbol;
    }

    abstract public it.uniba.game.Coordinates reverseMove(it.uniba.game.Coordinates endingPos);

}