package it.uniba.game;

import it.uniba.game.pieces.Piece;
import it.uniba.game.pieces.Knight;
import it.uniba.game.pieces.Rook;
import it.uniba.game.pieces.King;
import it.uniba.game.pieces.Queen;
import it.uniba.game.pieces.Pawn;
import it.uniba.game.pieces.Bishop;
import it.uniba.game.pieces.Piece.Color;
import it.uniba.game.board.ChessBoard;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
* Class representing a chess match <br>
* Class type : &#60; Control &#62; <br><br>
*
* Responsibilities : <br>
*
* 	Knows : <br>
* 		<ul>
* 		<li>The current status of the ChessBoard</li>
* 		<li>Captured pieces by each player</li>
* 		<li>The history of the moves</li>
* 		<li>The current player</li>
* 		<li>The last long move done by a pawn</li>
* 		</ul>
*	Does : <br>
*		<ul>
*		<li>Parsifies the move given an input string</li>
*		<li>Establishes whether the move is a Castling, a Capture or a simple one</li>
*		<li>Checks whether the established move is legal and not ambiguous</li>
*		<li>Executes the move, if legal</li>
*		<li>Updates the status of Rooks and Kings in order to say if the former can be
*		captured <i>en passant</i>, or the latter can execute Castling</li>
*		<li>Records the captures done by the players</li>
*		<li>Updates the color of the current player according to the flow of the game</li>
* 		</ul>
*
* @author LeCun group
*/



public final class Match {

	/**
	 * Represents the field of the match.
	 */
	private ChessBoard field;

	/**
	 * Contains the black player captures.
	 */
	private LinkedList<Piece> blackCaptured;

	/**
	 * Contains the white player captures.
	 */
	private LinkedList<Piece> whiteCaptured;

	/**
	 * Contains the moves of the match.
	 */
	private LinkedList<String> moves;

	/**
	 * Color of the current player.
	 */
	private Piece.Color currentPlayer;

	/**
	 * Last position of the black king.
	 */
	private Coordinates blackKingPosition;

	/**
	 * Last position of the white king.
	 */
	private Coordinates whiteKingPosition;

	/**
	 * Last position of the last pawn that did a long move.
	 */
	private Coordinates lastPawnLongMove;

	/**
	 * Constructor of the class Match
	 * It initializes the currentPlayer to WHITE and
	 * creates a new ChessBoard with the pieces at the initial position of a classic chess game.
	 */
	public Match() {

		currentPlayer = Piece.Color.WHITE;
		blackCaptured = new LinkedList<Piece>();
		whiteCaptured = new LinkedList<Piece>();
		moves = new LinkedList<String>();
		field = new ChessBoard();
		blackKingPosition = new Coordinates(Constants.KING_COL, Constants.BLACK_SIDE_ROW);
		whiteKingPosition = new Coordinates(Constants.KING_COL, Constants.WHITE_SIDE_ROW);
		lastPawnLongMove = Constants.EMPTY_COORD;
	}

