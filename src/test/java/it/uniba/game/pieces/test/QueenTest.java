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
		
		/*
		 * tests the normal behaviour of the reverseMove method for the Queen, starting from coordinate (3, 3)
		 * to build the list of coordinates to check against the output of the method reverseMove, it is used
		 * the reverseMove method from Bishop and Rook
		 */
		Coordinates testCoord = new Coordinates(3, 3);
		LinkedList<Coordinates> coordinatesToTest = testQueen.reverseMove(new Move(testQueen, null, testCoord, false));
		Move testMove = new Move(null, null, testCoord, false);
		LinkedList<Coordinates> possibleSquares = Rook.reverseRookMove(testMove);
		possibleSquares.addAll(Bishop.reverseBishopMove(testMove));
		
		assertEquals(possibleSquares, coordinatesToTest);
	}
	
	@Test
	void reverseMoveTopLeftTest() {
		
		Coordinates testCoord = new Coordinates(0, 0);
		LinkedList<Coordinates> coordinatesToTest = testQueen.reverseMove(new Move(testQueen, null, testCoord, false));
		Move testMove = new Move(null, null, testCoord, false);
		LinkedList<Coordinates> possibleSquares = Rook.reverseRookMove(testMove);
		possibleSquares.addAll(Bishop.reverseBishopMove(testMove));
		
		assertEquals(possibleSquares, coordinatesToTest);		
	}
	
	@Test
	void reverseMoveTopRightTest() {
		
		Coordinates testCoord = new Coordinates(7, 0);
		LinkedList<Coordinates> coordinatesToTest = testQueen.reverseMove(new Move(testQueen, null, testCoord, false));
		Move testMove = new Move(null, null, testCoord, false);
		LinkedList<Coordinates> possibleSquares = Rook.reverseRookMove(testMove);
		possibleSquares.addAll(Bishop.reverseBishopMove(testMove));
		
		assertEquals(possibleSquares, coordinatesToTest);
	}
	
	@Test
	void reverseMoveBottomLeftTest() {
		
		Coordinates testCoord = new Coordinates(0, 7);
		LinkedList<Coordinates> coordinatesToTest = testQueen.reverseMove(new Move(testQueen, null, testCoord, false));
		Move testMove = new Move(null, null, testCoord, false);
		LinkedList<Coordinates> possibleSquares = Rook.reverseRookMove(testMove);
		possibleSquares.addAll(Bishop.reverseBishopMove(testMove));
		
		assertEquals(possibleSquares, coordinatesToTest);
	}

	@Test
	void reverseMoveBottomRightTest() {
		
		Coordinates testCoord = new Coordinates(7, 7);
		LinkedList<Coordinates> coordinatesToTest = testQueen.reverseMove(new Move(testQueen, null, testCoord, false));
		Move testMove = new Move(null, null, testCoord, false);
		LinkedList<Coordinates> possibleSquares = Rook.reverseRookMove(testMove);
		possibleSquares.addAll(Bishop.reverseBishopMove(testMove));
		
		assertEquals(possibleSquares, coordinatesToTest);
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
	
}
