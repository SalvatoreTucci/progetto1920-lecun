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
	private Constants() { }

	public static final String CHAR_STD = "UTF-8";
	public static final String W_KING = "\u2654";
	public static final String B_KING = "\u265A";
	public static final String W_QUEEN = "\u2655";
	public static final String B_QUEEN = "\u265B";
	public static final String W_BISHOP = "\u2657";
	public static final String B_BISHOP = "\u265D";
	public static final String W_ROOK = "\u2656";
	public static final String B_ROOK = "\u265C";
	public static final String W_KNIGHT = "\u2658";
	public static final String B_KNIGHT = "\u265E";
	public static final String W_PAWN = "\u2659";
	public static final String B_PAWN = "\u265F";


	// Constants for the class Pawn <br>
	public static final int B_MID_ROW = 3;
	public static final int W_MID_ROW = 4;
	public static final int LONG_MOVE_LENGTH = 2;

	// Constants for the pieces implementation <br>
	public static final int FIRST_ROW = 0;
	public static final int LAST_ROW = 7;

	public static final int BLACK_SIDE_ROW = 0;
	public static final int WHITE_SIDE_ROW = 7;
	public static final int BLACK_PAWN_ROW = 1;
	public static final int WHITE_PAWN_ROW = 6;

	public static final int FIRST_COLUMN = 0;
	public static final int LAST_COLUMN = 7;

	public static final int R_ROOK_COL = 7;
	public static final int L_ROOK_COL = 0;
	public static final int R_KNIGHT_COL = 6;
	public static final int L_KNIGHT_COL = 1;
	public static final int R_BISHOP_COL = 5;
	public static final int L_BISHOP_COL = 2;
	public static final int KING_COL = 4;
	public static final int QUEEN_COL = 3;


	// Constants for the class ChessBoard <br>
	public static final int CB_DIMENSION = 8;
	public static final String CB_LETTERS_COORDS = "    A   B   C   D   E   F   G   H\n";
	public static final String CB_FIRST_ROW = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014"
			+ "\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+"
			+ "\u2014\u2014\u2014+\n";
	public static final String CB_VERTICAL_SQUARE_SYMBOL = "\u2502";
	public static final String CB_MIDDLE_ROW_SQUARES = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+"
			+ "\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014"
			+ "\u2014\u2014+\u2014\u2014\u2014+\n";
	public static final String CB_LAST_ROW = "  +\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014"
			+ "\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+\u2014\u2014\u2014+"
			+ "\u2014\u2014\u2014+\n";

	public static final String CB_EMPTY_SQUARE = "   ";

	// Constants for the class Match <br>
	public static final char CHAR_KING = 'R';
	public static final char CHAR_QUEEN = 'D';
	public static final char CHAR_ROOK = 'T';
	public static final char CHAR_BISHOP = 'A';
	public static final char CHAR_KNIGHT = 'C';
	public static final String MOVE_CAPTURE = "x";
	public static final int MOVE_COLUMN_OFFSET = 2;
	public static final int MOVE_ROW_OFFSET = 1;
	public static final int INVALID_POS = -1;
	public static final String GENERAL_MOVE_REGEX = "([RDTAC])?([a-h]|[1-8])?(x)?([a-h])([1-8])(\\se\\.p\\.)?";
	public static final String PIECE_MOVE_REGEX = "([RDTAC]).*";
	public static final String DISAMBIGUATION_REGEX = ".*([a-h]|[1-8])(x)?([a-h])([1-8])(\\se\\.p\\.)?";
	public static final String CASTLING_REGEX = "(0-0(-0)?)|(O-O(-O)?)";
	public static final int KINGSIDE_STRING_LENGHT = 3;
	public static final int CHAR_COLUMN_OFFSET = 97;
	public static final int ROW_OFFSET = 8;
	public static final String STRING_EN_PASSANT = "e.p.";
	public static final int EN_PASSANT_COORDS_OFFSET = 5;

	// Constants for castling <br>
	public static final int KS_ROOK_ENDING_COL = 5;
	public static final int QS_ROOK_ENDING_COL = 3;
	public static final int KS_KING_ENDING_COL = 6;
	public static final int QS_KING_ENDING_COL = 2;


	// Constants for adders  <br>
	public static final int UP_DIRECTION = -1;
	public static final int DOWN_DIRECTION = 1;
	public static final int LEFT_DIRECTION = -1;
	public static final int RIGHT_DIRECTION = 1;
	public static final int STILL_DIRECTION = 0;
	// Knight constants <br>
	public static final int KN_UP_DIRECTION = -2;
	public static final int KN_DOWN_DIRECTION = 2;
	public static final int KN_LEFT_DIRECTION = -2;
	public static final int KN_RIGHT_DIRECTION = 2;

	// Constants containing Messages and for the class UI <br>
	// Commands <br>
	public static final String HELP_COMMAND = "help";
	public static final String START_COMMAND = "play";
	public static final String QUIT_COMMAND = "quit";
	public static final String SHOW_BOARD_COMMAND = "board";
	public static final String HISTORY_COMMAND = "moves";
	public static final String CAPTURE_COMMAND = "capture";

	// Messages <br>
	public static final String WELCOME = W_KING + " Benvenuto! Per conoscere i comandi digita 'help' " + B_KNIGHT;
	public static final String ERR_UNRECOGNIZED_COMMAND = "Comando Sconosciuto o non eseguibile (prova help)";
	public static final String ERR_INCORRECT_ANSWER = "Non ho capito. Sei sicuro? (si/no)";
	public static final String START_MESS = "Nuova Partita! Inizia il bianco: ";
	public static final String RESTART_MESS = "Sei sicuro di voler ricominciare?";
	public static final String QUIT_MESS = "Sei sicuro di voler uscire? ";
	public static final String HELP = "\nhelp \nplay \nquit \n"
			+ "Riconosciuti solo in-game: \nmoves \nboard \ncapture\n";

	// Other <br>
	public static final String YES = "si";
	public static final String NO = "no";

	public static final int START_ROW_KING_REVERSE = -1;
	public static final int START_COL_KING_REVERSE = -1;

	public static final int MAX_ROW_KING_REVERSE = 1;
	public static final int MAX_COL_KING_REVERSE = 1;

	// Exception Messages <br>
	public static final String ERR_UNRECOGNIZED_MOVE = "La mossa o il comando inserito non "
			+ "e' stato riconosciuto";
	public static final String ERR_ILLEGAL_MOVE = "Mossa illegale";
	public static final String ERR_AMBIGUOUS_MOVE = "Mossa ambigua";
	public static final String ERR_BAD_DISAMBIGUATION = "Disambiguazione mal specificata";
	public static final String ERR_EN_PASSANT = "En passant non eseguibile";
	public static final String ERR_EN_PASSANT_BAD_TARGET = "Impossibile eseguire En Passant "
			+ "sul pezzo selezionato";

	public static final String ERR_EN_PASSANT_NO_CAPTURE = "La mossa en passant deve essere una cattura.";
	public static final String ERR_BAD_TARGET = "Pezzo non catturabile";
	public static final String ERR_TEMP_BAD_MOVE = "Pezzo non utilizzabile in questa iterazione";
	public static final String ERR_KING_THREAT = "Mossa irregolare/illegale";
	public static final String ERR_NC_KING_THREATENED = "Arrocco non eseguibile: Re minacciato";
	public static final String ERR_NC_KING_MOVED = "Arrocco non eseguibile: Re mosso";
	public static final String ERR_NC_ROOK_MOVED = "Arrocco non eseguibile: Torre mossa";
	public static final String ERR_NC_PATH_OBSTR = "Arrocco non eseguibile: pezzo/i nel mezzo";

	public static final Coordinates EMPTY_COORD = new Coordinates(-1, -1);
	public static final int INVALID_HASHCODE = -1;
}