	/**
	 * Method used to execute a move entered by a player.<br>
	 * The move must be entered in correct Italian algebraic notation.
	 * It checks whether the passed move is a castling, a normal move
	 * or a capture. If a move is legal, it will be added to the history
	 * of the moves, if it is a capture, the captured piece will be added
	 * to the list of captures. Eventually, it will flag the rooks and the
	 * king as "moved" (not capable of a castling).
	 * 
	 * @param toParse Player move represented as a string.
	 * 
	 * @throws MatchException Raised if the user tries to enter an irregular or incorrect move.
	 */
	public void inputMove(final String toParse) throws MatchException {

		Move parsedMove = parseMove(toParse);

		if (parsedMove.getCastling() == Move.Castling.NO_CASTLING) {

			boolean isRookMoved = false;
			findToMove(parsedMove);

			if (parsedMove.getPiece().getClass() == King.class) {

				((King) parsedMove.getPiece()).setMoved(true);
			} else if (parsedMove.getPiece().getClass() == Rook.class) {

				isRookMoved = ((Rook) parsedMove.getPiece()).isMoved();
				((Rook) parsedMove.getPiece()).setMoved(true);
			}

			if (parsedMove.getCaptureFlag()) {

				insertCapture(parsedMove);
			}

			field.setMove(parsedMove);

			if (parsedMove.getPiece().getClass() != King.class) {

				if ((parsedMove.getPiece().getColor() == Piece.Color.BLACK
					&& checkKingThreat(new Move(new King(Color.BLACK),
						null, blackKingPosition, false)))
					|| ((parsedMove.getPiece().getColor() == Color.WHITE)
					&& checkKingThreat(new Move(
						new King(Color.WHITE), null, whiteKingPosition, false)))) {

					if (parsedMove.getPiece().getClass() == Rook.class) {

						((Rook) parsedMove.getPiece()).setMoved(isRookMoved);
					}

					field.setMove(new Move(parsedMove.getPiece(),
							parsedMove.getEndingPos(), parsedMove.getStartingPos(), false));
					if (parsedMove.getCaptureFlag()) {

						Coordinates resetPos;

						if (parsedMove.getEnPassant()) {

							resetPos = new Coordinates(
									lastPawnLongMove.getColumn(),
									lastPawnLongMove.getRow());
						} else {

							resetPos = new Coordinates(
									parsedMove.getEndingPos().getColumn(),
									parsedMove.getEndingPos().getRow());
						}

						if (parsedMove.getPiece().getColor() == Color.BLACK) {

							field.setMove(new Move(blackCaptured.getLast(),
									resetPos, resetPos, false));
							blackCaptured.remove(blackCaptured.size() - 1);
						} else {

							field.setMove(new Move(whiteCaptured.getLast(),
									resetPos, resetPos, false));
							whiteCaptured.remove(whiteCaptured.size() - 1);
						}
					}

					throw new MatchException(Constants.ERR_KING_THREAT);
				}
			} else {

				if (parsedMove.getPiece().getColor() == Piece.Color.BLACK) {

					blackKingPosition.setRow(parsedMove.getEndingPos().getRow());
					blackKingPosition.setColumn(parsedMove.getEndingPos().getColumn());
				} else {

					whiteKingPosition.setRow(parsedMove.getEndingPos().getRow());
					whiteKingPosition.setColumn(parsedMove.getEndingPos().getColumn());
				}
			}
			resetEnPassant();
			if (parsedMove.getPiece().getClass() == Pawn.class) {

				setEnPassantCondition(parsedMove);
			}
		} else {

			handleCastling(parsedMove.getCastling());
		}

		moves.add(toParse);
	}

	/**
	 * If lastPawnLongMove is not empty, it sets the lastPawnLongMove to the empty coordinate,
	 * otherwise it does nothing.
	 */
	private void resetEnPassant() {
		if (!lastPawnLongMove.equals(Constants.EMPTY_COORD)) {

			if (field.getSquare(lastPawnLongMove).isOccupied()
					&& field.getSquare(lastPawnLongMove).getPiece() instanceof Pawn) {

				lastPawnLongMove = Constants.EMPTY_COORD;
			}
		}
	}

	/**
	 * If the capture is en passant, it changes the ending coordinate of captureMove
	 * to the correct coordinates of the capture, otherwise it gets the ending coordinate
	 * of captureMove.
	 * Then, it takes the captured piece from the chessboard with the ending coordinate and
	 * adds it into the correct list of captured pieces.
	 * 
	 * @param captureMove move that triggers a capture.
	 */
	private void insertCapture(final Move captureMove) {
		Coordinates endingSquare;

		if (captureMove.getEnPassant()) {

			int addR = Constants.UP_DIRECTION;

			if (captureMove.getPiece().getColor() == Piece.Color.WHITE) {

				addR = Constants.DOWN_DIRECTION;
			}

			endingSquare = new Coordinates(captureMove.getEndingPos().getColumn(),
					captureMove.getEndingPos().getRow() + addR);
		} else {

			endingSquare = captureMove.getEndingPos();
		}

		Piece capturedPiece = field.getSquare(endingSquare).getPiece();

		if (capturedPiece.getColor() == Piece.Color.BLACK) {

			whiteCaptured.add(capturedPiece);
		} else {

			blackCaptured.add(capturedPiece);
		}
	}

