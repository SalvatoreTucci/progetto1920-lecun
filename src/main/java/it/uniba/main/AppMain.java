package it.uniba.main;

import it.uniba.game.Constants;
import it.uniba.game.UI;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
* The main class for the project <br>
* Class type : &#60; Boundary &#62; <br><br>
* Responsibilities : <br>
* 	Knows : <br>
*	Does :
*		<ul>
*		<li>Checks whether the user wants to exit the app</li>
*		<li>Reads the user input from the keyboard</li>
* 		</ul>
*
* @author LeCun group
*/



public final class AppMain {

	/**
	 * Private constructor for the class
	 */
	private AppMain() { }

	/**
	 * 	 * This is the main entry of the application.
	 *
	 * @param args Command line arguments, not used at the moment in the project
	 */
	public static void main(final String[] args) {

		try {

			PrintStream utf8Out = new PrintStream(System.out, false, Constants.CHAR_STD);
			System.setOut(utf8Out);
		} catch (UnsupportedEncodingException e) {

			System.out.println(Constants.ERR_UNSUPPORTED_ENCODING);
			System.exit(-1);
		}

		UI gameUI = UI.getUI();
		gameUI.printWelcome();
		String command;
		Scanner userInput = new Scanner(System.in, Constants.CHAR_STD);
		do {

			command = userInput.nextLine();
			gameUI.parseCommand(command.trim());
		} while (!gameUI.getStatus());

		userInput.close();
	}
}
