package it.uniba.game;



public final class Constants {
	/*
	 * Class containing the constant values used in the application
	 */
	public final static String W_KING = "\u2654";
	public final static String B_KING = "\u265A";
	public final static String W_QUEEN = "\u2655";
	public final static String B_QUEEN = "\u265B";
	public final static String W_BISHOP = "\u2657";
	public final static String B_BISHOP = "\u265D";
	public final static String W_ROOK = "\u2656";
	public final static String B_ROOK = "\u265C";
	public final static String W_KNIGHT = "\u2658";
	public final static String B_KNIGHT = "\u265E";
	public final static String W_PAWN = "\u2659";
	public final static String B_PAWN = "\u265F";
	
	// Constants for the class Pawn
	public final static int B_MID_ROW = 3;
	public final static int W_MID_ROW = 4;
	public final static int B_DIRECTION_ROW = -1;
	public final static int W_DIRECTION_ROW = 1;
	
	public final static int FIRST_ROW = 0;
	public final static int LAST_ROW = 7;
	
	// Constants for the class Chessboard
	public final static String CB_LETTERS_COORDS = "   A B C D E F G H\n";
	public final static String CB_FIRST_ROW = "  \u250C\u2500\u2530\u2500\u2530\u2500\u2530"
			+ "\u2500\u2530\u2500\u2530\u2500\u2530\u2500\u2530\u2500\u2510\n";
	public final static String CB_VERTICAL_SQUARE_SYMBOL = "\u2502 ";
	public final static String CB_MIDDLE_ROW_SQUARES = "  \u251C\u2500\u253C\u2500\u253C\u2500"
			+ "\u253C\u2500\u253C\u2500\u253C\u2500\u253C\u2500\u253C\u2500\u2526\n";
	public final static String CB_LAST_ROW = "  \u2514\u2500\u2534\u2500\u2534\u2500\u2534\u2500"
			+ "\u2534\u2500\u2534\u2500\u2534\u2500\u2534\u2500\u2518\n";
	public final static String CB_EMPY_SQUARE = " ";
	
	// Constants containing Messages and for the class UI
	// Commands
	public final static String HELP_COMMAND = "help";
	public final static String START_COMMAND = "play";
	public final static String QUIT_COMMAND = "quit";
	public final static String SHOW_BOARD_COMMAND = "board";
	public final static String HISTORY_COMMAND = "moves";
	public final static String CAPTURE_COMMAND = "capture";
	
	// Messages
	public final static String UNRECOGNIZED_COMM_ERR = "Unknown command \n";
	public final static String ALREADY_STARTED_ERR = "A match is currently running. \n";
	public final static String START_MESS = "New match! White starts: \n";
	public final static String QUIT_MESS = "Are you sure? \n";
	public final static String INCORRECT_QUIT_RESPONSE = "I didn't understand. Are you sure? \n";
	public final static String HELP = "help \nplay \nquit \nIn-game commands:\n \nmoves \nboard \ncapture";
		
	//Other
	public final static String YES = "yes";
	public final static String NO = "no";
	
	
}
