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
	public final static int LONG_MOVE_LENGTH = 2;
	
	
	// Constants for the class Chessboard
	public final static String CB_LETTERS_COORDS = "    A   B   C   D   E   F   G   H\n";
	public final static String CB_FIRST_ROW = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014"
			+ "\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\n";
	public final static String CB_VERTICAL_SQUARE_SYMBOL = "\u2502";
	public final static String CB_MIDDLE_ROW_SQUARES = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+"
			+ "\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\n";
	public final static String CB_LAST_ROW = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014"
			+ "\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\n";
	public final static String CB_EMPY_SQUARE = "   ";
	
	

	// Constants for the class Match
	public final static char CHAR_KING = 'R';
	public final static char CHAR_QUEEN = 'D';
	public final static char CHAR_ROOK = 'T';
	public final static char CHAR_BISHOP = 'A';
	public final static char CHAR_KNIGHT = 'C';
	public final static String MOVE_CAPTURE = "x";
	public final static int MOVE_COLUMN_OFFSET = 2;
	public final static int MOVE_ROW_OFFSET = 1;
	public final static int INVALID_POS = -1;
	public final static String GENERAL_MOVE_REGEX = "([RDTAC])?([a-h]|[1-8])?(x)?([a-h])([1-8])";
	public final static String PIECE_MOVE_REGEX = "([RDTAC]).*";
	public final static String DISAMBIGUATION_REGEX = ".*([a-h]|[1-8])(x)?([a-h])([1-8])";
	public final static int CHAR_COLUMN_OFFSET = 97;
	public final static int ROW_OFFSET = 8;
	
	//Constants for adders 
	public final static int UP_DIRECTION = -1;
	public final static int DOWN_DIRECTION = 1;
	public final static int LEFT_DIRECTION = -1;
	public final static int RIGHT_DIRECTION = 1;
	public final static int STILL_DIRECTION = 0;
	
	//Constants for the class Vector
	public final static int EMPTY_SIZE = 0;
	
	// Constants containing Messages and for the class UI
	// Commands
	public final static String HELP_COMMAND = "help";
	public final static String START_COMMAND = "play";
	public final static String QUIT_COMMAND = "quit";
	public final static String SHOW_BOARD_COMMAND = "board";
	public final static String HISTORY_COMMAND = "moves";
	public final static String CAPTURE_COMMAND = "capture";
	
	// Messages
	public final static String ERR_UNRECOGNIZED_COMMAND = "Comando Sconosciuto o non eseguibile (prova help)";
	public final static String ERR_ALREADY_STARTED = "C'e' gia' un match aperto. ";
	public final static String START_MESS = "Nuova Partita! Inizia il bianco: ";
	public final static String QUIT_MESS = "Sei sicuro di voler uscire? (si/no) ";
	public final static String INCORRECT_QUIT_RESPONSE = "Non ho capito. Sei sicuro? ";
	public final static String HELP = "\nhelp \nplay \nquit \n"
			+ "Riconosciuti solo in-game: \nmoves \nboard \ncapture";
		
	//Other
	public final static String YES = "si";
	public final static String NO = "no";
	
	// Exception Messages
	public final static String ERR_UNRECOGNIZED_MOVE = "La mossa o il comando inserito non "
			+ "è stato riconosciuto";
	public final static String ERR_ILLEGAL_MOVE = "Mossa illegale";
	public final static String ERR_AMBIGUOUS_MOVE = "Mossa ambigua";
	public final static String ERR_BAD_DISAMBIGUATION = "Disambiguazione mal specificata";
	public final static String ERR_EN_PASSANT = "En passant non eseguibile";
	public final static String ERR_EN_PASSANT_BAD_TARGET = "Impossibile eseguire En Passant "
			+ "sul pezzo selezionato";
	public final static String ERR_BAD_TARGET = "Pezzo non catturabile";
	public final static String ERR_TEMP_BAD_MOVE = "Pezzo utilizzabile in questa iterazione";
	
}