	/**
	 * Return a string that contains the pieces captured by the side's color.
	 * 
	 * @param side Color of the player we want the captures.
	 * 
	 * @return a string that contains the pieces captured by the side's color.
	 */
	public String getPrintableCaptures(final Piece.Color side) {
		if (side == Piece.Color.WHITE) {

			return whiteCaptured.toString();
		} else {

			return blackCaptured.toString();
		}
	}

	/**
	 *  Returns a string that contains the move history in the format:
	 *  <ol>
	 *  	<li> e3, b6
	 *		<li> c4, f6
	 *	</ol>
	 *
	 *	@return a string that contains the move history.
	 */
	public String getPrintableMoves() {

		StringBuffer historyBuffer = new StringBuffer();

		int i = 0;
		int j = 1;
		while (i < moves.size()) {

			if (i % 2 == 0) {

				historyBuffer.append("\n" + j + ". ");
				j++;
			}

			historyBuffer.append(moves.get(i));

			if (i % 2 == 0) {

				historyBuffer.append(" ");
			}

			i++;
		}

		return historyBuffer.toString();
	}

	/**
	 * Return a string that contains the current status of the chessboard.
	 * 
	 * @return a string that contains the current status of the chessboard.
	 */
	public String getPrintableChessBoard() {

		return field.toString();
	}

	/**
	 * Return the color of the current player turn.
	 * 
	 * @return the color of the current player turn.
	 */
	public Piece.Color getCurrentPlayer() {

		return currentPlayer;
	}

	/**
	 * If the current player color is black, it changes currentPlayer to the color WHITE
	 * else, it changes currentPlayer to the color BLACK.
	 */
	public void nextTurn() {

		if (currentPlayer == Piece.Color.BLACK) {

			currentPlayer = Piece.Color.WHITE;
		} else {

			currentPlayer = Piece.Color.BLACK;
		}
	}

