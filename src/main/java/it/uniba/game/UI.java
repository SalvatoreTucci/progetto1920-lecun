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
	 * triggered by the command "play", inits the currentMatch variable
	 */
	void startGame() {
		
		System.out.println(WELCOME);
		currentMatch=new Match();
	}
	
	/*
	 * asks the user whether to quit or not the whole application. If
	 * the response isn't affirmative nor negative, the method keeps
	 * asking for a response.
	 */
	void quit() {
	
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
	 * returns the required status of the application (true = to be closed,
	 *  false = to be kept open)
	 */
	public boolean getStatus() {
		
		return quitGame;
	}
	
	/*
	 * prints a list of commands on-screen
	 */
	void printHelp() {
		
		System.out.println(HELP);
	}
	
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

}
