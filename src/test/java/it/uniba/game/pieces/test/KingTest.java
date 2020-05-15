package it.uniba.game.pieces.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import it.uniba.game.Coordinates;
import it.uniba.game.Move;
import it.uniba.game.pieces.King;
import it.uniba.game.pieces.Piece;
import it.uniba.game.Constants;

public class KingTest {
	
	private final King testKing = new King(Piece.Color.WHITE);

	@Test
	void constructorWhiteTest() {

		assertEquals(Constants.W_KING, testKing.toString());
	}

	@Test
	void constructorBlackTest() {

		assertEquals(Constants.B_KING, new King(Piece.Color.BLACK).toString());
	}
	
	@Test
	public void reverseMoveCorrectCentralTest() {		
		
		Object[] reverseMoveResult = testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(3,3), false)).toArray();
				
		Object[] expectedResult = {
				new Coordinates(2,2),
				new Coordinates(3,2),
				new Coordinates(4,2),
				new Coordinates(2,3),
				new Coordinates(4,3),
				new Coordinates(2,4),
				new Coordinates(3,4),
				new Coordinates(4,4)
		};
		
		assertArrayEquals(expectedResult, reverseMoveResult);
	}
	
	@Test
	public void reverseMoveTopLeftCornerTest() {
		
		Object[] reverseMoveResult = testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(0,0), false)).toArray();
		
		Object[] expectedResult = {
				new Coordinates(1,0),
				new Coordinates(0,1),
				new Coordinates(1,1)
		};
		
		assertArrayEquals(expectedResult, reverseMoveResult);
	}
	
	@Test
	public void reverseMoveTopRightCornerTest() {
		
		Object[] reverseMoveResult = testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(7,0), false)).toArray();
		
		Object[] expectedResult = {
				new Coordinates(6,0),
				new Coordinates(6,1),
				new Coordinates(7,1)
		};
		
		assertArrayEquals(expectedResult, reverseMoveResult);
	}
	
	@Test
	public void reverseMoveBottomRightCornerTest() {	
		
		Object[] reverseMoveResult = testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(7,7), false)).toArray();
		
		Object[] expectedResult = {
				new Coordinates(6,6),
				new Coordinates(7,6),
				new Coordinates(6,7)
		};
		
		assertArrayEquals(expectedResult, reverseMoveResult);
	}
	
	@Test
	public void reverseMoveBottomLeftCornerTest() {	
		
		Object[] reverseMoveResult = testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(0,7), false)).toArray();
		
		Object[] expectedResult = {
				new Coordinates(0,6),
				new Coordinates(1,6),
				new Coordinates(1,7)
		};
		
		assertArrayEquals(expectedResult, reverseMoveResult);
	}
	
	@Test
	public void reverseMoveOutOfBoundRowTest() {
		
		assertTrue(testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(7,-2), false)).isEmpty());
	}
	
	@Test
	public void reverseMoveOutOfBoundColumnTest() {	
		
		assertTrue(testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(8,0), false)).isEmpty());
	}

	
	@Test
	public void reverseMoveOutOfBoundBothTest() {
		
		assertTrue(testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				new Coordinates(-3,10), false)).isEmpty());
	}
	
	@Test
	public void reverseMoveNullMoveTest() {	
		
		assertThrows(NullPointerException.class, () ->testKing.reverseMove(null));
	}
	
	@Test
	public void reverseMoveNullPieceTest() {
		
		Object[] reverseMoveResult = testKing.reverseMove(new Move(null,
				Constants.EMPTY_COORD,
				new Coordinates(3,3), false)).toArray();
		
		Object[] expectedResult = {
				new Coordinates(2,2),
				new Coordinates(3,2),
				new Coordinates(4,2),
				new Coordinates(2,3),
				new Coordinates(4,3),
				new Coordinates(2,4),
				new Coordinates(3,4),
				new Coordinates(4,4)
		};
		assertArrayEquals(expectedResult, reverseMoveResult);
	}
	
	@Test
	public void reverseMoveNullStartTest() {
		
		Object[] reverseMoveResult = testKing.reverseMove(new Move(testKing,
				null,
				new Coordinates(3,3), false)).toArray();
				
		Object[] expectedResult = {
				new Coordinates(2,2),
				new Coordinates(3,2),
				new Coordinates(4,2),
				new Coordinates(2,3),
				new Coordinates(4,3),
				new Coordinates(2,4),
				new Coordinates(3,4),
				new Coordinates(4,4)
		};
		assertArrayEquals(expectedResult, reverseMoveResult);
	}
	
	@Test
	public void reverseMoveEndMoveTest() {
		
		assertThrows(NullPointerException.class, () ->testKing.reverseMove(new Move(testKing,
				Constants.EMPTY_COORD,
				null, false)));
	}
	
	@Test
	public void isMovedTest() {
		
		assertFalse(new King(Piece.Color.BLACK).isMoved());
	}
	
	@Test
	public void setMovedTrueTest() {
		
		King movedKing = new King(Piece.Color.BLACK);
		movedKing.setMoved(true);
		
		assertTrue(movedKing.isMoved());
	}

	
}