	/**
	 * Parses a move from a user entered string, following the algebraic notation <br>
	 * the general form for a recognized move is: <br>
	 * [Piece][Disambiguation coordinate][Capture][Landing square column][Landing square row].
	 * 
	 * @param toParse a string containing the move to be parsed.
	 * 
	 * @return an instance of the class Move.
	 * 
	 * @throws MatchExcption Raised if the move represented as string is badly formatted.
	 */
	private Move parseMove(final String toParse) throws MatchException {

		boolean validMove = Pattern.matches(Constants.GENERAL_MOVE_REGEX, toParse);
		int offsetFinalCoords = 0;

		if (validMove) {

			boolean capture = toParse.contains(Constants.MOVE_CAPTURE);

			Piece toMove = null;
			int offsetDisambiguation = 0;
			boolean enPassant = false;

			if (Pattern.matches(Constants.PIECE_MOVE_REGEX, toParse)) {

				switch (toParse.charAt(0)) {

					case Constants.CHAR_KING:
						toMove = new King(currentPlayer);
						break;
					case Constants.CHAR_QUEEN:
						toMove = new Queen(currentPlayer);
						break;
					case Constants.CHAR_ROOK:
						toMove = new Rook(currentPlayer);
						break;
					case Constants.CHAR_BISHOP:
						toMove = new Bishop(currentPlayer);
						break;
					case Constants.CHAR_KNIGHT:
						toMove = new Knight(currentPlayer);
						break;
					default:
				}

				offsetDisambiguation = 1;

				if (toParse.contains(Constants.STRING_EN_PASSANT)) {

					throw new MatchException(Constants.ERR_EN_PASSANT_BAD_TARGET);
				}
			} else {

				toMove = new Pawn(currentPlayer);


				if (toParse.contains(Constants.STRING_EN_PASSANT)) {

					if (!capture) {

						throw new MatchException(Constants.ERR_EN_PASSANT_NO_CAPTURE);
					}

					enPassant = true;
					offsetFinalCoords = Constants.EN_PASSANT_COORDS_OFFSET;
				}
			}

			Coordinates startPos = new Coordinates(Constants.INVALID_POS, Constants.INVALID_POS);
			Coordinates finalPos = new Coordinates((int) (toParse.charAt(toParse.length()
					- Constants.MOVE_COLUMN_OFFSET - offsetFinalCoords)
					- Constants.CHAR_COLUMN_OFFSET),
						Math.abs(Character.getNumericValue(toParse.charAt(toParse.length()
						- Constants.MOVE_ROW_OFFSET - offsetFinalCoords))
						- Constants.ROW_OFFSET));

			if (Pattern.matches(Constants.DISAMBIGUATION_REGEX, toParse)) {

				if ((int) toParse.charAt(offsetDisambiguation) >= Constants.CHAR_COLUMN_OFFSET) {

					startPos.setColumn((int) (toParse.charAt(offsetDisambiguation)
							- Constants.CHAR_COLUMN_OFFSET));
				} else {

					startPos.setRow(Math.abs(Character.getNumericValue(
							toParse.charAt(offsetDisambiguation)) - Constants.ROW_OFFSET));
				}
			}

			if (toMove.getClass() == Pawn.class
					&& startPos.getColumn() == Constants.INVALID_POS
					&& capture) {

				throw new MatchException(Constants.ERR_UNRECOGNIZED_MOVE);
			}

			Move returnMove = new Move(toMove, startPos, finalPos, capture);

			if (enPassant) {

				returnMove.setEnPassant();
			}

			return returnMove;
		} else if (Pattern.matches(Constants.CASTLING_REGEX, toParse)) {

			Move returnMove = new Move(null, null, null, false);

			if (toParse.length() == Constants.KINGSIDE_STRING_LENGHT) {

				returnMove.setCastling(Move.Castling.KINGSIDE_CASTLING);
			} else {

				returnMove.setCastling(Move.Castling.QUEENSIDE_CASTLING);
			}

			return returnMove;
		} else {

			throw new MatchException(Constants.ERR_UNRECOGNIZED_MOVE);
		}
	}

	/**
	 * Sets the starting position of the move passed by argument, checking
	 * the possible coordinates that return the reverseMove of the piece to move.
	 * 
	 * @param toMove move that needs a starting position.
	 * 
	 * @throws MatchException if the move is illegal, irregular or ambiguous, with a specific message.
	 */
	private void findToMove(final Move toMove) throws MatchException {

		LinkedList<Coordinates> possibleSquares = toMove.getPiece().reverseMove(toMove);

		//1. checking if there are possible pieces to move in the LinkedList possibleSquares
		int i = 0;

		while (i < possibleSquares.size()) {

			if (field.getSquare(possibleSquares.get(i)).isOccupied()
					&& field.getSquare(possibleSquares.get(i))
					.getPiece().equals(toMove.getPiece())) {

				i++;
			} else {

				possibleSquares.remove(i);
			}
		}
		// now possibleSquares contains the Coordinates where there's a possible piece to move in the field

		//2. checks whether the target square is full when capturing, empty when moving
		if (toMove.getCaptureFlag()) {

			if (toMove.getPiece().getClass() == Pawn.class) {

				handlePawn(toMove, possibleSquares);
			} else if (!field.getSquare(toMove.getEndingPos()).isOccupied()
					|| (field.getSquare(toMove.getEndingPos()).getPiece().getColor()
							== toMove.getPiece().getColor())) {

				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}
		} else {
			if (field.getSquare(toMove.getEndingPos()).isOccupied()) {

				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}
		}

		//3. checks whether there's a piece in the middle
		if (toMove.getPiece().getClass() != Pawn.class
				&& toMove.getPiece().getClass() != Knight.class) {

			int k = 0;

			while (k < possibleSquares.size()) {

				if (!getObstructingPieces(possibleSquares.get(k),
						toMove.getEndingPos()).isEmpty()) {

					possibleSquares.remove(k);
				} else {

					k++;
				}
			}
		}

		// 4. solves ambiguities
		if (possibleSquares.size() > 1) {

			solveAmbiguousMoves(possibleSquares, toMove);
		}

		// if there are no alternatives raise an exception
		if (possibleSquares.isEmpty()) {

				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
		} else if ((toMove.getStartingPos().getColumn() != Constants.INVALID_POS
				&& toMove.getStartingPos().getColumn() != possibleSquares.getFirst().getColumn())
				|| (toMove.getStartingPos().getRow() != Constants.INVALID_POS
				&& toMove.getStartingPos().getRow() != possibleSquares.getFirst().getRow())) {

				//if the user tries to give a wrong disambiguation when not needed
				throw new MatchException(Constants.ERR_BAD_DISAMBIGUATION);
		}

		if (toMove.getPiece().getClass() == King.class) {

			if (checkKingThreat(toMove)) {

				throw new MatchException(Constants.ERR_KING_THREAT);
			}
		}

		toMove.setStartingPos(possibleSquares.getFirst());
	}

