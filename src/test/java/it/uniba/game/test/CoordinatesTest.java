package it.uniba.game.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniba.game.Coordinates;


public class CoordinatesTest {
	
	
	@Test
	void getRowPositiveValueTest() {
		
		Coordinates toTest = new Coordinates(3,4);
		assertEquals(4, toTest.getRow());
	}
	
	@Test
	void getRowNegativeValueTest() {
		
		Coordinates toTest = new Coordinates(3,-4);
		assertEquals(-4, toTest.getRow());
	}
	
	@Test
	void getRowZeroTest() {
		
		Coordinates toTest = new Coordinates(3,0);
		assertEquals(0, toTest.getRow());
	}
	
	@Test
	void getRowIntMaxTest() {
		
		Coordinates toTest = new Coordinates(3, Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, toTest.getRow());
	}
	
	@Test
	void getRowIntMinTest() {
		
		Coordinates toTest = new Coordinates(3, Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, toTest.getRow());
	}
	
	@Test
	void getRowNullTest() {
		Integer numberToTest = null;
		assertThrows(NullPointerException.class, () -> {
			new Coordinates(3, numberToTest);
		});
	}
	
	@Test
	void getColumnPositiveValueTest() {
		
		Coordinates toTest = new Coordinates(3,4);
		assertEquals(3, toTest.getColumn());
	}
	
	@Test
	void getColumnNegativeValueTest() {
		
		Coordinates toTest = new Coordinates(-3, 4);
		assertEquals(-3, toTest.getColumn());
	}
	
	@Test
	void getColumnZeroTest() {
		
		Coordinates toTest = new Coordinates(0, 4);
		assertEquals(0, toTest.getColumn());
	}
	
	@Test
	void getColumnIntMaxTest() {
		
		Coordinates toTest = new Coordinates(Integer.MAX_VALUE, 3);
		assertEquals(Integer.MAX_VALUE, toTest.getColumn());
	}
	
	@Test
	void getColumnIntMinTest() {
		
		Coordinates toTest = new Coordinates(Integer.MIN_VALUE, 4);
		assertEquals(Integer.MIN_VALUE, toTest.getColumn());
	}
	/*
	@Test
	void getColumnNullTest() {
		Integer numberToTest = null;
		assertThrows(NullPointerException.class, () -> {
			new Coordinates(numberToTest, 3);
		});
	}
	*/
}
