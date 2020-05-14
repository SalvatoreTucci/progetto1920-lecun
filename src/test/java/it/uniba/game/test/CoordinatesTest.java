package it.uniba.game.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import it.uniba.game.Coordinates;


public class CoordinatesTest {
	
	@Test
	public void setRowPositiveValueTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setRow(4);
		assertEquals(4, toTest.getRow());
	}
	
	@Test
	public void setRowNegativeValueTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setRow(-4);
		assertEquals(-4, toTest.getRow());
	}
	
	@Test
	public void setRowZeroValueTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setRow(0);
		assertEquals(0, toTest.getRow());
	}
	
	@Test
	public void setRowIntMaxTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setRow(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, toTest.getRow());
	}
	
	@Test
	public void setRowIntMinTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setRow(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, toTest.getRow());
	}

	@Test
	public void setColumnPositiveValueTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setColumn(4);
		assertEquals(4, toTest.getColumn());
	}
	
	@Test
	public void setColumnNegativeValueTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setColumn(-4);
		assertEquals(-4, toTest.getColumn());
	}
	
	@Test
	public void setColumnZeroValueTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setColumn(0);
		assertEquals(0, toTest.getColumn());
	}
	
	@Test
	public void setColumnIntMaxTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setColumn(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, toTest.getColumn());
	}
	
	@Test
	public void setColumnIntMinTest() {
		
		Coordinates toTest = new Coordinates(3, 3);
		toTest.setColumn(Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, toTest.getColumn());
	}
	
	@Test
	public void getRowPositiveValueTest() {
		
		Coordinates toTest = new Coordinates(3,4);
		assertEquals(4, toTest.getRow());
	}
	
	@Test
	public void getRowNegativeValueTest() {
		
		Coordinates toTest = new Coordinates(3,-4);
		assertEquals(-4, toTest.getRow());
	}
	
	@Test
	public void getRowZeroTest() {
		
		Coordinates toTest = new Coordinates(3,0);
		assertEquals(0, toTest.getRow());
	}
	
	@Test
	public void getRowIntMaxTest() {
		
		Coordinates toTest = new Coordinates(3, Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, toTest.getRow());
	}
	
	@Test
	public void getRowIntMinTest() {
		
		Coordinates toTest = new Coordinates(3, Integer.MIN_VALUE);
		assertEquals(Integer.MIN_VALUE, toTest.getRow());
	}
	
	@Test
	public void getColumnPositiveValueTest() {
		
		Coordinates toTest = new Coordinates(3,4);
		assertEquals(3, toTest.getColumn());
	}
	
	@Test
	public void getColumnNegativeValueTest() {
		
		Coordinates toTest = new Coordinates(-3, 4);
		assertEquals(-3, toTest.getColumn());
	}
	
	@Test
	public void getColumnZeroTest() {
		
		Coordinates toTest = new Coordinates(0, 4);
		assertEquals(0, toTest.getColumn());
	}
	
	@Test
	public void getColumnIntMaxTest() {
		
		Coordinates toTest = new Coordinates(Integer.MAX_VALUE, 3);
		assertEquals(Integer.MAX_VALUE, toTest.getColumn());
	}
	
	@Test
	public void getColumnIntMinTest() {
		
		Coordinates toTest = new Coordinates(Integer.MIN_VALUE, 4);
		assertEquals(Integer.MIN_VALUE, toTest.getColumn());
	}
	
	@Test
	public void toStringTestDefault() {
		
		Coordinates toTest = new Coordinates(3, 4);
		assertEquals("(" + toTest.getColumn() + ", " + toTest.getRow() + ")", toTest.toString());
	}
	
	@Test
	public void equalsSameValuesTest() {
		
		Coordinates firstToTest = new Coordinates(3, 4);
		Coordinates secondToTest = new Coordinates(3, 4);
		
		assertTrue(firstToTest.equals(secondToTest));
	}
	
	@Test
	public void equalsFirstValueDifferentTest() {
		Coordinates firstToTest = new Coordinates(3, 3);
		Coordinates secondToTest = new Coordinates(4, 3);
			
		assertFalse(firstToTest.equals(secondToTest));
	}
	
	@Test
	public void equalsSecondValueDifferentTest() {
		Coordinates firstToTest = new Coordinates(4, 4);
		Coordinates secondToTest = new Coordinates(4, 3);
			
		assertFalse(firstToTest.equals(secondToTest));
	}
	
	@Test
	public void equalsBothDifferentTest() {
		Coordinates firstToTest = new Coordinates(2, 2);
		Coordinates secondToTest = new Coordinates(4, 3);
			
		assertFalse(firstToTest.equals(secondToTest));
	}
	
}
