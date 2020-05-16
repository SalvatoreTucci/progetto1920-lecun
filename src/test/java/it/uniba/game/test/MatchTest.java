package it.uniba.game.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
		}
	}
	
	@Test
	public void inputMoveWhiteKnightMoveTest() {
		
		try {
			
			String testMove = "Cf3";
			testMatch.inputMove(testMove);
			assertTrue(testMatch.getPrintableMoves().contains(testMove));
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
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
		}
		catch(MatchException e) {
			
		}
	}
	
}
