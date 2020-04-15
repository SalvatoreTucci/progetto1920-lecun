package it.uniba.game;

import java.util.Scanner;
import it.uniba.game.pieces.Piece;

public class UI {
	/*
	 * Class for App-User interaction
	 */
	
	//Attributes
	private Match currentMatch;
	private boolean quitGame;
	
	//Methods

	/*
	 * returns the required status of the application (true = to be closed,
	 *  false = to be kept open)
	 */
	public boolean getStatus() {
		
		return quitGame;
	}

	/*
	 * parses the command read from the keyboard and executes the correspondent routine
	 */
	public void parseCommand(String toParse) {
		
		switch (toParse) {
			case Constants.HELP_COMMAND:
				printHelp();
				break;
			case Constants.START_COMMAND:
				if (currentMatch == null) {
					
					startGame();
				} else {
					System.out.println(Constants.ERR_ALREADY_STARTED);
				}
				break;
			case Constants.QUIT_COMMAND: 
				quit();
				break;
			default:
				handleInGameCommand(toParse);
		}
	}
	
	/*
	 * Prosecution of parseCommand, delegated to handling commands during a match.
	 * It checks whether a match is open before executing the respecting routine, otherwise
	 * it will display an error.
	 */
	private void handleInGameCommand(String toParse) {
		
		if (currentMatch != null) {
			
			switch (toParse) {
				case Constants.SHOW_BOARD_COMMAND:
					printBoard();
					break;
				case Constants.HISTORY_COMMAND:
					printMoves();
					break;
				case Constants.CAPTURE_COMMAND:
					printCaptures();
					break;
				default:
					currentMatch.inputMove(toParse);
					currentMatch.nextTurn();
			}
		} else {
			System.err.println(Constants.ERR_UNRECOGNIZED_COMMAND);
			
		}
	
	}
	
	/*
	 * triggered by the command "play", print a welcome message 
	 * and inits the currentMatch variable
	 */
	private void startGame() {
		
		System.out.println(Constants.START_MESS);
		currentMatch = new Match();
	}
	
	/*
	 * asks the user whether to quit or not the whole application. If
	 * the response isn't affirmative nor negative, the method keeps
	 * asking for a response.
	 */
	private void quit() {
	
		System.out.println(Constants.QUIT_MESS);
		Scanner keyboard = new Scanner(System.in);
		String read;
		do {
			read = keyboard.nextLine();
			if(read.equals(Constants.YES)) {
				quitGame = true;
			} else if(!read.equals(Constants.NO)) {
				System.out.println(Constants.INCORRECT_QUIT_RESPONSE);
			}
		} while (!read.equals(Constants.YES) && !read.equals(Constants.NO));
		
	}
	
	
	/*
	 * prints a list of commands on-screen
	 */
	private void printHelp() {
		
		System.out.println(Constants.HELP);
	}
	
	/*
	 * on command "board", it prints the current state of the board on screen   
	 */
	private void printBoard() {
		
		System.out.println(currentMatch.getPrintableChessBoard() + "\n");
	}
	
	/*
	 * on command "moves", it prints the history of the moves, separated in couples
	 */
	private void printMoves() {
		
		System.out.println(currentMatch.getPrintableMoves() + "\n");
	}
	
	/*
	 * on command "capture", it prints the captured pieces 
	 */
	private void printCaptures() {
		
		System.out.println(currentMatch.getPrintableCaptures(Piece.Color.WHITE) + "\n");
		System.out.println(currentMatch.getPrintableCaptures(Piece.Color.BLACK) + "\n");
	}
	
}
