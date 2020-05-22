package it.uniba.game.board.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;
import it.uniba.game.board.Square;
import it.uniba.game.pieces.Piece;
import it.uniba.game.pieces.Pawn;

class SquareTest {
	
	private final Square squareNull    = new Square(null);
	private final Square squareNotNull = new Square(new Pawn(Piece.Color.BLACK));

	@Test
	void getPieceNullTest() {
		assertNull(squareNull.getPiece());
	}
	
	@Test
	void getPieceNotNullTest() {
		assertEquals(new Pawn(Piece.Color.BLACK), squareNotNull.getPiece());
	}
	
	@Test
	void isOccupiedNullTest() {
		assertFalse(squareNull.isOccupied());
	}
	
	@Test
	void isOccupiedNotNullTest() {
		assertTrue(squareNotNull.isOccupied());
	}
}
