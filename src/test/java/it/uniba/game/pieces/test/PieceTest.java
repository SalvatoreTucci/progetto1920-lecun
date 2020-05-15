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
	
	@Test
	void constructorWhiteTest() {
		Bishop toTest = new Bishop(Color.WHITE);
		assertEquals(Color.WHITE, toTest.getColor());
	}

	@Test
	void constructorBlackTest() {
		
		Bishop toTest = new Bishop(Color.BLACK);
		assertEquals(Color.BLACK, toTest.getColor());
	}
	
	@Test
	void constructorNullTest() {
		
		Bishop toTest = new Bishop(null);
		assertEquals(Color.WHITE, toTest.getColor());
	}
	
	@Test
	void equalsBothEqualsTest() {
		Bishop firstToTest = new Bishop(Color.WHITE);
		Bishop secondToTest = new Bishop(Color.WHITE);
		assertTrue(firstToTest.equals(secondToTest));
	}
	
	@Test
	void equalsDifferentTest() {
		Bishop firstToTest = new Bishop(Color.WHITE);
		Bishop secondToTest = new Bishop(Color.BLACK);
		assertFalse(firstToTest.equals(secondToTest));
	}
	
}
