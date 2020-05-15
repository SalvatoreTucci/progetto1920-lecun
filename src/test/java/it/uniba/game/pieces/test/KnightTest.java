package it.uniba.game.pieces.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


import org.junit.jupiter.api.Test;

import it.uniba.game.Coordinates;
import it.uniba.game.pieces.Knight;
import it.uniba.game.pieces.Piece;
import it.uniba.game.Move;
import it.uniba.game.Constants;

public class KnightTest {
	
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
	public void reverseMoveTopLeftCornerTest() {
		
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
	public void reverseMoveTopRightCornerTest() {
		
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
	public void reverseMoveBottomLeftCornerTest() {
		
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
	public void reverseMoveBottomRightCornerTest() {
		
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
	public void reverseMoveInvalidPosBothGreaterTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(8, 8), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveInvalidPosFirstGreaterSecondLesserTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(8, -1), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveInvalidPosFirstLesserSecondGreaterTest() {
		
		Knight toTest = new Knight(Piece.Color.WHITE);
		Move targetMove = new Move(toTest, Constants.EMPTY_COORD, new Coordinates(-1, 8), false);
		Coordinates[] possibleCoord = {
				
		};
		
		Object[] arrayToCheck = toTest.reverseMove(targetMove).toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	public void reverseMoveInvalidPosBothLesserTest() {
		
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
}