	/**
	 * Return a list of pieces that are between the startingPos and the endingPos,
	 * in horizontally if the coordinates have the same row,
	 * in vertically if the coordinates have the same column
	 * or diagonally if the coordinates have different column and row.
	 * 
	 * @param startingPos coordinate from which to start looking for pieces.
	 * @param endingPos coordinate in which to stop the search for pieces.
	 * 
	 * @return a list of pieces that are between the startingPos and the endingPos.
	 */
	private LinkedList<Piece> getObstructingPieces(final Coordinates startingPos, final Coordinates endingPos) {

		int addR;
		int addC;

		LinkedList<Piece> toReturn = new LinkedList<Piece>();

		if (startingPos.getRow() == endingPos.getRow()) {

			addR = Constants.STILL_DIRECTION;
		} else if (startingPos.getRow() > endingPos.getRow()) {

			addR = Constants.UP_DIRECTION;
		} else {

			addR = Constants.DOWN_DIRECTION;
		}

		if (startingPos.getColumn() == endingPos.getColumn()) {

			addC = Constants.STILL_DIRECTION;
		} else if (startingPos.getColumn() > endingPos.getColumn()) {

			addC = Constants.LEFT_DIRECTION;
		} else {

			addC = Constants.RIGHT_DIRECTION;
		}

		for (int i = startingPos.getRow() + addR, j = startingPos.getColumn() + addC;
				i != endingPos.getRow() || j != endingPos.getColumn();
				i += addR, j += addC) {

			if (field.getSquare(new Coordinates(j, i)).isOccupied()) {

				toReturn.add(field.getSquare(new Coordinates(j, i)).getPiece());
			}
		}

		return toReturn;
	}

