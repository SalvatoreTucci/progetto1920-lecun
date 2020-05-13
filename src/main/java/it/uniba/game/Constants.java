package it.uniba.game;

/**
* Constants <br>
* Class type : no ECB <br>
* Responsibilities : <br>
* 
* 	Knows :
* 		<ul>
* 		<li>The values of the constants values used in the App</li>
* 		</ul>
*	Does : 
*
*
* @author LeCun group <br>
*/
public final class Constants {
	/*
	 * Class containing the constant values used in the application <br>
	 */
	public final static String CHAR_STD = "UTF-8";
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
	
	
	// Constants for the class Pawn <br>
	public final static int B_MID_ROW = 3;
	public final static int W_MID_ROW = 4;
	public final static int LONG_MOVE_LENGTH = 2;
	
	// Constants for the pieces implementation <br>

	public final static int FIRST_ROW = 0;
	public final static int LAST_ROW = 7;
	
	public final static int BLACK_SIDE_ROW = 0;
	public final static int WHITE_SIDE_ROW = 7;
	public final static int BLACK_PAWN_ROW = 1;
	public final static int WHITE_PAWN_ROW = 6;

	public final static int FIRST_COLUMN = 0;
	public final static int LAST_COLUMN = 7;
	
	public final static int R_ROOK_COL = 7;
	public final static int L_ROOK_COL = 0;
	public final static int R_KNIGHT_COL = 6;
	public final static int L_KNIGHT_COL = 1;
	public final static int R_BISHOP_COL = 5;
	public final static int L_BISHOP_COL = 2;
	public final static int KING_COL = 4;
	public final static int QUEEN_COL = 3;
	
	
	
	// Constants for the class ChessBoard <br>
	public final static int CB_DIMENSION = 8;
	public final static String CB_LETTERS_COORDS = "    A   B   C   D   E   F   G   H\n";
	public final static String CB_FIRST_ROW = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014"
			+ "\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+"
			+ "\u2014\u2014\u2014+\n";
	public final static String CB_VERTICAL_SQUARE_SYMBOL = "\u2502";
	public final static String CB_MIDDLE_ROW_SQUARES = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+"
			+ "\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014"
			+ "\u2014\u2014+\u2014\u2014\u2014+\n";
	public final static String CB_LAST_ROW = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014"
			+ "\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+"
			+ "\u2014\u2014\u2014+\n";
	public final static String CB_EMPTY_SQUARE = "   ";
	
	
	// Constants for the class Match <br>
	public final static char CHAR_KING = 'R';
	public final static char CHAR_QUEEN = 'D';
	public final static char CHAR_ROOK = 'T';
	public final static char CHAR_BISHOP = 'A';
	public final static char CHAR_KNIGHT = 'C';
	public final static String MOVE_CAPTURE = "x";
	public final static int MOVE_COLUMN_OFFSET = 2;
	public final static int MOVE_ROW_OFFSET = 1;
	public final static int INVALID_POS = -1;
	public final static String GENERAL_MOVE_REGEX = "([RDTAC])?([a-h]|[1-8])?(x)?([a-h])([1-8])(\\se\\.p\\.)?";
	public final static String PIECE_MOVE_REGEX = "([RDTAC]).*";
	public final static String DISAMBIGUATION_REGEX = ".*([a-h]|[1-8])(x)?([a-h])([1-8])";
	public final static String CASTLING_REGEX = "(0-0(-0)?)|(O-O(-O)?)";
	public final static int KINGSIDE_STRING_LENGHT = 3;
	public final static int CHAR_COLUMN_OFFSET = 97;
	public final static int ROW_OFFSET = 8;
	public final static String STRING_EN_PASSANT = "e.p.";
	public final static int EN_PASSANT_COORDS_OFFSET = 5;
	
