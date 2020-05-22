package it.uniba.game.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import it.uniba.game.Constants;
import it.uniba.game.Match;
import it.uniba.game.MatchException;
import it.uniba.game.pieces.Piece.Color;

class MatchTest {
	
	private Match testMatch;
	
	@BeforeEach
	void matchSetup() {
		
		testMatch = new Match();
	}

	@Test
	void inputMoveWhitePawnMoveTest() {
		
		try {
			
			String toParse = "e4";
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackPawnMoveTest() {
		
		try {
			
			String toParse = "e5";
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteKnightMoveTest() {
		
		try {
			
			String toParse = "Cf3";
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackKnightMoveTest() {
		
		try {
			
			String toParse = "Cc6";
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteBishopMoveTest() {
		
		try {
			
			String toParse = "Ac4";
			testMatch.inputMove("e3");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackBishopMoveTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteRookMoveTest() {
		
		try {
			
			String toParse = "Th3";
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			testMatch.inputMove("h5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackRookMoveTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteQueenMoveTest() {
		
		try {
			
			String toParse = "Dh5";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
		
	}
	
	@Test
	void inputMoveBlackQueenMoveTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteKingMoveTest() {
		
		try {
			
			String toParse = "Re2";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackKingMoveTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteQueenSideCastlingTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteQueenSideCastlingAlternativeTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteKingSideCastlingTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteKingSideCastlingAlternativeTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackQueenSideCastlingTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackQueenSideCastlingAlternativeTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackKingSideCastlingTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackKingSideCastlingAlternativeTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteEnPassantTest() {
		
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
	void inputMoveWhiteEnPassantAlternativeTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackEnPassantTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackEnPassantAlternativeTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhitePinnedPieceTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackPinnedPieceTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveInvalidTest() {

			String toParse = "Th8";
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	void inputMoveWhiteInvalidKingSideCastlingTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteInvalidQueenSideCastlingTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackInvalidKingSideCastlingTest() {
		
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
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackInvalidQueenSideCastlingTest() {
		
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
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveThreatCastlingTest() {
		
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
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveEnPassantPinnedTest() {
		
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
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveFirstRookMoveThreatTest() {

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
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
			testMatch.inputMove("g3");
			testMatch.nextTurn();
			testMatch.inputMove("g6");
			testMatch.nextTurn();
			testMatch.inputMove("0-0");
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveWhiteCaptureThreatTest() {
		
		try {
			
			String toParse = "fxe5";
			testMatch.inputMove("f4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			testMatch.nextTurn();
			assertAll( () -> {
						assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
						assertFalse(testMatch.getPrintableCaptures(Color.WHITE).contains(Constants.B_PAWN));
					});
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBlackCaptureThreatTest() {
		
		try {
			
			String toParse = "fxe4";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("f5");
			testMatch.nextTurn();
			testMatch.inputMove("Dh5");
			testMatch.nextTurn();
			assertAll( () -> {
				assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
				assertFalse(testMatch.getPrintableCaptures(Color.WHITE).contains(Constants.W_PAWN));
			});
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMovePinnedRookFirstMoveTest() {
		
		try {
			
			String toParse = "Th2";
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("f3");
			testMatch.nextTurn();
			testMatch.inputMove("Dxh4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveRowDisambiguationTest() {
		
		try {
			
			String toParse = "T1a3";
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Th3");
			testMatch.nextTurn();
			testMatch.inputMove("Ca6");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("Cb4");
			testMatch.nextTurn();
			testMatch.inputMove(toParse);
			assertTrue(testMatch.getPrintableMoves().contains(toParse));
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveNotPawnEnPassantTest() {
		
		String toParse = "Ca3 e.p.";
		assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	void inputMoveNotCaptureEnPassantTest() {
		
		try {
			
			String toParse = "d6 e.p.";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });			
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMovePawnCaptureNoColumnTest() {
		
		try {
			
			String toParse = "xe5";
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveInvalidMoveTest() {
		
		String toParse = "ammaccabanane";
		assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	void inputMovePawnNoPieceToCaptureTest() {
		
		try {
		
			String toParse = "exd5";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMovePawnSameColorCaptureTest() {
		
		try {
		
			String toParse = "dxe4";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveNoPieceToCaptureTest() {
		
			String toParse = "Cxf3";
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	void inputMoveSameColorCaptureTest() {
		
		try {
		
			String toParse = "Cxf3";
			testMatch.inputMove("f3");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveNoRowDisambiguationTest() {
		
		try {
			
			String toParse = "Ta3";
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Th3");
			testMatch.nextTurn();
			testMatch.inputMove("Ca6");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("Cb4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveBadColumnDisambiguationTest() {
		
		String toParse = "Cff3";
		assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	void inputMoveBadRowDisambiguationTest() {
		
		String toParse = "C2f3";
		assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}

	@Test
	void inputMoveKingThreatMoveTest() {
		
		try {
			
			String toParse = "Re6";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Dh5");
			testMatch.nextTurn();
			testMatch.inputMove("Cc6");
			testMatch.nextTurn();
			testMatch.inputMove("Ac4");
			testMatch.nextTurn();
			testMatch.inputMove("Re7");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}

	@Test
	void inputMoveBadEnPassantTest() {
		
		String toParse = "exd3";
		assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	void inputMoveMovedPawnEnPassantTest() {
		
		try {
			
			String toParse = "exd6";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("a6");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveEnPassantNoPawnCapturedTest() {
		
		try {
			
			String toParse = "exd6";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("h3");
			testMatch.nextTurn();
			testMatch.inputMove("Dd5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveEnPassantNormalCaptureTest() {
		
		try {
			
			String toParse = "dxe5 e.p.";
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveKingThreatsHimselfTest() {
		
		try {
			
			String toParse = "Re1";
			testMatch.inputMove("f4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Rf2");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveIrregularMoveTest() {
		
		try {
			
			String toParse = "a4";
			testMatch.inputMove("f4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Dh4");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveIrregularRookThreatMoveTest() {
		
		try {
			
			String toParse = "a3";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Ta6");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("Txe6");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveIrregularRookThreatKingMoveTest() {
		
		try {
			
			String toParse = "Re2";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("Ta6");
			testMatch.nextTurn();
			testMatch.inputMove("Re2");
			testMatch.nextTurn();
			testMatch.inputMove("Te6");
			testMatch.nextTurn();
			testMatch.inputMove("Re3");
			testMatch.nextTurn();
			testMatch.inputMove("Txe5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveIrregularKnightThreatMoveTest() {
		
		try {
			
			String toParse = "e5";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("Cc6");
			testMatch.nextTurn();
			testMatch.inputMove("d3");
			testMatch.nextTurn();
			testMatch.inputMove("Cd4");
			testMatch.nextTurn();
			testMatch.inputMove("Dg4");
			testMatch.nextTurn();
			testMatch.inputMove("Cxc2");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveIrregularPawnLeftThreatMoveTest() {
		
		try {
			
			String toParse = "Re7";
			testMatch.inputMove("d4");
			testMatch.nextTurn();
			testMatch.inputMove("e5");
			testMatch.nextTurn();
			testMatch.inputMove("dxe5");
			testMatch.nextTurn();
			testMatch.inputMove("d6");
			testMatch.nextTurn();
			testMatch.inputMove("exd6");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void inputMoveObstructedCastlingTest() {
		
		String toParse = "0-0";
		assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
	}
	
	@Test
	void inputMoveIrregularPawnRightThreatMoveTest() {
		
		try {
			
			String toParse = "Rd7";
			testMatch.inputMove("e4");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			testMatch.inputMove("exd5");
			testMatch.nextTurn();
			testMatch.inputMove("e6");
			testMatch.nextTurn();
			testMatch.inputMove("dxe6");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	
	@Test
	void inputMoveBadDisambiguationTest() {
		
		try {
			
			String toParse = "T3d3";
			testMatch.inputMove("h4");
			testMatch.nextTurn();
			testMatch.inputMove("h5");
			testMatch.nextTurn();
			testMatch.inputMove("a4");
			testMatch.nextTurn();
			testMatch.inputMove("a5");
			testMatch.nextTurn();
			testMatch.inputMove("Ta3");
			testMatch.nextTurn();
			testMatch.inputMove("b6");
			testMatch.nextTurn();
			testMatch.inputMove("Thh3");
			testMatch.nextTurn();
			testMatch.inputMove("d5");
			testMatch.nextTurn();
			assertThrows(MatchException.class, () -> { testMatch.inputMove(toParse); });
		} catch(MatchException e) {
			
			fail(e.getMessage());
		}
	}
	
	@Test
	void getPrintableCapturesWhiteEmptyTest() {
		
		assertEquals("[]", testMatch.getPrintableCaptures(Color.WHITE));
		
	}
	
	@Test
	void getPrintableCapturesBlackEmptyTest() {
		
		assertEquals("[]", testMatch.getPrintableCaptures(Color.BLACK));
	}
	
	@Test
	void getPrintableCapturesWhiteNonEmptyTest() {
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
			fail(e.getMessage());
		}
		assertEquals("[" + Constants.B_PAWN +"]", testMatch.getPrintableCaptures(Color.WHITE));
		
	}
	
	@Test
	void getPrintableCapturesBlackNonEmptyTest() {
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
			fail(e.getMessage());
		}
		assertEquals("[" + Constants.W_PAWN +"]", testMatch.getPrintableCaptures(Color.BLACK));
	}
	
	
	@Test
	void getPrintableCapturesNullColorTest() {
		try {
			testMatch.inputMove("b4");
			testMatch.nextTurn();
			testMatch.inputMove("Cc6");
			testMatch.nextTurn();
			testMatch.inputMove("a3");
			testMatch.nextTurn();
			testMatch.inputMove("Cxb4");
		} catch (MatchException e) {
			
			fail(e.getMessage());
		}
		assertEquals("[" + Constants.W_PAWN +"]", testMatch.getPrintableCaptures(null));
	}
	
	@Test
	void getPrintableCapturesBothGenericTest() {
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
			fail(e.getMessage());
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
	void getCurrentPlayerTest() {
		assertEquals(Color.WHITE, testMatch.getCurrentPlayer());
	}
	
	@Test
	void nextTurnTest() {
		testMatch.nextTurn();
		assertEquals(Color.BLACK, testMatch.getCurrentPlayer());
	}
	
	@Test
	void getPrintableMovesEmptyTest() {
		assertTrue(testMatch.getPrintableMoves().isEmpty());
	}
	
	@Test
	void getPrintableMovesNotEmptyTest() {
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
			fail(e.getMessage());
		}
		String expectedMoves = "\n1. Ch3 g5\n"
				+ "2. Cxg5 d5\n"
				+ "3. g3 Dd6\n"
				+ "4. Ah3 Rd8\n"
				+"5. O-O ";
		assertEquals(expectedMoves, testMatch.getPrintableMoves());

	}
}