	/**
	 * It resolves ambiguous moves, choosing between the list of possibleSquares, the right
	 * starting position for toMove, or if there are more than one, or none, starting position
	 * at the end of the function, it throws a MatchException.
	 * 
	 * @param possibleSquares list of possible starting coordinates for the move toMove.
	 * @param toMove the move that needs a starting coordinate.
	 * 
	 * @throws MatchException if the move is illegal or irregular, or if the list of possible
	 * starting positions, at the end of the function, has more of one coordinate.
	 */
	private void solveAmbiguousMoves(final LinkedList<Coordinates> possibleSquares,
			final Move toMove) throws MatchException {

		if (toMove.getStartingPos().getRow() != Constants.INVALID_POS) {

			Iterator<Coordinates> j = possibleSquares.iterator();

			while (j.hasNext()) {

				Coordinates toCompare = j.next();

				if (toCompare.getRow() != toMove.getStartingPos().getRow()) {

					j.remove();
				}
			}
		} else if (toMove.getStartingPos().getColumn() != Constants.INVALID_POS) {

			Iterator<Coordinates> j = possibleSquares.iterator();
			while (j.hasNext()) {

				Coordinates toCompare = j.next();
				if (toCompare.getColumn() != toMove.getStartingPos().getColumn()) {

					j.remove();
				}
			}
		} else {

			throw new MatchException(Constants.ERR_AMBIGUOUS_MOVE);
		}

		// if there's still more than one alternative raise an exception <br>
		if (possibleSquares.size() > 1) {

			throw new MatchException(Constants.ERR_BAD_DISAMBIGUATION);
		}
	}

	/**
	 * Handles the various possibilities of a Pawn move.
	 * It checks whether the move is an En Passant, and its legality.
	 * Updates the attribute <code>lastPawnMove</code> if the pawn
	 * does a long move.
	 * 
	 * @param toMove Move parsed from the string entered by the user.
	 * @param possibleSquares Possible starting squares from where the pawn can be positioned.
	 * 
	 * @throws MatchException Raised if the move is not legal.
	 */
	private void handlePawn(final Move toMove,
			final LinkedList<Coordinates> possibleSquares) throws MatchException {

		if (!field.getSquare(toMove.getEndingPos()).isOccupied()) {

			int addR;

			if (toMove.getPiece().getColor() == Piece.Color.WHITE) {

				addR = Constants.DOWN_DIRECTION;
			} else {

				addR = Constants.UP_DIRECTION;
			}

			Coordinates toCheck = new Coordinates(toMove.getEndingPos().getColumn(),
					toMove.getEndingPos().getRow() + addR);

			if (field.getSquare(toCheck).isOccupied()) {

				if ((field.getSquare(toCheck).getPiece().getClass() == Pawn.class)
						&& (field.getSquare(toCheck).getPiece().getColor()
								!= toMove.getPiece().getColor())) {

					if (toCheck.equals(lastPawnLongMove)) {

						toMove.setEnPassant();
					} else {

						// exception regarding the impossibility of doing
						// an EnPassant move on the target pawn <br>
						throw new MatchException(Constants.ERR_EN_PASSANT);
					}
				} else {

					// exception regarding an incorrect EnPassant move
					throw new MatchException(Constants.ERR_EN_PASSANT_BAD_TARGET);
				}
			} else {

				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}
		} else if ((field.getSquare(toMove.getEndingPos()).getPiece().getColor()
				!= toMove.getPiece().getColor())) {

			if (toMove.getEnPassant()) {

				throw new MatchException(Constants.ERR_EN_PASSANT);
			}
		} else {

			// exception regarding the wrong target piece which has to be captured
			throw new MatchException(Constants.ERR_BAD_TARGET);
		}
	}

	/**
	 * Checks if the move is a long move of a pawn, and if so,
	 * saves the ending position of the move in lastPawnLongMove, for
	 * a future en passant move.
	 * 
	 * @param toCheck the move to check if it's a long pawn move.
	 */
	private void setEnPassantCondition(final Move toCheck) {

		if (Math.abs(toCheck.getStartingPos().getRow()
				- toCheck.getEndingPos().getRow()) == Constants.LONG_MOVE_LENGTH) {

			lastPawnLongMove = new Coordinates(toCheck.getEndingPos().getColumn(),
					toCheck.getEndingPos().getRow());
		}
	}

