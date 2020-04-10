package it.uniba.game;

import java.util.Scanner;

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
			case HELP_COMMAND:
				printHelp();
				break;
			case START_COMMAND:
				startGame();
				break;
			case QUIT_COMMAND: 
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
				case SHOW_BOARD_COMMAND:
					printBoard();
				case HISTORY_COMMAND:
					printMoves();
				case CAPTURE_COMMAND:
					printCommands();
				default:
					currentMatch.parseMove(toParse);

			}
		} else {
			System.err.println(UNRECOGNIZED_COMM_ERR);
			
		}
	
	}
	
	/*
	 * triggered by the command "play", print a welcome message 
	 * and inits the currentMatch variable
	 */
	private void startGame() {
		
		System.out.println(WELCOME);
		currentMatch=new Match();
	}
	
	/*
	 * asks the user whether to quit or not the whole application. If
	 * the response isn't affirmative nor negative, the method keeps
	 * asking for a response.
	 */
	private void quit() {
	
		System.out.println(QUIT_MESSAGE);
		Scanner keyboard = new Scanner(System.in);
		String read;
		do {
			read = keyboard.nextLine();
			if(read.contains(YES)) {
				quitGame=true;
			} else if(!read.contains(NO)) {
				System.out.println(INCORRECT_QUIT_RESPONSE);
			}
		} while (!read.contains(YES) && !read.contains(NO));
	}
	
	
	/*
	 * prints a list of commands on-screen
	 */
	private void printHelp() {
		
		System.out.println(HELP);
	}
	
	/*
	 * on command board, it prints the current state of the board on screen   
	 */
	private void printBoard() {
		
		System.out.println(currentMatch.getPrintableBoard() + "\n");
	}
	

	

}
