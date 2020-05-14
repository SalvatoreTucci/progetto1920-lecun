package it.uniba.game.board.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import it.uniba.game.board.ChessBoard;
import it.uniba.game.board.Square;
import it.uniba.game.pieces.Pawn;
import it.uniba.game.pieces.Piece;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;

public class ChessBoardTest {
	private static ChessBoard cb;
	private static Pawn dummyPiece;
	
	@BeforeAll
	static public void PieceInit(){
		dummyPiece = new Pawn(Color.WHITE);
	}
	
	@BeforeEach
	static public void ChessBoardInit(){
		cb = new ChessBoard(); 
	}
	
	@Test
	public void setMoveCorrectTest() {
		
		Coordinates start = new Coordinates(0,Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(0,5); 
		
		cb.setMove(new Move(dummyPiece, start, end, false));
		assertAll(() ->{assertNull(cb.getSquare(start));
						assertEquals(cb.getSquare(end), new Square(dummyPiece));
						});	
	}
	
	@Test
	public void setMoveMoveNullTest() {

		assertThrows(NullPointerException.class,() -> cb.setMove(null));
	}
	
	@Test
	public void setMovePieceNullTest() {
		
		Coordinates start = new Coordinates(1,Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(1,5); 

		cb.setMove(new Move(null, start, end, false));
		assertAll(() -> {assertNull(cb.getSquare(start));
						assertNull(cb.getSquare(end));
						});	
	}
	
	@Test
	public void setMoveStartNullTest() {
		
		Coordinates end = new Coordinates(0,5); 
		
		assertThrows(NullPointerException.class,() -> cb.setMove(new Move(dummyPiece, null, end, false)));

	}
	
	@Test
	public void setMoveEndNullTest() {
		
		Coordinates start = new Coordinates(4,Constants.WHITE_PAWN_ROW); 

		assertThrows(NullPointerException.class,() -> cb.setMove(new Move(dummyPiece, start, null, false)));

	}
	
	@Test
	public void setMoveWrongStartColumnTest() {
		
		Coordinates start = new Coordinates(-1,Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(0,5); 

		assertThrows(IndexOutOfBoundsException.class,() -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	public void setMoveWrongStartRowTest() {
		
		Coordinates start = new Coordinates(0,8);
		Coordinates end = new Coordinates(0,5); 
		
		assertThrows(IndexOutOfBoundsException.class,() -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	public void setMoveWrongStartBothTest() {
		
		Coordinates start = new Coordinates(8,-1);
		Coordinates end = new Coordinates(0,5); 
		
		assertThrows(IndexOutOfBoundsException.class,() -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	public void setMoveWrongEndRowTest() {
		
		Coordinates start = new Coordinates(0,Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(7,8); 

		assertThrows(IndexOutOfBoundsException.class,() -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	public void setMoveWrongEndColumnTest() {
		
		Coordinates start = new Coordinates(0,7);
		Coordinates end = new Coordinates(-1,7); 
		
		assertThrows(IndexOutOfBoundsException.class,() -> cb.setMove(new Move(dummyPiece, start, end, false)));
		
	}
	
	@Test
	public void setMoveWrongEndBothTest() {
		
		Coordinates start = new Coordinates(0,Constants.WHITE_PAWN_ROW);
		Coordinates end = new Coordinates(8,-1); 
		
		assertThrows(IndexOutOfBoundsException.class,() -> cb.setMove(new Move(dummyPiece, start, end, false)));
	}
	
	@Test
	public void setMoveEnPassantCorrectTest() {
		
		Coordinates whitePawnStart = new Coordinates(1,3);
		Coordinates whitePawnEnd = new Coordinates(0,2);
		Coordinates blackPawnEnd = new Coordinates(0,3);
		cb.setMove(new Move(new Pawn(Piece.Color.WHITE), new Coordinates(1,Constants.WHITE_PAWN_ROW),
				whitePawnStart, false));
		cb.setMove(new Move(new Pawn(Piece.Color.BLACK), new Coordinates(0,Constants.BLACK_PAWN_ROW),
				blackPawnEnd, false));
		
		cb.setMove(new Move(dummyPiece, whitePawnStart, whitePawnEnd, true));
		assertAll(() -> {assertEquals(cb.getSquare(whitePawnEnd),new Square(dummyPiece));
						assertNull(cb.getSquare(blackPawnEnd));
						assertNull(cb.getSquare(whitePawnEnd));
		});	
	}
	

	
}
