package it.uniba.game;

import java.util.Scanner;
import it.uniba.game.pieces.Piece;

/**
 * 
 * UI <br>
 * 
 * Class type : ECB <br>
 * 
 * Responsibilities : <br>
 * 
 * 	Knows : <br>
 * 		<ul>
 * 			<li>Status of the current match</li>
 *  		<li>If the user wants to quit the game</li>
 * 		</ul>
 * 
 * 	Does : <br>
 * 		<ul>
 *  		<li>Parsifies a command given an input</li>
 *   		<li>Handles a command in game, such as "board", "moves", ... </li>
 *     		<li>Starts a new Match</li>
 *       	<li>Prints messages to the output stream</li>
 *         	<li>Gets inputs from the user by the input stream</li>
 * 		</ul>
 * 
 * @author LeCun group <br>
 */
public final class UI {
	/*
	 * Class for App-User interaction <br>
	 */

	// Attributes
	private Match currentMatch;
	private boolean quitGame;
	private static final UI SINGLETON = new UI();
	// Methods <br>

	/*
	 * returns the required status of the application (true = to be closed,<br>
	 *  false = to be kept open) <br>
	 */
	public boolean getStatus() {

		return quitGame;
	}

	/*
	 * private constructor, necessary in order to realize the singleton class <br>
	 * as the design pattern describes <br>
	 */
	private UI() { }

	/*
	 * get method in order to access the singleton class fields <br>
	 */
	public static UI getUI() {

		return SINGLETON;
	}

	/*
	 * parses the command read from the keyboard and executes the correspondent routine <br>
	 */
	public void parseCommand(final String toParse) {

		switch (toParse) {

			case Constants.HELP_COMMAND:
				printHelp();
				break;
			case Constants.START_COMMAND:
				if (currentMatch == null) {

					startGame();
				} else {

					if (getConfirm(Constants.RESTART_MESS)) {

						startGame();
					}
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
	 * Prosecution of parseCommand, delegated to handling commands during a match. <br>
	 * It checks whether a match is open before executing the respecting routine, otherwise <br>
	 * it will display an error. <br>
	 */
	private void handleInGameCommand(final String toParse) {

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
					try {

						currentMatch.inputMove(toParse);
						currentMatch.nextTurn();
					} catch (MatchException toHandle) {

						System.err.println(toHandle.getMessage());
					}
			}
		} else {

			System.err.println(Constants.ERR_UNRECOGNIZED_COMMAND);
		}
	}

	/*
	 * triggered by the command "play", print a welcome message  <br>
	 * and inits the currentMatch variable <br>
	 */
	private void startGame() {

		System.out.println(Constants.START_MESS);
		currentMatch = new Match();
	}

	/*
	 * asks the user whether to quit or not the whole application. If <br>
	 * the response isn't affirmative nor negative, the method keeps <br>
	 * asking for a response. <br>
	 */
	private void quit() {

		quitGame = getConfirm(Constants.QUIT_MESS);
	}

	/*
	 * asks the user whether to do something or not. <br>
	 * If the response is affirmative, returns true <br>
	 * else if it's negative negative, returns false <br>
	 * else the method keeps asking for a response. <br>
	 */
	private boolean getConfirm(final String question) {

		System.out.println(question);
		Scanner keyboard = new Scanner(System.in);
		String read;
		do {

			read = keyboard.nextLine();
			read = read.toLowerCase();
			read = read.trim();

			if (read.equals(Constants.YES)) {

				return true;
			} else if (!read.equals(Constants.NO)) {

				System.out.println(Constants.ERR_INCORRECT_ANSWER);
			}

		} while (!read.equals(Constants.YES) && !read.equals(Constants.NO));

		return false;
	}

	/*
	 * prints a list of commands on-screen <br>
	 */
	private void printHelp() {

		System.out.println(Constants.HELP);
	}

	/*
	 * on command "board", it prints the current state of the board on screen  <br>
	 */
	private void printBoard() {

		System.out.println(currentMatch.getPrintableChessBoard() + "\n");
	}

	/*
	 * on command "moves", it prints the history of the moves, separated in couples <br>
	 */
	private void printMoves() {

		System.out.println(currentMatch.getPrintableMoves() + "\n");
	}

	/*
	 * on command "capture", it prints the captured pieces <br>
	 */
	private void printCaptures() {

		System.out.println(currentMatch.getPrintableCaptures(Piece.Color.WHITE) + "\n");
		System.out.println(currentMatch.getPrintableCaptures(Piece.Color.BLACK) + "\n");
	}

	public void printWelcome() {

		System.out.println(Constants.WELCOME);
	}
}
