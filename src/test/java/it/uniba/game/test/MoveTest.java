package it.uniba.game.test;

import it.uniba.game.Move;
import it.uniba.game.Move.Castling;
import it.uniba.game.Coordinates;
import it.uniba.game.pieces.*;
import it.uniba.game.pieces.Piece.Color;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MoveTest {
	
	// Reading Methods Tests

	@Test
	void getPieceBlackTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.BLACK);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Pawn(Color.BLACK), toTest.getPiece());
	}
	
	@Test
	void getPieceWhiteTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Pawn(Color.WHITE), toTest.getPiece());
	}
	
	@Test
	void getPieceNullTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		
		Move toTest = new Move(null, coord1, coord2, false);
		assertEquals(null, toTest.getPiece());
	}
	
	@Test
	void getCaptureFlagTrueTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, true);
		assertEquals(true, toTest.getCaptureFlag());
	}
	
	@Test
	void getCaptureFlagFalseTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(false, toTest.getCaptureFlag());
	}
	
	@Test
	void getEnPassantFalseTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(false, toTest.getCaptureFlag());
	}
	
	@Test
	void getEnPassantTrueTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		toTest.setEnPassant();
		assertEquals(true, toTest.getEnPassant());
	}
	
	@Test
	void getStaringPosStandardCoordsTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(3, 4), toTest.getStartingPos());
	}
	
	@Test
	void getStartingPosZeroCoordsTest() {
		
		Coordinates coord1 = new Coordinates(0, 0);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(0, 0), toTest.getStartingPos());
	}
	
	@Test
	void getStartingPosMaxCoordsTest() {
		
		Coordinates coord1 = new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE), toTest.getStartingPos());
	}
	
	@Test
	void getStartingPosMinCoordsTest() {
		
		Coordinates coord1 = new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE), toTest.getStartingPos());
	}
	
	@Test
	void getStartingPosNullTest() {
		
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, null, coord2, false);
		assertEquals(null, toTest.getStartingPos());
	}
	
	@Test
	void getEndingPosStandardCoordsTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(7, 3);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(7, 3), toTest.getEndingPos());
	}
	
	@Test
	void getEndingPosZeroCoordsTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(0, 0);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(0, 0), toTest.getEndingPos());
	}
	
	@Test
	void getEndingPosMaxCoordsTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(Integer.MAX_VALUE, Integer.MAX_VALUE), toTest.getEndingPos());
	}
	
	@Test
	void getEndingPosMinCoordsTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(new Coordinates(Integer.MIN_VALUE, Integer.MIN_VALUE), toTest.getEndingPos());
	}
	
	@Test
	void getEndingPosNullCoordsTest() {

		Coordinates coord1 = new Coordinates(3, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, null, false);
		assertEquals(null, toTest.getEndingPos());
	}
	
	@Test
	void getCastlingNoCastlingTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		assertEquals(Castling.NO_CASTLING, toTest.getCastling());
	}
	
	@Test
	void getCastlingQueenTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		toTest.setCastling(Castling.QUEENSIDE_CASTLING);
		assertEquals(Castling.QUEENSIDE_CASTLING, toTest.getCastling());
	}
	
	@Test
	void getCastlingKingTest() {
		
		Coordinates coord1 = new Coordinates(3, 4);
		Coordinates coord2 = new Coordinates(5, 4);
		Piece toSet = new Pawn(Color.WHITE);
		
		Move toTest = new Move(toSet, coord1, coord2, false);
		toTest.setCastling(Castling.KINGSIDE_CASTLING);
		assertEquals(Castling.KINGSIDE_CASTLING, toTest.getCastling());
	}
	
}