	/**
	 * Checks if the king is threatened by a move of its own
	 * (the move is irregular).
	 * 
	 * @param toMove King move to be checked.
	 * 
	 * @return Returns True if the king is threatened after the move execution, false if otherwise.
	 */
	private Boolean checkKingThreat(final Move toMove) {

		LinkedList<Coordinates> squaresToCheck;
		//LinkedList containing the coordinates for possibles threatening pieces
		squaresToCheck = Bishop.reverseBishopMove(toMove);

		Iterator<Coordinates> i = squaresToCheck.iterator();
		while (i.hasNext()) {

			Coordinates toCompare = i.next();
			if ((field.getSquare(toCompare).getPiece() != null)
					&& (field.getSquare(toCompare).getPiece().getClass() == Bishop.class
					|| field.getSquare(toCompare).getPiece().getClass() == Queen.class)) {

				if (field.getSquare(toCompare).getPiece().getColor() != toMove.getPiece().getColor()) {

					LinkedList<Piece> obstructors
						= getObstructingPieces(toCompare, toMove.getEndingPos());
					if (obstructors.isEmpty() || (obstructors.size() == 1
							&& (obstructors.getFirst().getClass() == King.class))) {
						return true;
					}
				}
			}
		}

		squaresToCheck = Rook.reverseRookMove(toMove);

		i = squaresToCheck.iterator();
		while (i.hasNext()) {

			Coordinates toCompare = i.next();
			if ((field.getSquare(toCompare).getPiece() != null)
					&& (field.getSquare(toCompare).getPiece().getClass() == Rook.class
					|| field.getSquare(toCompare).getPiece().getClass() == Queen.class)) {

				if (field.getSquare(toCompare).getPiece().getColor() != toMove.getPiece().getColor()) {

					LinkedList<Piece> obstructors =
							getObstructingPieces(toCompare, toMove.getEndingPos());
					if (obstructors.isEmpty() || (obstructors.size() == 1
							&& (obstructors.getFirst().getClass() == King.class))) {

						return true;
					}
				}
			}
		}

		squaresToCheck = Knight.reverseKnightMove(toMove);

		i = squaresToCheck.iterator();
		while (i.hasNext()) {

			Coordinates toCompare = i.next();

			if ((field.getSquare(toCompare).isOccupied())
					&& (field.getSquare(toCompare).getPiece().getClass() == Knight.class)) {

				if (field.getSquare(toCompare).getPiece().getColor() != toMove.getPiece().getColor()) {

					return true;
				}
			}
		}

		int rowToCheck;

		if (toMove.getPiece().getColor() == Piece.Color.BLACK) {

			rowToCheck = toMove.getEndingPos().getRow() + Constants.DOWN_DIRECTION;
		} else {

			rowToCheck = toMove.getEndingPos().getRow() + Constants.UP_DIRECTION;
		}

		int firstColToCheck = toMove.getEndingPos().getColumn() + Constants.LEFT_DIRECTION;
		int secondColToCheck = toMove.getEndingPos().getColumn() + Constants.RIGHT_DIRECTION;

		if (rowToCheck >= Constants.FIRST_ROW && rowToCheck <= Constants.LAST_ROW) {

			if (firstColToCheck >= Constants.FIRST_COLUMN && firstColToCheck <= Constants.LAST_COLUMN) {

				if ((field.getSquare(new Coordinates(firstColToCheck,
						rowToCheck)).getPiece() != null)) {

					if (field.getSquare(new Coordinates(firstColToCheck, rowToCheck))
							.getPiece().getClass() == Pawn.class
							&& field.getSquare(new Coordinates(firstColToCheck, rowToCheck))
							.getPiece().getColor() != toMove.getPiece().getColor()) {

						return true;
					}
				}
			}

			if (secondColToCheck >= Constants.FIRST_COLUMN && secondColToCheck <= Constants.LAST_COLUMN) {

				if (!(field.getSquare(new Coordinates(secondColToCheck, rowToCheck))
						.getPiece() == null)) {

					if (field.getSquare(new Coordinates(secondColToCheck, rowToCheck))
							.getPiece().getClass() == Pawn.class
							&& field.getSquare(new Coordinates(secondColToCheck,
							rowToCheck)).getPiece().getColor()
							!= toMove.getPiece().getColor()) {

						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Checks if the executed castling is possible, if so
	 * executes it.
	 * 
	 * @param castlingType Type of the castling entered by the user.
	 * 
	 * @throws MatchException Raised if the castling is not possible.
	 */
	private void handleCastling(final Move.Castling castlingType) throws MatchException {

		Coordinates kingStartingPosition;
		Coordinates rookStartingPosition;
		Coordinates kingEndingPosition;
		Coordinates rookEndingPosition;

		int rookStartingColumn;
		int rookEndingColumn;
		int kingEndingColumn;

		if (castlingType == Move.Castling.KINGSIDE_CASTLING) {

			rookStartingColumn = Constants.R_ROOK_COL;
			rookEndingColumn = Constants.KS_ROOK_ENDING_COL;
			kingEndingColumn = Constants.KS_KING_ENDING_COL;
		} else {

			rookStartingColumn = Constants.L_ROOK_COL;
			rookEndingColumn = Constants.QS_ROOK_ENDING_COL;
			kingEndingColumn = Constants.QS_KING_ENDING_COL;
		}

		if (currentPlayer == Piece.Color.WHITE) {

			kingStartingPosition = new Coordinates(Constants.KING_COL, Constants.WHITE_SIDE_ROW);
			rookStartingPosition = new Coordinates(rookStartingColumn, Constants.WHITE_SIDE_ROW);
			kingEndingPosition = new Coordinates(kingEndingColumn, Constants.WHITE_SIDE_ROW);
			rookEndingPosition = new Coordinates(rookEndingColumn, Constants.WHITE_SIDE_ROW);
		} else {

			kingStartingPosition = new Coordinates(Constants.KING_COL, Constants.BLACK_SIDE_ROW);
			rookStartingPosition = new Coordinates(rookStartingColumn, Constants.BLACK_SIDE_ROW);
			kingEndingPosition = new Coordinates(kingEndingColumn, Constants.BLACK_SIDE_ROW);
			rookEndingPosition = new Coordinates(rookEndingColumn, Constants.BLACK_SIDE_ROW);
		}

		if (field.getSquare(kingStartingPosition).isOccupied()
				&& field.getSquare(kingStartingPosition).getPiece().getClass() == King.class
				&& !(((King) field.getSquare(kingStartingPosition).getPiece()).isMoved())) {

				// doesn't check the color since it would imply movement
			if (field.getSquare(rookStartingPosition).isOccupied()
					&& field.getSquare(rookStartingPosition).getPiece().getClass() == Rook.class
					&& !(((Rook) field.getSquare(rookStartingPosition).getPiece()).isMoved())) {

				if (getObstructingPieces(kingStartingPosition, rookStartingPosition).isEmpty()) {

					King kingToPlace = new King(currentPlayer);
					Move checkThreat1 = new Move(kingToPlace, null,
							kingStartingPosition, false); //move wrapper

					Move checkThreat2 = new Move(kingToPlace, null,
							rookEndingPosition, false); //move wrapper

					Move kingMove = new Move(kingToPlace, kingStartingPosition,
							kingEndingPosition, false);

					if (!checkKingThreat(checkThreat1)
							&& !checkKingThreat(checkThreat2)
							&& !checkKingThreat(kingMove)) {

						Rook rookToPlace = new Rook(currentPlayer);
						Move rookMove = new Move(rookToPlace, rookStartingPosition,
								rookEndingPosition, false);
						kingToPlace.setMoved(true);
						rookToPlace.setMoved(true);

						resetEnPassant();

						field.setMove(kingMove);
						field.setMove(rookMove);
					} else {

						throw new MatchException(Constants.ERR_NC_KING_THREATENED);
					}
				} else {

					throw new MatchException(Constants.ERR_NC_PATH_OBSTR);
				}
			} else {

				throw new MatchException(Constants.ERR_NC_ROOK_MOVED);
			}
		} else {

			throw new MatchException(Constants.ERR_NC_KING_MOVED);
		}
	}
}
