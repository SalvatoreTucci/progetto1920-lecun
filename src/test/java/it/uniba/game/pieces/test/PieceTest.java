package it.uniba.game.pieces.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import it.uniba.game.pieces.Bishop;
import it.uniba.game.pieces.Piece.Color;


public class PieceTest {
	
	//this is an abstract class, but some methods are public
	//and so they have to be tested: 
	//- the constructor
	//- getColor
	//- equals
	//The subclass Bishop will be used in order to do
	//these tests
	
	private final Bishop testBishop = new Bishop(Color.WHITE);
	
	@Test
	void constructorWhiteTest() {

		assertEquals(Color.WHITE, testBishop.getColor());
	}

	@Test
	void constructorBlackTest() {
		
		Bishop secondToTest = new Bishop(Color.BLACK);
		assertEquals(Color.BLACK, secondToTest.getColor());
	}
	
	@Test
	void constructorNullTest() {
		
		Bishop secondToTest = new Bishop(null);
		assertEquals(Color.WHITE, secondToTest.getColor());
	}
	
	@Test
	void equalsBothEqualsTest() {

		Bishop secondToTest = new Bishop(Color.WHITE);
		assertTrue(testBishop.equals(secondToTest));
	}
	
	@Test
	void equalsDifferentTest() {
		
		Bishop secondToTest = new Bishop(Color.BLACK);
		assertFalse(testBishop.equals(secondToTest));
	}
	
	@Test
	void equalsNullTest() {
		
		assertFalse(testBishop.equals(null));
	}
	
}
