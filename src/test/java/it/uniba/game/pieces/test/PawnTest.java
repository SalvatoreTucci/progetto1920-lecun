package it.uniba.game.pieces.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.uniba.game.Constants;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.pieces.Pawn;

public class PawnTest {
	
	private final Pawn pawnToTestBlack = new Pawn(Color.BLACK);
	private final Pawn pawnToTestWhite = new Pawn(Color.WHITE);
	
	@Test
	public void createBlackTest() {
		
		assertEquals(Constants.B_PAWN, pawnToTestBlack.toString());
	}
	
	@Test
	public void createWhiteTest() {
		
		assertEquals(Constants.W_PAWN, pawnToTestWhite.toString());
	}
	
	@Test
	public void reverseMoveValidStartPositionBlackPawnTest() {

		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, Constants.B_MID_ROW), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 2),
			new Coordinates(0, 1),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveValidStartPositionWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, Constants.W_MID_ROW), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 5),
			new Coordinates(0, 6),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveInvalidBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, Constants.FIRST_ROW), false);	
		
		assertEquals(0, pawnToTestBlack.reverseMove(moveToTest).size());
	}
	
	@Test
	public void reverseMoveInvalidWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, Constants.LAST_ROW), false);	
		
		assertEquals(0, pawnToTestWhite.reverseMove(moveToTest).size());
	}
	
	@Test
	public void reverseMoveValidPositionBlackPawnTest() {

		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, 4), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveValidPositionWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, 2), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveCaptureFirstColumnBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(1, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveCaptureLastColumnBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(7, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(6, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveCaptureFirstColumnWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(1, 5),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveCaptureCenterBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(3, 4), true);
		
		Coordinates[] possibleCoordinates = {
				new Coordinates(2, 3),
				new Coordinates(4, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveCaputreCenterWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(3, 4), true);
		
		Coordinates[] possibleCoordinates = {
				new Coordinates(2, 5),
				new Coordinates(4, 5),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveCaptureLastColumnWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(7, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(6, 5),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveInvalidFirstRowBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(4, 0), false);
		
		Coordinates[] possibCoordinates = {};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveInvalidLastRowWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(2, 7), false);
		
		Coordinates[] possiCoordinates = {};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possiCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveInvalidPositionRowTest() {
	
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(1, -5), false);
		
		Coordinates[] possibCoordinates = {};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveInvalidPositionColumnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(-5, 1), false);
		
		Coordinates[] possibCoordinates = {};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveInvalidPositionColumnRowTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(10, 10), false);
		
		Coordinates[] possCoordinates = {};
	
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveNullTest() {
		
		assertThrows(NullPointerException.class, () -> {
			
			pawnToTestBlack.reverseMove(null);
		});
	}
	
	@Test
	public void reverseMoveNullPieceTest() {
		
		Move moveToTest = new Move(null, Constants.EMPTY_COORD, new Coordinates(0, 4), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
		
	}
	
	@Test
	public void reverseMoveNullStartTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, null, new Coordinates(0, 4), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	public void reverseMoveNullEndTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, null, false);
		
		assertThrows(NullPointerException.class, () -> {
			
			pawnToTestBlack.reverseMove(moveToTest); 
		});
	}
	
}
