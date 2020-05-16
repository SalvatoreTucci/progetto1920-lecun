package it.uniba.game.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;

import it.uniba.game.Match;
import it.uniba.game.MatchException;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.Constants;


public class MatchTest {

	private static Match testMatch;

	@BeforeEach
	public void matchSetup() {
    	
		testMatch = new Match();
	}
	
	
	
	
	
	
	
	@Test
	public void getPrintableCapturesWhiteEmptyTest() {
		
		assertEquals("[]", testMatch.getPrintableCaptures(Color.WHITE));
		
	}
	
	@Test
	public void getPrintableCapturesBlackEmptyTest() {
		
		assertEquals("[]", testMatch.getPrintableCaptures(Color.BLACK));
	}
	
	@Test
	public void getPrintableCapturesWhiteNonEmptyTest() {
		try {
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("exd6");
		} catch (MatchException e) {
			//the test fails if inputMove doesn't work as it should
			fail();
		}
		assertEquals("[" + Constants.B_PAWN +"]", testMatch.getPrintableCaptures(Color.WHITE));
		
	}
	
	@Test
	public void getPrintableCapturesBlackNonEmptyTest() {
		try {
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("c5");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove("c4");
			testMatch.nextTurn();
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("cxd3");
		} catch (MatchException e) {
			fail();
		}
		assertEquals("[" + Constants.W_PAWN +"]", testMatch.getPrintableCaptures(Color.BLACK));
	}
	
	
	public void getPrintableCapturesNullColorTest() {
		try {
			testMatch.inputMove("b4");
			testMatch.nextTurn();
			testMatch.inputMove("Cc6");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Cxb4");
		} catch (MatchException e) {
			fail();
		}
		assertEquals("[" + Constants.W_PAWN +"]", testMatch.getPrintableCaptures(null));
	}
	
	@Test
	public void getPrintableCapturesBothGenericTest() {
		try {
			testMatch.inputMove("Cc3");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("Cxd5");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("Cxc7");
			testMatch.nextTurn();
			testMatch.inputMove("Dxc7");
			testMatch.nextTurn();
			testMatch.inputMove("c3");
			testMatch.nextTurn();
			testMatch.inputMove("Dxc3");
			testMatch.nextTurn();
			testMatch.inputMove("dxc3");
		} catch (MatchException e) {
			fail();
		}
		assertAll( ()->{
			assertEquals("[" +Constants.W_KNIGHT +", "
					+ Constants.W_PAWN
					+ "]", testMatch.getPrintableCaptures(Color.BLACK));
			assertEquals("[" + Constants.B_PAWN + ", "
					+ Constants.B_PAWN +", "
					+ Constants.B_QUEEN
					+ "]", testMatch.getPrintableCaptures(Color.WHITE));
			});
	
	}
	
	@Test
	public void getCurrentPlayerTest() {
		assertEquals(Color.WHITE, testMatch.getCurrentPlayer());
	}
	
	@Test
	public void nextTurnTest() {
		testMatch.nextTurn();
		assertEquals(Color.BLACK, testMatch.getCurrentPlayer());
	}
	
	@Test
	public void getPrintableMovesEmptyTest() {
		assertTrue(testMatch.getPrintableMoves().isEmpty());
	}
	
	@Test
	public void getPrintableMovesNotEmptyTest() {
		try {
			testMatch.inputMove("Ch3");
			testMatch.nextTurn();
			testMatch.inputMove("g5");
			testMatch.nextTurn();
			testMatch.inputMove("Cxg5");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("g3");
			testMatch.nextTurn();
			testMatch.inputMove("Dd6");
			testMatch.nextTurn();
			testMatch.inputMove("Ah3");
			testMatch.nextTurn();
			testMatch.inputMove("Rd8");
			testMatch.nextTurn();
			testMatch.inputMove("O-O");
		} catch (MatchException e) {
			fail();
		}
		String expectedMoves = "\n1. Ch3 g5\n"
				+ "2. Cxg5 d5\n"
				+ "3. g3 Dd6\n"
				+ "4. Ah3 Rd8\n"
				+"5. O-O ";
		assertEquals(expectedMoves, testMatch.getPrintableMoves());

	}
	
	
}

