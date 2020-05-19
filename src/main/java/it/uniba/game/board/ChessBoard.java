package it.uniba.game.board;

import it.uniba.game.Constants;
import it.uniba.game.Coordinates;
import it.uniba.game.Move;
import it.uniba.game.pieces.Rook;
import it.uniba.game.pieces.Bishop;
import it.uniba.game.pieces.King;
import it.uniba.game.pieces.Knight;
import it.uniba.game.pieces.Pawn;
import it.uniba.game.pieces.Queen;
import it.uniba.game.pieces.Piece;

/**
 * Class representing the chessboard <br>
 * Class type : Entity <br>
 * 
 * Responsibilities : <br>
 * 
 * 	Knows :
 * 		<ul>
 *			<li>The squares of the field</li>
 * 		</ul>
 * 
 * 	Does :
 *  	<ul>
 *			<li>Instantiates a ChessBoard</li>
 *			<li>Sets a move on the ChessBoard</li>
 *			<li>Gets a square, with the polar coordinates</li>
 *			<li>Converts to string the ChessBoard</li>
 * 		</ul>
 *
 * @author LeCun group
 */
public final class ChessBoard {
	// Class used for represents the chessboard

	private Square[][] elements;

	public ChessBoard() {

		elements = new Square[Constants.CB_DIMENSION][Constants.CB_DIMENSION];

		// Inizialize Rook pieces
		elements[Constants.BLACK_SIDE_ROW][Constants.L_ROOK_COL] =
									new Square(new Rook(Piece.Color.BLACK));
		elements[Constants.BLACK_SIDE_ROW][Constants.R_ROOK_COL] =
									new Square(new Rook(Piece.Color.BLACK));
		elements[Constants.WHITE_SIDE_ROW][Constants.L_ROOK_COL] =
									new Square(new Rook(Piece.Color.WHITE));
		elements[Constants.WHITE_SIDE_ROW][Constants.R_ROOK_COL] =
									new Square(new Rook(Piece.Color.WHITE));

		// Inizialize Knight pieces
		elements[Constants.BLACK_SIDE_ROW][Constants.L_KNIGHT_COL] =
									new Square(new Knight(Piece.Color.BLACK));
		elements[Constants.BLACK_SIDE_ROW][Constants.R_KNIGHT_COL] =
									new Square(new Knight(Piece.Color.BLACK));
		elements[Constants.WHITE_SIDE_ROW][Constants.L_KNIGHT_COL] =
									new Square(new Knight(Piece.Color.WHITE));
		elements[Constants.WHITE_SIDE_ROW][Constants.R_KNIGHT_COL] =
									new Square(new Knight(Piece.Color.WHITE));

		// Inizialize Bishop pieces
		elements[Constants.BLACK_SIDE_ROW][Constants.L_BISHOP_COL] =
									new Square(new Bishop(Piece.Color.BLACK));
		elements[Constants.BLACK_SIDE_ROW][Constants.R_BISHOP_COL] =
									new Square(new Bishop(Piece.Color.BLACK));
		elements[Constants.WHITE_SIDE_ROW][Constants.L_BISHOP_COL] =
									new Square(new Bishop(Piece.Color.WHITE));
		elements[Constants.WHITE_SIDE_ROW][Constants.R_BISHOP_COL] =
									new Square(new Bishop(Piece.Color.WHITE));

		// Inizialize King pieces
		elements[Constants.BLACK_SIDE_ROW][Constants.KING_COL] =
									new Square(new King(Piece.Color.BLACK));
		elements[Constants.WHITE_SIDE_ROW][Constants.KING_COL] =
									new Square(new King(Piece.Color.WHITE));

		// Inizialize Queen pieces
		elements[Constants.BLACK_SIDE_ROW][Constants.QUEEN_COL] =
									new Square(new Queen(Piece.Color.BLACK));
		elements[Constants.WHITE_SIDE_ROW][Constants.QUEEN_COL] =
									new Square(new Queen(Piece.Color.WHITE));

		// Inizialize Pawn pieces
		for (int i = Constants.FIRST_COLUMN; i <= Constants.LAST_COLUMN; i++) {

			elements[Constants.BLACK_PAWN_ROW][i] = new Square(new Pawn(Piece.Color.BLACK));
			elements[Constants.WHITE_PAWN_ROW][i] = new Square(new Pawn(Piece.Color.WHITE));
		}

		// Inizialize empty Squares
		for (int i = Constants.BLACK_PAWN_ROW + 1; i < Constants.WHITE_PAWN_ROW; i++) {

			for (int j = Constants.FIRST_COLUMN; j <= Constants.LAST_COLUMN; j++) {

				elements[i][j] = new Square(null);
			}
		}
	}

	public String toString() {

		StringBuffer resBuffer = new StringBuffer();
		resBuffer.append(Constants.CB_LETTERS_COORDS);
		resBuffer.append(Constants.CB_FIRST_ROW);

		for (int i = Constants.FIRST_ROW; i <= Constants.LAST_ROW; i++) {

			for (int j = Constants.FIRST_COLUMN; j <= Constants.LAST_COLUMN; j++) {

				if (j == 0) {

					resBuffer.append(Math.abs(i - Constants.CB_DIMENSION) + " ");
				}

				resBuffer.append(Constants.CB_VERTICAL_SQUARE_SYMBOL);

				if (elements[i][j].isOccupied()) {

					resBuffer.append(" " + elements[i][j].getPiece().toString() + " ");
				} else {

					resBuffer.append(Constants.CB_EMPTY_SQUARE);
				}
			}

			resBuffer.append(Constants.CB_VERTICAL_SQUARE_SYMBOL + " "
					+ Math.abs(i - Constants.CB_DIMENSION) + "\n");
			if (i != Constants.LAST_ROW) {

				resBuffer.append(Constants.CB_MIDDLE_ROW_SQUARES);
			}
		}

		resBuffer.append(Constants.CB_LAST_ROW);
		resBuffer.append(Constants.CB_LETTERS_COORDS);

		return resBuffer.toString();
	}

	public void setMove(final Move currentMove) {

		Coordinates start = currentMove.getStartingPos();
		Coordinates end   = currentMove.getEndingPos();

		elements[start.getRow()][start.getColumn()].setPiece(null);
		elements[end.getRow()][end.getColumn()].setPiece(currentMove.getPiece());

		if (currentMove.getEnPassant()) {

			int addR;

			if (currentMove.getPiece().getColor() == Piece.Color.WHITE) {

				addR = Constants.DOWN_DIRECTION;
			} else {

				addR = Constants.UP_DIRECTION;
			}

			elements[end.getRow() + addR][end.getColumn()].setPiece(null);
		}
	}

	public Square getSquare(final Coordinates coord) {

		return elements[coord.getRow()][coord.getColumn()];
	}
}
