package it.uniba.main;

import it.uniba.game.UI;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 * 
 * <b>DO NOT RENAME</b>
 */
/**
* AppMain
* Class type : <<Boundary>>
* Responsibilities :
* 	Knows :
* 		<ul>
* 		<li></li>
* 		</ul>
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
	 * Private constructor. Change if needed.
	 */
	private AppMain() {
	}

	/**
	 * 	 * This is the main entry of the application.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(final String[] args) {
		
		try {
			
			PrintStream utf8Out = new PrintStream(System.out,false,"UTF-8");
			System.setOut(utf8Out);
		} catch (UnsupportedEncodingException e) {
			
		}
		
		UI gameUI = UI.getUI();
		gameUI.printWelcome();
		String command;
		Scanner userInput = new Scanner(System.in);
		do {
			
			command = userInput.nextLine();
			gameUI.parseCommand(command.trim());
		} while (!gameUI.getStatus());
		
		userInput.close();
	}

}
