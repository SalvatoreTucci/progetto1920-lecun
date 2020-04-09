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
	 * returns the required status of the application (true = to be closed, false = to be kept open)
	 */
	bool getStatus() {
		
		return quitGame;
	}

}
