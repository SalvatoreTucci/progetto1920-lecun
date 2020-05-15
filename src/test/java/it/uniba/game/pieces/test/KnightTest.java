package it.uniba.game.pieces.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.uniba.game.Coordinates;
import it.uniba.game.pieces.Knight;
import it.uniba.game.pieces.Piece;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.Move;
import it.uniba.game.Constants;

public class KnightTest {
	
	@Test
	void constructorWhiteTest() {

		assertEquals(Constants.W_KNIGHT, new Knight(Color.WHITE).toString());
	}

	@Test
	void constructorBlackTest() {

		assertEquals(Constants.B_KNIGHT, new Knight(Color.BLACK).toString());
	}
	
	@Test
	public void reverseMoveCorrectCentralTest() {
		
		Knight toTest = new Knight(Piece.Color.BLACK);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(3,4), false);
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
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveTopLeftTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(0,0), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(2, 1),
			new Coordinates(1, 2),
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveTopRightTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(7,0), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(5, 1),
			new Coordinates(6, 2),
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveBottomLeftTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(0,7), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(2, 6),
			new Coordinates(1, 5),
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveBottomRightTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(7,7), false);
		Coordinates[] possibleCoord = {
				
			new Coordinates(5, 6),
			new Coordinates(6, 5),
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveBothOutOfBoundTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(8, 8), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveColOutOfBoundTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(8, 1), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveRowOutOfBoundTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(1, 8), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveNegativeCoordTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(-1, -1), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveInvalidPosIntMinTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveInvalidPosIntMaxTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveNullMoveTest() {	

		Knight toTest = new Knight(Piece.Color.WHITE);
		assertThrows(NullPointerException.class, () ->toTest.reverseMove(null));
	}

	@Test
	public void reverseMoveNullPieceTest() {

		Knight toTest = new Knight(Piece.Color.WHITE);
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
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);

	}

	@Test
	public void reverseMoveNullStartTest() {

		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, null, new Coordinates(3,4), false);
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
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}

	@Test
	public void reverseMoveEndMoveTest() {

		Knight toTest = new Knight(Piece.Color.WHITE);
		
		assertThrows(NullPointerException.class, () ->toTest.reverseMove(new Move(toTest,
				Constants.EMPTY_COORD,
				null, false)));
	}
}
