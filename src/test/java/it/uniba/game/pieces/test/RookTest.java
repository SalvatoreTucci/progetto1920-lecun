package it.uniba.game.pieces.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.uniba.game.Constants;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.pieces.Rook;

class RookTest {
	
	private final Rook rookToTest = new Rook(Color.BLACK);
	
	@Test
	void createBlackTest() {
		
		assertEquals(Constants.B_ROOK, new Rook(Color.BLACK).toString());
	}
	
	@Test
	void createWhiteTest() {
		
		assertEquals(Constants.W_ROOK, new Rook(Color.WHITE).toString());
	}
	
	@Test
	void reverseMoveCenterTest() {

		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(3, 3), false);
		
		int offset = 0;
		Coordinates[] possibleCoord = new Coordinates[14];
		for(int i = 0; i < 7; i++) {
			
			if(i == 3) {
				
				offset = 1;
			}
			
			possibleCoord[i * 2] = new Coordinates(i + offset, 3);
			possibleCoord[(i * 2) + 1] = new Coordinates(3, i + offset);
		}	
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveTopLeftCornerTest() {
		
		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(0, 0), false);
		
		Coordinates[] possibleCoord = new Coordinates[14];
		for(int i = 0; i < 7; i++) {
			
			possibleCoord[i * 2] = new Coordinates(i + 1, 0);
			possibleCoord[(i * 2) + 1] = new Coordinates(0, i + 1);
		}
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveTopRightCornerTest() {

		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(7, 0), false);
		
		Coordinates[] possibleCoord = new Coordinates[14];
		possibleCoord[0] = new Coordinates(0, 0);
		possibleCoord[13] = new Coordinates(7, 7);
		
		for(int i = 1; i < 7; i++) {
			
			possibleCoord[(i * 2) - 1] = new Coordinates(i, 0);
			possibleCoord[i * 2] = new Coordinates(7, i);
		}
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();

		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveBottomLeftCornerTest() {
		
		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(0, 7), false);
		
		Coordinates[] possibleCoord = new Coordinates[14];
		possibleCoord[0] = new Coordinates(0, 0);
		possibleCoord[13] = new Coordinates(7, 7);
		
		for(int i = 1; i < 7; i++) {
			
			possibleCoord[(i * 2) - 1] = new Coordinates(i, 7);
			possibleCoord[i * 2] = new Coordinates(0, i);
		}
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveBottomRightCornerTest() {
		
		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(7, 7), false);
		
		Coordinates[] possibleCoord = new Coordinates[14];
		
		for(int i = 0; i < 7; i++) {
			
			possibleCoord[i * 2] = new Coordinates(i, 7);
			possibleCoord[(i * 2) + 1] = new Coordinates(7, i);
		}
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveInvalidRowTest() {
		
		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(3, -1), false);
		
		Coordinates[] possibleCoord = {};
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveInvalidColumnTest() {
		
		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(-1, 3), false);
		
		Coordinates[] possibleCoord = {};
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveInvalidColumnRowTest() {
		
		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, new Coordinates(10, 10), false);
		
		Coordinates[] possibleCoord = {};
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveNullTest() {
		
		assertThrows(NullPointerException.class, () -> {
			
			rookToTest.reverseMove(null);
		});
	}
	
	@Test
	void reverseMoveNullPieceTest() {
		
		Move moveToTest = new Move(null, Constants.EMPTY_COORD, new Coordinates(3, 3), false);
		
		int offset = 0;
		Coordinates[] possibleCoord = new Coordinates[14];
		for(int i = 0; i < 7; i++) {
			
			if(i == 3) {
				
				offset = 1;
			}
			
			possibleCoord[i * 2] = new Coordinates(i + offset, 3);
			possibleCoord[(i * 2) + 1] = new Coordinates(3, i + offset);
		}	
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		assertArrayEquals(possibleCoord, listToTest);
		
	}
	
	@Test
	void reverseMoveNullStartTest() {
		
		Move moveToTest = new Move(rookToTest, null, new Coordinates(3, 3), false);
		
		int offset = 0;
		Coordinates[] possibleCoord = new Coordinates[14];
		for(int i = 0; i < 7; i++) {
			
			if(i == 3) {
				
				offset = 1;
			}
			
			possibleCoord[i * 2] = new Coordinates(i + offset, 3);
			possibleCoord[(i * 2) + 1] = new Coordinates(3, i + offset);
		}	
		
		Object[] listToTest = rookToTest.reverseMove(moveToTest).toArray();
		assertArrayEquals(possibleCoord, listToTest);
	}
	
	@Test
	void reverseMoveNullEndTest() {
		
		Move moveToTest = new Move(rookToTest, Constants.EMPTY_COORD, null, false);
		
		assertThrows(NullPointerException.class, () -> {
			
			rookToTest.reverseMove(moveToTest); 
		});
	}
	
	@Test
	void isMovedTest() {
		
		Rook toTest = new Rook(Color.BLACK);
		
		assertFalse(toTest.isMoved());
	}

	@Test
	void setMovedTest() {
		
		Rook toTest = new Rook(Color.BLACK);
		toTest.setMoved(true);
		
		assertTrue(toTest.isMoved());
	}
}
