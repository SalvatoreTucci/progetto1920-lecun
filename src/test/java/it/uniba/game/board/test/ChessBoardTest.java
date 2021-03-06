package it.uniba.game.board.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniba.game.board.ChessBoard;
import it.uniba.game.pieces.Pawn;
import it.uniba.game.pieces.Piece;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

class ChessBoardTest {
	
	private ChessBoard cb;
	private final Pawn dummyPiece = new Pawn(Color.WHITE);
	
	@BeforeEach
	void chessBoardInit() {
		
		cb = new ChessBoard(); 
	}
	
	@Test
	void setMoveCorrectTest() {
		
		Coordinates start = new Coordinates(0, Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(0, 5); 
		
		cb.setMove(new Move(dummyPiece, start, end, false));
		
		assertAll(() -> {assertNull(cb.getSquare(start).getPiece());
						assertEquals(dummyPiece, cb.getSquare(end).getPiece());
						});	
	}
	
	
	@Test
	void setMoveMoveNullTest() {

		assertThrows(NullPointerException.class,() -> cb.setMove(null));
	}
	
	@Test
	void setMovePieceNullTest() {
		
		Coordinates start = new Coordinates(1, Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(1, 5); 

		cb.setMove(new Move(null, start, end, false));
		
		assertAll(() -> {assertNull(cb.getSquare(start).getPiece());
						assertNull(cb.getSquare(end).getPiece());
						});	
	}
	
	@Test
	void setMoveStartNullTest() {
		
		Coordinates end = new Coordinates(0, 5); 
		
		assertThrows(NullPointerException.class, () -> cb.setMove(new Move(dummyPiece, null, end, false)));

	}
	
	@Test
	void setMoveEndNullTest() {
		
		Coordinates start = new Coordinates(4, Constants.WHITE_PAWN_ROW); 

		assertThrows(NullPointerException.class, () -> cb.setMove(new Move(dummyPiece, start, null, false)));

	}
	
	@Test
	void setMoveWrongStartColumnTest() {
		
		Coordinates start = new Coordinates(-1, Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(0, 5); 

		assertThrows(IndexOutOfBoundsException.class, () -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	void setMoveWrongStartRowTest() {
		
		Coordinates start = new Coordinates(0, 8);
		Coordinates end = new Coordinates(0, 5); 
		
		assertThrows(IndexOutOfBoundsException.class, () -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	void setMoveWrongStartBothTest() {
		
		Coordinates start = new Coordinates(8, -1);
		Coordinates end = new Coordinates(0, 5); 
		
		assertThrows(IndexOutOfBoundsException.class, () -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	void setMoveWrongEndRowTest() {
		
		Coordinates start = new Coordinates(0, Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(7, 8); 

		assertThrows(IndexOutOfBoundsException.class, () -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	void setMoveWrongEndColumnTest() {
		
		Coordinates start = new Coordinates(0, 7);
		Coordinates end = new Coordinates(-1, 7); 
		
		assertThrows(IndexOutOfBoundsException.class, () -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	void setMoveWrongEndBothTest() {
		
		Coordinates start = new Coordinates(0, Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(8, -1); 
		
		assertThrows(IndexOutOfBoundsException.class, () -> cb.setMove(new Move(dummyPiece, start, end, false)));
	}
	
	@Test
	void setMoveEnPassantWhiteCorrectTest() {
		
		Coordinates whitePawnStart = new Coordinates(1, 3);
		Coordinates whitePawnEnd = new Coordinates(0, 2);
		Coordinates blackPawnEnd = new Coordinates(0, 3);
		Move enPass =new Move(dummyPiece, whitePawnStart, whitePawnEnd, true);
		enPass.setEnPassant();
		
		cb.setMove(new Move(new Pawn(Piece.Color.WHITE), new Coordinates(1,Constants.WHITE_PAWN_ROW),
				whitePawnStart, false));
		cb.setMove(new Move(new Pawn(Piece.Color.BLACK), new Coordinates(0,Constants.BLACK_PAWN_ROW),
				blackPawnEnd, false));
		
		cb.setMove(enPass);
		assertAll(() -> {assertEquals(dummyPiece, cb.getSquare(whitePawnEnd).getPiece());
						assertNull(cb.getSquare(blackPawnEnd).getPiece());
						assertNull(cb.getSquare(whitePawnStart).getPiece());
		});	
	}
	
	@Test
	void setMoveEnPassantBlackCorrectTest() {
		
		Coordinates blackPawnStart = new Coordinates(6, 4);
		Coordinates blackPawnEnd = new Coordinates(7, 5);
		Coordinates whitePawnEnd = new Coordinates(7, 4);
		Pawn blackP = new Pawn(Piece.Color.BLACK);
		Move enPass =new Move(blackP, blackPawnStart, blackPawnEnd, true);
		enPass.setEnPassant();
		
		cb.setMove(new Move(new Pawn(Piece.Color.WHITE), new Coordinates(1,Constants.WHITE_PAWN_ROW),
				whitePawnEnd, false));
		cb.setMove(new Move(new Pawn(Piece.Color.BLACK), new Coordinates(0,Constants.BLACK_PAWN_ROW),
				blackPawnStart, false));
		
		cb.setMove(enPass);
		assertAll(() -> {assertEquals(blackP, cb.getSquare(blackPawnEnd).getPiece());
						assertNull(cb.getSquare(whitePawnEnd).getPiece());
						assertNull(cb.getSquare(blackPawnStart).getPiece());
		});	
	}
	
	@Test
	void toStringTest() {
		String expectedChessBoard = Constants.CB_LETTERS_COORDS 
				+ Constants.CB_FIRST_ROW 
				+ "8 " + Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_ROOK + " "
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_KNIGHT + " "
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_BISHOP + " "
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_QUEEN + " "
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_KING + " "
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_BISHOP + " "
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_KNIGHT + " "
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_ROOK + " " 
						+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 8\n"
				+ Constants.CB_MIDDLE_ROW_SQUARES
				+ "7 " + Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " "	
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.B_PAWN + " " 
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 7\n"
				+ Constants.CB_MIDDLE_ROW_SQUARES 
				+ "6 "+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE 
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 6\n"
				+ Constants.CB_MIDDLE_ROW_SQUARES
				+ "5 "+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE 
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 5\n"
					+ Constants.CB_MIDDLE_ROW_SQUARES
				+ "4 "+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE 
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 4\n"
				+ Constants.CB_MIDDLE_ROW_SQUARES
				+ "3 "+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE 
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + Constants.CB_EMPTY_SQUARE
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 3\n"
				+ Constants.CB_MIDDLE_ROW_SQUARES
				+ "2 " + Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " "	
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_PAWN + " " 
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 2\n"
				+ Constants.CB_MIDDLE_ROW_SQUARES
				+ "1 " + Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_ROOK + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_KNIGHT + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_BISHOP + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_QUEEN + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_KING + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_BISHOP + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_KNIGHT + " "
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " " +Constants.W_ROOK + " " 
					+ Constants.CB_VERTICAL_SQUARE_SYMBOL + " 1\n"
				+ Constants.CB_LAST_ROW
				+ Constants.CB_LETTERS_COORDS;
		assertEquals(expectedChessBoard, cb.toString());
		
		
	}


}