	// Constants for castling <br>
	public final static int KS_ROOK_ENDING_COL = 5;
	public final static int QS_ROOK_ENDING_COL = 3;
	public final static int KS_KING_ENDING_COL = 6;
	public final static int QS_KING_ENDING_COL = 2;

	
	
	// Constants for adders  <br>
	public final static int UP_DIRECTION = -1;
	public final static int DOWN_DIRECTION = 1;
	public final static int LEFT_DIRECTION = -1;
	public final static int RIGHT_DIRECTION = 1;
	public final static int STILL_DIRECTION = 0;
	// Knight constants <br>
	public final static int KN_UP_DIRECTION = -2;
	public final static int KN_DOWN_DIRECTION = 2;
	public final static int KN_LEFT_DIRECTION = -2;
	public final static int KN_RIGHT_DIRECTION = 2;
	
	
	// Constants containing Messages and for the class UI <br>
	// Commands <br>
	public final static String HELP_COMMAND = "help";
	public final static String START_COMMAND = "play";
	public final static String QUIT_COMMAND = "quit";
	public final static String SHOW_BOARD_COMMAND = "board";
	public final static String HISTORY_COMMAND = "moves";
	public final static String CAPTURE_COMMAND = "capture";
	
	// Messages <br>
	public final static String WELCOME = W_KING + " Benvenuto! Per conoscere i comandi digita 'help' " + B_KNIGHT;
	public final static String ERR_UNRECOGNIZED_COMMAND = "Comando Sconosciuto o non eseguibile (prova help)";
	public final static String ERR_INCORRECT_ANSWER = "Non ho capito. Sei sicuro? (si/no)";
	public final static String START_MESS = "Nuova Partita! Inizia il bianco: ";
	public final static String RESTART_MESS = "Sei sicuro di voler ricominciare?";
	public final static String QUIT_MESS = "Sei sicuro di voler uscire? ";
	public final static String HELP = "\nhelp \nplay \nquit \n"
			+ "Riconosciuti solo in-game: \nmoves \nboard \ncapture\n";
		
	// Other <br>
	public final static String YES = "si";
	public final static String NO = "no";
	
	public final static int START_ROW_KING_REVERSE = -1;
	public final static int START_COL_KING_REVERSE = -1;
	
	public final static int MAX_ROW_KING_REVERSE = 1;
	public final static int MAX_COL_KING_REVERSE = 1;
	
	// Exception Messages <br>
	public final static String ERR_UNRECOGNIZED_MOVE = "La mossa o il comando inserito non "
			+ "e' stato riconosciuto";
	public final static String ERR_ILLEGAL_MOVE = "Mossa illegale";
	public final static String ERR_AMBIGUOUS_MOVE = "Mossa ambigua";
	public final static String ERR_BAD_DISAMBIGUATION = "Disambiguazione mal specificata";
	public final static String ERR_EN_PASSANT = "En passant non eseguibile";
	public final static String ERR_EN_PASSANT_BAD_TARGET = "Impossibile eseguire En Passant "
			+ "sul pezzo selezionato";
	public final static String ERR_EN_PASSANT_NO_CAPTURE = "La mossa en passant deve essere una cattura.";
	public final static String ERR_BAD_TARGET = "Pezzo non catturabile";
	public final static String ERR_TEMP_BAD_MOVE = "Pezzo non utilizzabile in questa iterazione";
	public final static String ERR_KING_THREAT = "Mossa irregolare/illegale";
	public final static String ERR_NC_KING_THREATENED = "Arrocco non eseguibile: Re minacciato";
	public final static String ERR_NC_KING_MOVED = "Arrocco non eseguibile: Re mosso";
	public final static String ERR_NC_ROOK_MOVED = "Arrocco non eseguibile: Torre mossa";
	public final static String ERR_NC_PATH_OBSTR = "Arrocco non eseguibile: pezzo/i nel mezzo";
	
	
	public final static Coordinates EMPTY_COORD = new Coordinates(-1, -1);
}
