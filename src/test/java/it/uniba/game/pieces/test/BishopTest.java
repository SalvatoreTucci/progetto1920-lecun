package it.uniba.game.pieces.test;

import it.uniba.game.pieces.Bishop;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class BishopTest {
	
	private final Bishop testBishop = new Bishop(Color.BLACK);
	
	@Test
	void constructorWhiteTest() {
		
		assertEquals(Constants.W_BISHOP, new Bishop(Color.WHITE).toString());
	}
	
	@Test
	void constructorBlackTest() {
		
		assertEquals(Constants.B_BISHOP, new Bishop(Color.BLACK).toString());
	}
	
	@Test
	void reverseBishopMoveCenterTest() {
		
		// tests reverseBishopMove from a central chessboard square
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(3, 3), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);
		
		// these are the possible squares where the bishop can move starting from (3, 3)
		Coordinates[] possibleCoord = {
				new Coordinates(4, 4),
				new Coordinates(5, 5),
				new Coordinates(6, 6),
				new Coordinates(7, 7),
				new Coordinates(2, 2),
				new Coordinates(1, 1),
				new Coordinates(0, 0),
				new Coordinates(2, 4),
				new Coordinates(1, 5),
				new Coordinates(0, 6),
				new Coordinates(4, 2),
				new Coordinates(5, 1),
				new Coordinates(6, 0),
		};
		
		Object[] arrayToCheck = startingSquares.toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseBishopMoveTopLeftTest() {
		
		// tests reverseBishopMove starting from the coordinate (0,0)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(0, 0), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);

		Coordinates[] possibleCoord = new Coordinates[7];
		for(int i = 0; i < possibleCoord.length; i++) {
			
			possibleCoord[i] = new Coordinates(i + 1, i + 1);
		}
		
		Object[] arrayToCheck = startingSquares.toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseBishopMoveBottomLeftTest() {
		
		// tests reverseBishopMove starting from the coordinate (0, 7)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(0, 7), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);

		Coordinates[] possibleCoord = new Coordinates[7];
		for(int i = 0; i < possibleCoord.length; i++) {
			
			possibleCoord[i] = new Coordinates(i + 1, 6 - i);
		}
		
		Object[] arrayToCheck = startingSquares.toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseBishopMoveTopRightTest() {
		
		// tests reverseBishopMove starting from the coordinate (7, 0)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(7, 0), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);

		Coordinates[] possibleCoord = new Coordinates[7];
		for(int i = 0; i < possibleCoord.length; i++) {
			
			possibleCoord[i] = new Coordinates(6 - i, i + 1);
		}
		
		Object[] arrayToCheck = startingSquares.toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseBishopMoveBottomRightTest() {
		
		// tests reverseBishopMove starting from the coordinate (7, 7)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(7, 7), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);

		Coordinates[] possibleCoord = new Coordinates[7];
		for(int i = 0; i < possibleCoord.length; i++) {
			
			possibleCoord[i] = new Coordinates(6 - i, 6 - i);
		}
		
		Object[] arrayToCheck = startingSquares.toArray();
		assertArrayEquals(possibleCoord, arrayToCheck);
	}
	
	@Test
	void reverseBishopMoveNegativeCoordTest() {
		
		// tests reverseBishopMove starting from the invalid coordinate (-1, -1)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(-1, -1), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);
	
		assertTrue(startingSquares.isEmpty());
	}
	
	@Test
	void reverseBishopMoveColOutOfBoundsCoordTest() {
		
		// tests reverseBishopMove starting from the invalid coordinate (9, 3)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(9, 3), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);
	
		assertTrue(startingSquares.isEmpty());
	}
	
	@Test
	void reverseBishopMoveRowOutOfBoundsCoordTest() {
		
		// tests reverseBishopMove starting from the invalid coordinate (5, 13)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(5, 13), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);
	
		assertTrue(startingSquares.isEmpty());
	}
	
	@Test
	void reverseBishopMoveOutOfBoundsTest() {
		
		// tests reverseBishopMove starting from the invalid coordinate (13, 32)
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(13, 32), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);
	
		assertTrue(startingSquares.isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPosIntMinTest() {
		
		// tests reverseBishopMove starting from the invalid coordinate with minimum integer values
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);
			
		assertTrue(startingSquares.isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPosIntMaxTest() {
		
		// tests reverseBishopMove starting from the invalid coordinate with maximum integer values
		Move inputMove = new Move(new Bishop(Color.BLACK), null, new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE), false);
		LinkedList<Coordinates> startingSquares = testBishop.reverseMove(inputMove);
			
		assertTrue(startingSquares.isEmpty());
	}
}
