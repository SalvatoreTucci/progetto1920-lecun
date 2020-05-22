package it.uniba.game;

import java.util.Scanner;
import it.uniba.game.pieces.Piece;

/**
 * Class singleton used as User Interface <br>
 * Class type : &#60; ECB &#62; <br><br>
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

	/**
	 * It is the ongoing match, if there is no match ongoing, it is null.
	 */
	private Match currentMatch;

	/**
	 * True if the application needs to be closed, false otherwise.
	 */
	private boolean quitGame;

	/**
	 * It is the unique instance of the class UI.
	 */
	private static final UI SINGLETON = new UI();

	/**
	 * Gets the required status of the application.
	 * 
	 * @return the required status of the application (true = to be closed, false = to be kept open).
	 */
	public boolean getStatus() {

		return quitGame;
	}

	/**
	 * Private constructor, necessary in order to realize the singleton class
	 * as the design pattern describes.
	 */
	private UI() { }

	/**
	 * Gets the unique instance of the class UI.
	 * 
	 * @return the singleton class.
	 */
	public static UI getUI() {

		return SINGLETON;
	}

	/**
	 * Parses the command read from the keyboard and executes the correspondent routine.
	 * 
	 * @param toParse the command inputed by the user that needs to be parsed.
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

	/**
	 * Prosecution of parseCommand, delegated to handling commands during a match.
	 * It checks whether a match is open before executing the respecting routine, otherwise
	 * it will display an error.
	 * 
	 * @param toParse the command inputed by the user that needs to be parsed.
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

	/**
	 * triggered by the command "play", print a welcome message
	 * and inits the currentMatch variable.
	 */
	private void startGame() {

		System.out.println(Constants.START_MESS);
		currentMatch = new Match();
	}

	/**
	 * asks the user whether to quit or not the whole application.
	 * If the response isn't affirmative nor negative, the method keeps
	 * asking for a response.
	 */
	private void quit() {

		quitGame = getConfirm(Constants.QUIT_MESS);
	}

	/**
	 * Asks the user whether to do something or not.
	 * If the response is affirmative, returns true
	 * else if it's negative negative, returns false
	 * else the method keeps asking for a response.
	 * 
	 * @param question the question that needs to be printed.
	 * @return a boolean:
	 * <ul>
	 * 	<li> true, if the user answers yes to the question;
	 *  <li> false, otherwise;
	 * </ul>
	 */
	@SuppressWarnings("resource")
	private boolean getConfirm(final String question) {

		System.out.println(question);
		Scanner keyboard = new Scanner(System.in, Constants.CHAR_STD);
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

	/**
	 * on command "help", prints a list of commands on-screen.
	 */
	private void printHelp() {

		System.out.println(Constants.HELP);
	}

	/**
	 * on command "board", it prints the current state of the board on screen.
	 */
	private void printBoard() {

		System.out.println(currentMatch.getPrintableChessBoard() + "\n");
	}

	/**
	 * on command "moves", it prints the history of the moves, separated in couples.
	 */
	private void printMoves() {

		System.out.println(currentMatch.getPrintableMoves() + "\n");
	}

	/**
	 * on command "capture", it prints the captured pieces.
	 */
	private void printCaptures() {

		System.out.println(currentMatch.getPrintableCaptures(Piece.Color.WHITE) + "\n");
		System.out.println(currentMatch.getPrintableCaptures(Piece.Color.BLACK) + "\n");
	}

	/**
	 * It prints a welcome message.
	 */
	public void printWelcome() {

		System.out.println(Constants.WELCOME);
	}
}
