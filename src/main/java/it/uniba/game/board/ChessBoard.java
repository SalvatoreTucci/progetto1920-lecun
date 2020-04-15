package it.uniba.game.board;

import it.uniba.game.pieces.*;
import it.uniba.game.*;

public class ChessBoard {
	// Class used for represents the chessboard
	
	private Square elements[][];
	
	public ChessBoard() {
		
		elements = new Square[8][8];
		
		// Inizialize Rook pieces
		elements[0][0] = new Square(new Rook(Piece.Color.BLACK));
		elements[0][7] = new Square(new Rook(Piece.Color.BLACK));
		elements[7][0] = new Square(new Rook(Piece.Color.WHITE));
		elements[7][7] = new Square(new Rook(Piece.Color.WHITE));
		
		// Inizialize Knight pieces
		elements[0][1] = new Square(new Knight(Piece.Color.BLACK));
		elements[0][6] = new Square(new Knight(Piece.Color.BLACK));
		elements[7][1] = new Square(new Knight(Piece.Color.WHITE));
		elements[7][6] = new Square(new Knight(Piece.Color.WHITE));
		
		// Inizialize Bishop pieces
		elements[0][2] = new Square(new Bishop(Piece.Color.BLACK));
		elements[0][5] = new Square(new Bishop(Piece.Color.BLACK));
		elements[7][2] = new Square(new Bishop(Piece.Color.WHITE));
		elements[7][5] = new Square(new Bishop(Piece.Color.WHITE));
		
		// Inizialize King pieces
		elements[0][4] = new Square(new King(Piece.Color.BLACK));
		elements[7][4] = new Square(new King(Piece.Color.WHITE));
		
		// Inizialize Queen pieces
		elements[0][3] = new Square(new Queen(Piece.Color.BLACK));
		elements[7][3] = new Square(new Queen(Piece.Color.WHITE));
		
		// Inizialize Pawn pieces
		for (int i = 0; i < 8; i++) {
			elements[1][i] = new Square(new Pawn(Piece.Color.BLACK));
			elements[6][i] = new Square(new Pawn(Piece.Color.WHITE));
		}
		
		// Inizialize empty Squares
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				elements[i][j] = new Square(null);
			}
		}
	}
	
	public String toString() {
		
		String res = Constants.CB_LETTERS_COORDS;
		res += Constants.CB_FIRST_ROW;
		
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {
				if (j == 0) {
					
					res += Math.abs(i - 8) + " ";
				}
				
				res += Constants.CB_VERTICAL_SQUARE_SYMBOL;
				
				if (elements[i][j].isOccupied()) {
					res += " " + elements[i][j].getPiece().toString() + " ";
					
				} else {
					
					res += Constants.CB_EMPY_SQUARE;
				}
				
			}
			
			res += Constants.CB_VERTICAL_SQUARE_SYMBOL + " " + Math.abs(i - 8) + "\n";
			if (i != 7) {
				
				res += Constants.CB_MIDDLE_ROW_SQUARES;
			}
		}
		
		res += Constants.CB_LAST_ROW;
		res += Constants.CB_LETTERS_COORDS;
		
		return res;
		
	}
	
	public void setMove(Move currentMove) {
		
		Coordinates start = currentMove.getStartingPos();
		Coordinates end   = currentMove.getEndingPos();
		
		elements[end.getRow()][end.getColumn()].setPiece(currentMove.getPiece());
			
		elements[start.getRow()][start.getColumn()].setPiece(null);
			
		
		if (currentMove.getEnPassant()) {
			
			int addR = ( currentMove.getPiece().getColor() == Piece.Color.WHITE )
					? Constants.DOWN_DIRECTION : Constants.UP_DIRECTION;
			elements[end.getRow() + addR][end.getColumn()].setPiece(null);
		}
		
	}
	
	public Square getSquare(Coordinates coord) {
		
		return elements[coord.getRow()][coord.getColumn()];
	}
	
}
