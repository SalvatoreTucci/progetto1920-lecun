package it.uniba.game.pieces.test;

import it.uniba.game.Constants;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.pieces.Queen;
import it.uniba.game.pieces.Rook;
import it.uniba.game.pieces.Bishop;
import it.uniba.game.Move;
import it.uniba.game.Coordinates;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class QueenTest {

	private final Queen testQueen = new Queen(Color.BLACK);
	
	@Test
	void constructorWhiteTest() {
		
		assertEquals(Constants.W_QUEEN, new Queen(Color.WHITE).toString());
	}
	
	@Test
	void constructorBlackTest() {
		
		assertEquals(Constants.B_QUEEN, testQueen.toString());
	}
	
	@Test
	void reverseMoveCenterTest() {
		
		Coordinates testCoord = new Coordinates(3, 3);
		Move testMove = new Move(testQueen, Constants.EMPTY_COORD, testCoord, false);
		LinkedList<Coordinates> possibleSquares = Rook.reverseRookMove(testMove);
		possibleSquares.addAll(Bishop.reverseBishopMove(testMove));
		
		Coordinates[] squaresToCheck = {
			new Coordinates(0, 3),
			new Coordinates(3,0),
			new Coordinates(1, 3),
			new Coordinates(3, 1),
			new Coordinates(2, 3),
			new Coordinates(3, 2),
			new Coordinates(4, 3),
			new Coordinates(3, 4),
			new Coordinates(5, 3),
			new Coordinates(3, 5),
			new Coordinates(6, 3),
			new Coordinates(3, 6),
			new Coordinates(7, 3),
			new Coordinates(3, 7),
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
		
		assertArrayEquals(squaresToCheck, possibleSquares.toArray());
	}
	
	@Test
	void reverseMoveTopLeftTest() {
		
		Coordinates testCoord = new Coordinates(0, 0);
		Move testMove = new Move(testQueen, Constants.EMPTY_COORD, testCoord, false);
		LinkedList<Coordinates> possibleSquares = testQueen.reverseMove(testMove);
		
		Coordinates[] squaresToCheck = {
				new Coordinates(1, 0),
				new Coordinates(0, 1),
				new Coordinates(2, 0),
				new Coordinates(0, 2),
				new Coordinates(3, 0),
				new Coordinates(0, 3),
				new Coordinates(4, 0),
				new Coordinates(0, 4),
				new Coordinates(5, 0),
				new Coordinates(0, 5),
				new Coordinates(6, 0),
				new Coordinates(0, 6),
				new Coordinates(7, 0),
				new Coordinates(0, 7),
				new Coordinates(1, 1),
				new Coordinates(2, 2),
				new Coordinates(3, 3),
				new Coordinates(4, 4),
				new Coordinates(5, 5),
				new Coordinates(6, 6),
				new Coordinates(7, 7),
		};
		
		assertArrayEquals(squaresToCheck, possibleSquares.toArray());		
	}
	
	@Test
	void reverseMoveTopRightTest() {
		
		Coordinates testCoord = new Coordinates(7, 0);
		Move testMove = new Move(testQueen, Constants.EMPTY_COORD, testCoord, false);
		LinkedList<Coordinates> possibleSquares = testQueen.reverseMove(testMove);

		Coordinates[] squaresToCheck = {
				new Coordinates(0, 0),
				new Coordinates(1, 0),
				new Coordinates(7, 1),
				new Coordinates(2, 0),
				new Coordinates(7, 2),
				new Coordinates(3, 0),
				new Coordinates(7, 3),
				new Coordinates(4, 0),
				new Coordinates(7, 4),
				new Coordinates(5, 0),
				new Coordinates(7, 5),
				new Coordinates(6, 0),
				new Coordinates(7, 6),
				new Coordinates(7, 7),
				new Coordinates(6, 1),
				new Coordinates(5, 2),
				new Coordinates(4, 3),
				new Coordinates(3, 4),
				new Coordinates(2, 5),
				new Coordinates(1, 6),
				new Coordinates(0, 7),
		};
		
		assertArrayEquals(squaresToCheck, possibleSquares.toArray());
	}
	
	@Test
	void reverseMoveBottomLeftTest() {
		
		Coordinates testCoord = new Coordinates(0, 7);
		Move testMove = new Move(testQueen, Constants.EMPTY_COORD, testCoord, false);
		LinkedList<Coordinates> possibleSquares = testQueen.reverseMove(testMove);
		
		Coordinates[] squaresToCheck = {
				new Coordinates(0, 0),
				new Coordinates(1, 7),
				new Coordinates(0, 1),
				new Coordinates(2, 7),
				new Coordinates(0, 2),
				new Coordinates(3, 7),
				new Coordinates(0, 3),
				new Coordinates(4, 7),
				new Coordinates(0, 4),
				new Coordinates(5, 7),
				new Coordinates(0, 5),
				new Coordinates(6, 7),
				new Coordinates(0, 6),
				new Coordinates(7, 7),
				new Coordinates(1, 6),
				new Coordinates(2, 5),
				new Coordinates(3, 4),
				new Coordinates(4, 3),
				new Coordinates(5, 2),
				new Coordinates(6, 1),
				new Coordinates(7, 0),
		};
		
		assertArrayEquals(squaresToCheck, possibleSquares.toArray());
	}

	@Test
	void reverseMoveBottomRightTest() {
		
		Coordinates testCoord = new Coordinates(7, 7);
		Move testMove = new Move(testQueen, Constants.EMPTY_COORD, testCoord, false);
		LinkedList<Coordinates> possibleSquares = testQueen.reverseMove(testMove);
		
		Coordinates[] squaresToCheck = {
				new Coordinates(0, 7),
				new Coordinates(7, 0),
				new Coordinates(1, 7),
				new Coordinates(7, 1),
				new Coordinates(2, 7),
				new Coordinates(7, 2),
				new Coordinates(3, 7),
				new Coordinates(7, 3),
				new Coordinates(4, 7),
				new Coordinates(7, 4),
				new Coordinates(5, 7),
				new Coordinates(7, 5),
				new Coordinates(6, 7),
				new Coordinates(7, 6),
				new Coordinates(6, 6),
				new Coordinates(5, 5),
				new Coordinates(4, 4),
				new Coordinates(3, 3),
				new Coordinates(2, 2),
				new Coordinates(1, 1),
				new Coordinates(0, 0),
		};
		
		assertArrayEquals(squaresToCheck, possibleSquares.toArray());
	}
	
	@Test
	void reverseMoveNegativeTest() {
		
		Coordinates testCoord = new Coordinates(-1, -1);
		assertTrue(testQueen.reverseMove(new Move(testQueen, null, testCoord, false)).isEmpty());
	}
	
	
	@Test
	void reverseMoveColOutOfBoundTest() {
		
		Coordinates testCoord = new Coordinates(15, 4);
		assertTrue(testQueen.reverseMove(new Move(testQueen, null, testCoord, false)).isEmpty());
	}
	
	@Test
	void reverseMoveRowOutOfBoundTest() {
		
		Coordinates testCoord = new Coordinates(2, 21);
		assertTrue(testQueen.reverseMove(new Move(testQueen, null, testCoord, false)).isEmpty());
	}
	
	@Test
	void reverseMoveOutOfBoundTest() {
		
		Coordinates testCoord = new Coordinates(9, 8);
		assertTrue(testQueen.reverseMove(new Move(testQueen, null, testCoord, false)).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPosIntMinTest() {
		
		Coordinates testCoord = new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE);
		assertTrue(testQueen.reverseMove(new Move(testQueen, null, testCoord, false)).isEmpty());
	}
	
	@Test
	void reverseMoveInvalidPosIntMaxTest() {
		
		Coordinates testCoord = new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertTrue(testQueen.reverseMove(new Move(testQueen, null, testCoord, false)).isEmpty());
	}
	
}
