package it.uniba.game.pieces.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.uniba.game.Constants;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.pieces.Pawn;

class PawnTest {
	
	private final Pawn pawnToTestBlack = new Pawn(Color.BLACK);
	private final Pawn pawnToTestWhite = new Pawn(Color.WHITE);
	
	@Test
	void createBlackTest() {
		
		assertEquals(Constants.B_PAWN, pawnToTestBlack.toString());
	}
	
	@Test
	void createWhiteTest() {
		
		assertEquals(Constants.W_PAWN, pawnToTestWhite.toString());
	}
	
	@Test
	void reverseMoveValidStartPositionBlackPawnTest() {

		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, Constants.B_MID_ROW), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 2),
			new Coordinates(0, 1),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveValidStartPositionWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, Constants.W_MID_ROW), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 5),
			new Coordinates(0, 6),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveInvalidBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, Constants.FIRST_ROW), false);	
		
		assertTrue(pawnToTestBlack.reverseMove(moveToTest).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, Constants.LAST_ROW), false);	
		
		assertTrue(pawnToTestWhite.reverseMove(moveToTest).isEmpty());
	}
	
	@Test
	void reverseMoveValidPositionBlackPawnTest() {

		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, 4), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveValidPositionWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, 2), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveCaptureFirstColumnBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(0, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(1, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveCaptureLastColumnBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(7, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(6, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveCaptureFirstColumnWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(0, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(1, 5),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveCaptureCenterBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(3, 4), true);
		
		Coordinates[] possibleCoordinates = {
				new Coordinates(2, 3),
				new Coordinates(4, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveCaputreCenterWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(3, 4), true);
		
		Coordinates[] possibleCoordinates = {
				new Coordinates(2, 5),
				new Coordinates(4, 5),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveCaptureLastColumnWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(7, 4), true);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(6, 5),
		};
		
		Object[] listToTest = pawnToTestWhite.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveInvalidFirstRowBlackPawnTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(4, 0), false);
		
		assertTrue(pawnToTestBlack.reverseMove(moveToTest).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidLastRowWhitePawnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(2, 7), false);
		
		assertTrue(pawnToTestWhite.reverseMove(moveToTest).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPositionRowTest() {
	
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(1, -5), false);
		
		assertTrue(pawnToTestBlack.reverseMove(moveToTest).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPositionColumnTest() {
		
		Move moveToTest = new Move(pawnToTestWhite, Constants.EMPTY_COORD, new Coordinates(-5, 1), false);
		
		assertTrue(pawnToTestWhite.reverseMove(moveToTest).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPositionColumnRowTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, new Coordinates(10, 10), false);
		
		assertTrue(pawnToTestBlack.reverseMove(moveToTest).isEmpty());
	}
	
	@Test
	void reverseMoveNullTest() {
		
		assertThrows(NullPointerException.class, () -> {
			
			pawnToTestBlack.reverseMove(null);
		});
	}
	
	@Test
	void reverseMoveNullPieceTest() {
		
		Move moveToTest = new Move(null, Constants.EMPTY_COORD, new Coordinates(0, 4), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
		
	}
	
	@Test
	void reverseMoveNullStartTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, null, new Coordinates(0, 4), false);
		
		Coordinates[] possibleCoordinates = {
			new Coordinates(0, 3),
		};
		
		Object[] listToTest = pawnToTestBlack.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoordinates, listToTest);
	}
	
	@Test
	void reverseMoveNullEndTest() {
		
		Move moveToTest = new Move(pawnToTestBlack, Constants.EMPTY_COORD, null, false);
		
		assertThrows(NullPointerException.class, () -> {
			
			pawnToTestBlack.reverseMove(moveToTest); 
		});
	}
	
}
