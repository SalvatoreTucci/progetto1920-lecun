package it.uniba.game.pieces.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.uniba.game.Coordinates;
import it.uniba.game.pieces.Knight;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.Move;
import it.uniba.game.Constants;

class KnightTest {
	
	private final Knight testKnight = new Knight(Color.WHITE);
	
	@Test
	void constructorWhiteTest() {

		assertEquals(Constants.W_KNIGHT, new Knight(Color.WHITE).toString());
	}

	@Test
	void constructorBlackTest() {

		assertEquals(Constants.B_KNIGHT, new Knight(Color.BLACK).toString());
	}
	
	@Test
	void reverseMoveCorrectCentralTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(3,4), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(5, 5),
			new Coordinates(1, 5),
			new Coordinates(4, 6),
			new Coordinates(2, 6),
			new Coordinates(5, 3),
			new Coordinates(1, 3),
			new Coordinates(4, 2),
			new Coordinates(2, 2)
		};
		
		Object[] arrayToCheck = testKnight.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseMoveTopLeftTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(0,0), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(2, 1),
			new Coordinates(1, 2),
		};
		
		Object[] arrayToCheck = testKnight.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseMoveTopRightTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(7,0), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(5, 1),
			new Coordinates(6, 2),
		};
		
		Object[] arrayToCheck = testKnight.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseMoveBottomLeftTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(0,7), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(2, 6),
			new Coordinates(1, 5),
		};
		
		Object[] arrayToCheck = testKnight.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseMoveBottomRightTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(7,7), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(5, 6),
			new Coordinates(6, 5),
		};
		
		Object[] arrayToCheck = testKnight.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseMoveBothOutOfBoundTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(8, 8), false);
		
		assertTrue(testKnight.reverseMove(targetMove).isEmpty());
	}
	
	@Test
	void reverseMoveColOutOfBoundTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(8, 1), false);
		
		assertTrue(testKnight.reverseMove(targetMove).isEmpty());
	}
	
	@Test
	void reverseMoveRowOutOfBoundTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(1, 8), false);
	
		assertTrue(testKnight.reverseMove(targetMove).isEmpty());
	}
	
	@Test
	void reverseMoveNegativeCoordTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(-1, -1), false);
		
		assertTrue(testKnight.reverseMove(targetMove).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPosIntMinTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE), false);
		
		assertTrue(testKnight.reverseMove(targetMove).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPosIntMaxTest() {
		
		Move targetMove = new Move(testKnight, Constants.EMPTY_COORD, new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE), false);
		
		assertTrue(testKnight.reverseMove(targetMove).isEmpty());
	}
	
	@Test
	void reverseMoveNullMoveTest() {	

		assertThrows(NullPointerException.class, () ->testKnight.reverseMove(null));
	}

	@Test
	void reverseMoveNullPieceTest() {

		Move targetMove = new Move(null, Constants.EMPTY_COORD, new Coordinates(3,4), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(5, 5),
			new Coordinates(1, 5),
			new Coordinates(4, 6),
			new Coordinates(2, 6),
			new Coordinates(5, 3),
			new Coordinates(1, 3),
			new Coordinates(4, 2),
			new Coordinates(2, 2)
		};
		
		Object[] arrayToCheck = testKnight.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);

	}

	@Test
	void reverseMoveNullStartTest() {

		Move targetMove = new Move(testKnight, null, new Coordinates(3,4), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(5, 5),
			new Coordinates(1, 5),
			new Coordinates(4, 6),
			new Coordinates(2, 6),
			new Coordinates(5, 3),
			new Coordinates(1, 3),
			new Coordinates(4, 2),
			new Coordinates(2, 2)
		};
		
		Object[] arrayToCheck = testKnight.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}

	@Test
	void reverseMoveEndMoveTest() {
		
		assertThrows(NullPointerException.class, () ->testKnight.reverseMove(new Move(testKnight,
				Constants.EMPTY_COORD,
				null, false)));
	}
}
