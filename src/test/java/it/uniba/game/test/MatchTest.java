package it.uniba.game.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import it.uniba.game.Match;
import it.uniba.game.MatchException;

public class MatchTest {
	
	private static Match testMatch;
	
	@BeforeEach
	public void matchSetup() {
		
		testMatch = new Match();
	}

	@Test
	public void inputMoveWhitePawnMoveTest() {
		
		try {
			
			String testMove = "e4";
			testMatch.inputMove(testMove);
			assertTrue(testMatch.getPrintableMoves().contains(testMove));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackPawnMoveTest() {
		
		try {
			
			String testMove = "e5";
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove(testMove);
			assertTrue(testMatch.getPrintableMoves().contains(testMove));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteKnightMoveTest() {
		
		try {
			
			String testMove = "Cf3";
			testMatch.inputMove(testMove);
			assertTrue(testMatch.getPrintableMoves().contains(testMove));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackKnightMoveTest() {
		
		try {
			
			String testMove = "Cc6";
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove(testMove);
			assertTrue(testMatch.getPrintableMoves().contains(testMove));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteBishopMoveTest() {
		
		try {
			
			String testMove = "Ac4";
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove(testMove);
			assertTrue(testMatch.getPrintableMoves().contains(testMove));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackBishopMoveTest() {
		
		try {
			
			String toParse = "Ac5";
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteRookMoveTest() {
		
		try {
			
			String toParse = "Th3";
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			testMatch.inputMove("h5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackRookMoveTest() {
		
		try {
			
			String toParse = "Th6";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("h5");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteQueenMoveTest() {
		
		try {
			
			String toParse = "Dh5";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
		
	}
	
	@Test
	public void inputMoveBlackQueenMoveTest() {
		
		try {
			
			String toParse = "Dd6";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("b3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteKingMoveTest() {
		
		try {
			
			String toParse = "Re2";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackKingMoveTest() {
		
		try {
			
			String toParse = "Re7";
			testMatch.inputMove("b4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("h3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteQueenSideCastlingTest() {
		
		try {
			
			String toParse = "0-0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Df3");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("Cf6");
			testMatch.nextTurn();
			testMatch.inputMove("Ad2");
			testMatch.nextTurn();
			testMatch.inputMove("Cg4");
			testMatch.nextTurn();
			testMatch.inputMove("Ca3");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteQueenSideCastlingAlternativeTest() {
		
		try {
			
			String toParse = "O-O-O";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Df3");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("Cf6");
			testMatch.nextTurn();
			testMatch.inputMove("Ad2");
			testMatch.nextTurn();
			testMatch.inputMove("Cg4");
			testMatch.nextTurn();
			testMatch.inputMove("Ca3");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteKingSideCastlingTest() {
		
		try {
			
			String toParse = "0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Ac4");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("Cf3");
			testMatch.nextTurn();
			testMatch.inputMove("h6");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteKingSideCastlingAlternativeTest() {
		
		try {
			
			String toParse = "O-O";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Ac4");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("Cf3");
			testMatch.nextTurn();
			testMatch.inputMove("h6");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackQueenSideCastlingTest() {
		
		try {
			
			String toParse = "0-0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Ad7");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("Ca6");
			testMatch.nextTurn();
			testMatch.inputMove("Cf3");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackQueenSideCastlingAlternativeTest() {
		
		try {
			
			String toParse = "O-O-O";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Ad7");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("Ca6");
			testMatch.nextTurn();
			testMatch.inputMove("Cf3");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackKingSideCastlingTest() {
		
		try {
			
			String toParse = "0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("Ab4");
			testMatch.nextTurn();
			testMatch.inputMove("Dd2");
			testMatch.nextTurn();
			testMatch.inputMove("Cf6");
			testMatch.nextTurn();
			testMatch.inputMove("h3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackKingSideCastlingAlternativeTest() {
		
		try {
			
			String toParse = "O-O";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("Ab4");
			testMatch.nextTurn();
			testMatch.inputMove("Dd2");
			testMatch.nextTurn();
			testMatch.inputMove("Cf6");
			testMatch.nextTurn();
			testMatch.inputMove("h3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteEnPassantTest() {
		
		try {
			
			String toParse = "exd6";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
		}
	}
	
	@Test
	public void inputMoveWhiteEnPassantAlternativeTest() {
		
		try {
			
			String toParse = "exd6 e.p.";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackEnPassantTest() {
		
		try {
			
			String toParse = "dxe3";
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackEnPassantAlternativeTest() {
		
		try {
			
			String toParse = "dxe3 e.p.";
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhitePinnedPieceTest() {
		
		try {
			
			String toParse = "f6";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Dh5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackPinnedPieceTest() {
		
		try {
			
			String toParse = "d4";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Cf3");
			testMatch.nextTurn();
			testMatch.inputMove("Ab4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveInvalidTest() {

			String toParse = "Th8";
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	public void inputMoveWhiteInvalidKingSideCastlingTest() {
		
		try {
			
			String toParse = "0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Ac4");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("Cf3");
			testMatch.nextTurn();
			testMatch.inputMove("h6");
			testMatch.nextTurn();
			testMatch.inputMove("Rf1");
			testMatch.nextTurn();
			testMatch.inputMove("h5");
			testMatch.nextTurn();
			testMatch.inputMove("Re1");
			testMatch.nextTurn();
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> {testMatch.inputMove(toParse); } );
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveWhiteInvalidQueenSideCastlingTest() {
		
		try {
			
			String toParse = "0-0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Df3");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("Cf6");
			testMatch.nextTurn();
			testMatch.inputMove("Ad2");
			testMatch.nextTurn();
			testMatch.inputMove("Cg4");
			testMatch.nextTurn();
			testMatch.inputMove("Ca3");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			testMatch.inputMove("Tb1");
			testMatch.nextTurn();
			testMatch.inputMove("h5");
			testMatch.nextTurn();
			testMatch.inputMove("Ta1");
			testMatch.nextTurn();
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackInvalidKingSideCastlingTest() {
		
		try {
			
			String toParse = "0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("Ab4");
			testMatch.nextTurn();
			testMatch.inputMove("Dd2");
			testMatch.nextTurn();
			testMatch.inputMove("Cf6");
			testMatch.nextTurn();
			testMatch.inputMove("h3");
			testMatch.nextTurn();
			testMatch.inputMove("Rf8");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Re8");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveBlackInvalidQueenSideCastlingTest() {
		
		try {
			
			String toParse = "0-0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Ad7");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("Ca6");
			testMatch.nextTurn();
			testMatch.inputMove("Cf3");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			testMatch.nextTurn();
			testMatch.inputMove("c3");
			testMatch.nextTurn();
			testMatch.inputMove("Rd8");
			testMatch.nextTurn();
			testMatch.inputMove("c4");
			testMatch.nextTurn();
			testMatch.inputMove("Re8");
			testMatch.nextTurn();
			testMatch.inputMove("c5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.getPrintableMoves().contains(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveThreatCastlingTest() {
		
		try {
			
			String toParse = "0-0";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Ac4");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("Ch3");
			testMatch.nextTurn();
			testMatch.inputMove("h6");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Dg5");
			testMatch.nextTurn();
			testMatch.inputMove("f3");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.getPrintableMoves().contains(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveEnPassantPinnedTest() {
		
		try {
			
			String toParse = "dxe6";
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("b5");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("Ab7");
			testMatch.nextTurn();
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove("h6");
			testMatch.nextTurn();
			testMatch.inputMove("Re2");
			testMatch.nextTurn();
			testMatch.inputMove("h5");
			testMatch.nextTurn();
			testMatch.inputMove("Rd3");
			testMatch.nextTurn();
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			testMatch.inputMove("Re4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.getPrintableMoves().contains(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
	
	@Test
	public void inputMoveFirstRookMoveThreadTest() {

		try {
			
			String toParse = "Tg1";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Ac4");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("Ch3");
			testMatch.nextTurn();
			testMatch.inputMove("h6");
			testMatch.nextTurn();
			testMatch.inputMove("f3");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			assertThrows(MatchException.class, () -> { testMatch.getPrintableMoves().contains(toParse); });
		} catch(MatchException e) {
			
			fail();
		}
	}
}
