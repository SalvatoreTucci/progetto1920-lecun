package it.uniba.game;

import it.uniba.game.pieces.*;
import it.uniba.game.board.ChessBoard;
import java.util.Vector;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
* Match
* Class type : <<Control>>
* Responsibilities :
* 	Knows :
* 		<ul>
* 		<li>The current status of the ChessBoard</li>
* 		<li>Captured pieces by each player</li>
* 		<li>The history of the moves</li>
* 		<li>The current player</li>
* 		</ul>
*	Does : 
*		<ul>
*		<li>Parsifies the move given an input string</li>
*		<li>Establishes whether the move is a Castling, a Capture or a simple one</li>
*		<li>Checks whether the established move is legal and not ambiguous</li>
*		<li>Executes the move, if legal</li>
*		<li>Updates the status of Pawns, Rooks and Kings in order to say if the former can be
*			captured "en passant", or the latter can execute Castling</li> 
*		<li>Records the captures done by the players</li>
*		<li>Can update the current player</li>
* 		</ul>
*
* @author LeCun group
*/
class Match {
	/*
	 * Class used to manage the flow of the game
	 */

	// Attributes
	private ChessBoard field;
	private Vector<Piece> blackCaptured;
	private Vector<Piece> whiteCaptured;
	private Vector<String> moves;
	private Piece.Color currentPlayer;
	private Coordinates lastPawnLongMove;
	

	// Methods
	public Match() {
		
		currentPlayer = Piece.Color.WHITE;
		blackCaptured = new Vector<Piece>();
		whiteCaptured = new Vector<Piece>();
		moves = new Vector<String>();
		field = new ChessBoard();
		lastPawnLongMove = Constants.EMPTY_COORD;
	}
	
	public void inputMove(String toParse) throws MatchException {

		Move parsedMove = parseMove(toParse);
		if (parsedMove.getCastling() == Move.Castling.NO_CASTLING) {
			findToMove(parsedMove);
			
			resetEnPassant();
			
			if (parsedMove.getPiece().getClass() == Pawn.class) {
			
				setPawnEnPassantFlag(parsedMove);
			}
			else if (parsedMove.getPiece().getClass() == King.class) {
				
				((King) parsedMove.getPiece()).setMoved(true);
			}
			else if (parsedMove.getPiece().getClass() == Rook.class) {
				
				((Rook) parsedMove.getPiece()).setMoved(true);
			}
			
			if (parsedMove.getCaptureFlag()) {
			
				insertCapture(parsedMove);
			}
			
			field.setMove(parsedMove);
			
		} else {
			
			handleCastling(parsedMove.getCastling());
		}
			
		moves.add(toParse);

	}
	
	private void resetEnPassant() {
		if(!lastPawnLongMove.equals(Constants.EMPTY_COORD)) {

			if(field.getSquare(lastPawnLongMove).isOccupied() 
					&& field.getSquare(lastPawnLongMove).getPiece() instanceof Pawn) {
				
				((Pawn) field.getSquare(lastPawnLongMove).getPiece()).setEnPassant(false);
				lastPawnLongMove = Constants.EMPTY_COORD;
				
			}
		}
	}
	
	void insertCapture(Move captureMove) {
		
		Coordinates endingSquare;
		
		if (captureMove.getEnPassant()) {
			
			int addR = ( captureMove.getPiece().getColor() == Piece.Color.WHITE )
					? Constants.DOWN_DIRECTION : Constants.UP_DIRECTION;
			
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
	
	public String getPrintableCaptures(Piece.Color side) {
		
		if (side == Piece.Color.WHITE) {
			
			return whiteCaptured.toString();			
		} else {
			
			return blackCaptured.toString();	
		}
		
	}
	
	/*
	 *  Returns a printable version of the move history, as in
	 *  1. e3, b6
	 *	2. c4, f6
	 */
	public String getPrintableMoves() {

		
		String printableHistory = new String();

		int i = 0;
		int j = 1;
		while (i < moves.size()) {
			
			if (i % 2 == 0) {
				printableHistory += "\n" + j + ". ";
				j++;
			}
			
			printableHistory += moves.elementAt(i);
			
			if (i % 2 == 0) {
				printableHistory += " ";
			}
			
			i++;
		}
		
		return printableHistory;
		
	}
	
	public String getPrintableChessBoard() {
		
		return field.toString();
	}
	
	public Piece.Color getCurrentPlayer() {
		
		return currentPlayer;
	}
	
	// method used to proceed in the game flow
	public void nextTurn() {

		
		if (currentPlayer == Piece.Color.BLACK) {
			
			currentPlayer = Piece.Color.WHITE;	
		} else {
			
			currentPlayer = Piece.Color.BLACK;
		}
		
	}

	/* 
	 * Parses a move from a user entered string, following the algebraic notation
	 * the general form for a recognized move is:
	 * [Piece][Disambiguation coordinate][Capture][Landing square column][Landing square row]
	 * 
	 * @param toParse a string containing the move to be parsed
	 * @return an instance of the class Move
	 */ 
	private Move parseMove(String toParse) throws MatchException {
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
				
				if(toParse.contains(Constants.STRING_EN_PASSANT)) {
					
					throw new MatchException(Constants.ERR_EN_PASSANT_BAD_TARGET);
				}
				
			} else {
				
				toMove = new Pawn(currentPlayer);
				
				if(toParse.contains(Constants.STRING_EN_PASSANT)) {
					
					if(!capture) {
						
						throw new MatchException(Constants.ERR_EN_PASSANT_NO_CAPTURE);
					}
					
					enPassant = true;
					offsetFinalCoords = Constants.EN_PASSANT_COORDS_OFFSET;
				}
			}
			
			Coordinates startPos = new Coordinates(Constants.INVALID_POS, Constants.INVALID_POS);
			Coordinates finalPos = new Coordinates((int) (toParse.charAt(toParse.length() 
					- Constants.MOVE_COLUMN_OFFSET - offsetFinalCoords) - Constants.CHAR_COLUMN_OFFSET),
						Math.abs(Character.getNumericValue(toParse.charAt(toParse.length() 
							- Constants.MOVE_ROW_OFFSET  - offsetFinalCoords)) - Constants.ROW_OFFSET));
			
			if (Pattern.matches(Constants.DISAMBIGUATION_REGEX, toParse)) {
				
				if ((int) toParse.charAt(offsetDisambiguation) >= Constants.CHAR_COLUMN_OFFSET) {
					
					startPos.setColumn((int) (toParse.charAt(offsetDisambiguation) - Constants.CHAR_COLUMN_OFFSET));	
				} else {
					
					startPos.setRow(Math.abs(Character.getNumericValue(toParse.charAt(offsetDisambiguation)) - Constants.ROW_OFFSET));
				}
				
			}
			
			if (toMove.getClass() == Pawn.class && startPos.getColumn() 
					== Constants.INVALID_POS && capture) {
				
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
	
	private void findToMove(Move toMove) throws MatchException {
		
		Vector<Coordinates> possibleSquares = toMove.getPiece().reverseMove(toMove);
		
		// checking if there are possible pieces to move in the vector possibleSquares
		
		int i = 0;
		while (i < possibleSquares.size()) {
			if (field.getSquare( possibleSquares.get(i) ).isOccupied() 
					&& field.getSquare( possibleSquares.get(i) ).getPiece().equal(toMove.getPiece())) {
				
				i++ ;
			} else {
				
				possibleSquares.remove(i);
			}
		}

		
		// now possibleSquares contains the Coordinates where there's a possible piece to move in the field
		
		// if we're handling a capture, the control is passed to a more specific method
		
		if (toMove.getCaptureFlag()) {
			
			 this.findToMoveCapture(toMove, possibleSquares);
		} else {
			
			if (toMove.getPiece().getClass() != Knight.class) {
			// checks whether there's a piece in the middle
				int k = 0;
				while (k < possibleSquares.size()) {
	
					if ( (!getObstructingPieces(possibleSquares.get(k), toMove.getEndingPos()).isEmpty())
							|| field.getSquare(toMove.getEndingPos()).isOccupied()) {
						
						possibleSquares.remove(k);
					} else {
						
						k++;
					}
					
				}
			
			} else {
				
				if (field.getSquare(toMove.getEndingPos()).isOccupied()) {
					
					throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
				}
				
			}
			
			
			
			
			if (possibleSquares.size() > 1) {
				
				solveAmbiguousMoves(possibleSquares, toMove);
			}
			
			// if there are no alternatives raise an exception
			if (possibleSquares.isEmpty()) {
				
					throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}
			
			if (toMove.getPiece().getClass() == King.class) {
				
				if (checkKingThreat(toMove)) {
					
					throw new MatchException(Constants.ERR_KING_THREAT);
				}
			} 
			
			toMove.setStartingPos(possibleSquares.firstElement());
			
		}

	}

	// specific method which handles the situation where the move is a capture
	private void findToMoveCapture(Move toMove, Vector<Coordinates> possibleSquares) throws MatchException {
		
		if (toMove.getPiece().getClass() == Pawn.class) {
			
			handlePawn(toMove, possibleSquares);
			
		} else if ( field.getSquare(toMove.getEndingPos()).isOccupied() 
				&& (field.getSquare(toMove.getEndingPos()).getPiece().getColor() 
						!= toMove.getPiece().getColor()) ) {
			
			
			if (toMove.getPiece().getClass() != Knight.class) {

				int i = 0;
				while (i < possibleSquares.size()) {
				
					
					if ( !getObstructingPieces(possibleSquares.get(i), toMove.getEndingPos()).isEmpty() ) {
					
						possibleSquares.remove(i);
					} else {
						
						i++;
					}
				}
			}
			
			if (possibleSquares.size() > 1) {
			
				solveAmbiguousMoves(possibleSquares, toMove);
			}
			
			if (possibleSquares.isEmpty()) {
				
				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}


			toMove.setStartingPos(possibleSquares.firstElement());
		} else {
			
			throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
		}
		
	}
	
	private Vector<Piece> getObstructingPieces (Coordinates startingPos, Coordinates endingPos) {
		
		int addR;
		int addC;
		
		Vector<Piece> toReturn = new Vector<Piece>(); 
		
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
				i += addR, j += addC ) {
			
			if (field.getSquare(new Coordinates(j, i)).isOccupied()) {
				
				toReturn.add(field.getSquare(new Coordinates(j, i)).getPiece());
			}
			
		}
		return toReturn;
		
	}
	
	// Solves possible ambiguous moves
	private void solveAmbiguousMoves(Vector<Coordinates> possibleSquares, Move toMove) throws MatchException {
		
		
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
		
		// if there's still more than one alternative raise an exception
		if (possibleSquares.size() > 1) {
			
			throw new MatchException(Constants.ERR_BAD_DISAMBIGUATION);
		}
		
	}
	
	private void handlePawn(Move toMove, Vector<Coordinates> possibleSquares) throws MatchException {
		
		if ( !field.getSquare(toMove.getEndingPos()).isOccupied() ) {
			
			int addR = ( toMove.getPiece().getColor() == Piece.Color.WHITE ) 
					? Constants.DOWN_DIRECTION : Constants.UP_DIRECTION;
			
			Coordinates toCheck = new Coordinates(toMove.getEndingPos().getColumn(), toMove.getEndingPos().getRow() + addR);
			
			if (field.getSquare(toCheck).isOccupied()) {
				
				if (( field.getSquare(toCheck).getPiece().getClass() == Pawn.class ) 
						&& ( field.getSquare(toCheck).getPiece().getColor() != toMove.getPiece().getColor() ) ) {
					
					Pawn enPass = (Pawn) field.getSquare(toCheck).getPiece();
					
					if (enPass.isEnPassant()) {
						
						if (possibleSquares.size() > 1) {
							
							solveAmbiguousMoves(possibleSquares, toMove);
						}
						
						if (!possibleSquares.isEmpty()) {
							
							toMove.setStartingPos(possibleSquares.firstElement());
							toMove.setEnPassant();
							
						} else {
							
							throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
						}
						
					} else {
						
						// exception regarding the impossibility of doing an EnPassant move on the target pawn
						throw new MatchException(Constants.ERR_EN_PASSANT);
					}
					
				} else {
					
					// exception regarding an incorrect EnPassant move
					throw new MatchException(Constants.ERR_EN_PASSANT_BAD_TARGET);
				}
				
			} else {
				
				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}
			

			
		} else if (( field.getSquare(toMove.getEndingPos()).getPiece().getColor() != toMove.getPiece().getColor() )) {
			
			if (possibleSquares.size() > 1) {
				
				solveAmbiguousMoves(possibleSquares, toMove);
			}
			
			if (!possibleSquares.isEmpty()) {
				
				toMove.setStartingPos(possibleSquares.firstElement());
				if(toMove.getEnPassant()) {
					
					throw new MatchException(Constants.ERR_EN_PASSANT);
				}
			} else {
				
				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}
			
		} else {
			
			// exception regarding the wrong target piece which has to be captured
			throw new MatchException(Constants.ERR_BAD_TARGET);
		}
		
	}
	
	
	private void setPawnEnPassantFlag(Move toCheck) {
		
		if (Math.abs(toCheck.getStartingPos().getRow() - toCheck.getEndingPos().getRow()) == Constants.LONG_MOVE_LENGTH) {
			
			
			((Pawn) toCheck.getPiece()).setEnPassant(true);
			lastPawnLongMove = new Coordinates(toCheck.getEndingPos().getColumn(),
					toCheck.getEndingPos().getRow());
			
		} else {
			
			((Pawn) toCheck.getPiece()).setEnPassant(false);
		}
		
	}
	
	private Boolean checkKingThreat(Move toMove) {
		
		
		
		Vector<Coordinates> squaresToCheck;			//vector containing the coordinates for possibles threatning pieces 
		squaresToCheck = Bishop.reverseBishopMove(toMove);	
		
		Iterator<Coordinates> i = squaresToCheck.iterator();
		while (i.hasNext()) {
	
			Coordinates toCompare = i.next();
			if ( (field.getSquare(toCompare).getPiece() != null) 
					&& (field.getSquare(toCompare).getPiece().getClass() == Bishop.class 
					|| field.getSquare(toCompare).getPiece().getClass() == Queen.class)) {
				
				if (field.getSquare(toCompare).getPiece().getColor() != toMove.getPiece().getColor()) {
					
					Vector<Piece> obstructors = getObstructingPieces(toCompare, toMove.getEndingPos());
					
					if (obstructors.isEmpty() || (obstructors.size() == 1 && (obstructors.firstElement().getClass()
							== King.class) ) ) {
					
						return true;
					}
				}
			}
		}
		
		squaresToCheck = Rook.reverseRookMove(toMove);
		
		i = squaresToCheck.iterator();
		while (i.hasNext()) {
			
			Coordinates toCompare = i.next();
			if ( (field.getSquare(toCompare).getPiece() != null) 
					&& (field.getSquare(toCompare).getPiece().getClass() == Rook.class 
					|| field.getSquare(toCompare).getPiece().getClass() == Queen.class)) {
				
				if (field.getSquare(toCompare).getPiece().getColor() != toMove.getPiece().getColor()) {
					
					Vector<Piece> obstructors = getObstructingPieces(toCompare, toMove.getEndingPos());
					
					if(obstructors.isEmpty() || (obstructors.size() == 1 && (obstructors.firstElement().getClass()
							== King.class) ) ) {
					
						return true;
						
					}
				}
			}
		}
		
		squaresToCheck = Knight.reverseKnightMove(toMove);
		
		i = squaresToCheck.iterator();
		while (i.hasNext()) {
			
			Coordinates toCompare = i.next();
			if ( (field.getSquare(toCompare).getPiece() != null) 
					&& (field.getSquare(toCompare).getPiece().getClass() == Knight.class) ) {
				
				if (field.getSquare(toCompare).getPiece().getColor() != toMove.getPiece().getColor()) {
					
					return true;
				}
			}
		}
		
		int rowToCheck =  toMove.getEndingPos().getRow() 
				+ ((toMove.getPiece().getColor() == Piece.Color.BLACK) 
						? Constants.DOWN_DIRECTION : Constants.UP_DIRECTION);
		
		
		int firstColToCheck = toMove.getEndingPos().getColumn() + Constants.LEFT_DIRECTION;
		int secondColToCheck = toMove.getEndingPos().getColumn() + Constants.RIGHT_DIRECTION;
		
		if (rowToCheck >= Constants.FIRST_ROW && rowToCheck <= Constants.LAST_ROW) {
			
			if (firstColToCheck >= Constants.FIRST_COLUMN && firstColToCheck <= Constants.LAST_COLUMN) {
				
				if ( (field.getSquare(new Coordinates(firstColToCheck, rowToCheck)).getPiece() != null))  {
					
					if (field.getSquare(new Coordinates(firstColToCheck, rowToCheck)).getPiece().getClass() == Pawn.class 
							&& field.getSquare(new Coordinates(firstColToCheck, rowToCheck)).getPiece().getColor() 
							!= toMove.getPiece().getColor()) {
						
						return true;
					}
				}
			}
			
			if (secondColToCheck >= Constants.FIRST_COLUMN && secondColToCheck <= Constants.LAST_COLUMN) {
				
				if ( !(field.getSquare(new Coordinates(secondColToCheck, rowToCheck)).getPiece() == null))  {
					
					if (field.getSquare(new Coordinates(secondColToCheck, rowToCheck)).getPiece().getClass() == Pawn.class 
							&& field.getSquare(new Coordinates(secondColToCheck, rowToCheck)).getPiece().getColor() 
							!= toMove.getPiece().getColor()) {
						
						return true;
					}
				}
			}
		}
		
		
		return false;     
	}

	private void handleCastling(Move.Castling castlingType) throws MatchException {
		
		Coordinates kingStartingPosition;
		Coordinates rookStartingPosition;
		Coordinates kingEndingPosition;
		Coordinates rookEndingPosition;
		
		int rookStartingColumn = (castlingType == Move.Castling.KINGSIDE_CASTLING)
				? Constants.R_ROOK_COL : Constants.L_ROOK_COL;
		int rookEndingColumn = (castlingType == Move.Castling.KINGSIDE_CASTLING)
				? Constants.KS_ROOK_ENDING_COL : Constants.QS_ROOK_ENDING_COL;
		int kingEndingColumn = (castlingType == Move.Castling.KINGSIDE_CASTLING) 
				? Constants.KS_KING_ENDING_COL : Constants.QS_KING_ENDING_COL;
		
		if (currentPlayer == Piece.Color.WHITE) {
			
			kingStartingPosition = new Coordinates(Constants.KING_COL, Constants.WHITE_SIDE_ROW);
			rookStartingPosition = new Coordinates(rookStartingColumn, Constants.WHITE_SIDE_ROW);
			kingEndingPosition = new Coordinates(kingEndingColumn, Constants.WHITE_SIDE_ROW);
			rookEndingPosition = new Coordinates(rookEndingColumn, Constants.WHITE_SIDE_ROW);
		} else {
			
			kingStartingPosition = new Coordinates(Constants.KING_COL, Constants.BLACK_SIDE_ROW);
			rookStartingPosition = new Coordinates(rookStartingColumn, Constants.BLACK_SIDE_ROW);
			kingEndingPosition= new Coordinates(kingEndingColumn, Constants.BLACK_SIDE_ROW);
			rookEndingPosition = new Coordinates(rookEndingColumn, Constants.BLACK_SIDE_ROW);
		}
		
		if ( field.getSquare(kingStartingPosition).isOccupied() 
				&& field.getSquare(kingStartingPosition).getPiece().getClass() == King.class
				&& !(((King)field.getSquare(kingStartingPosition).getPiece()).isMoved())) {
				// doesn't check the color since it would imply movement
			
			if ( field.getSquare(rookStartingPosition).isOccupied() 
					&& field.getSquare(rookStartingPosition).getPiece().getClass() == Rook.class
					&& !(((Rook)field.getSquare(rookStartingPosition).getPiece()).isMoved())) {	
				
				if (getObstructingPieces(kingStartingPosition, rookStartingPosition).isEmpty()) {
					
					King kingToPlace = new King(currentPlayer);
					Move checkThreat1 = new Move(kingToPlace, null, kingStartingPosition, false); //move wrapper
					Move checkThreat2 = new Move(kingToPlace, null, rookEndingPosition, false); //move wrapper
					Move kingMove = new Move(kingToPlace, kingStartingPosition, kingEndingPosition, false); 
					
					if (!checkKingThreat(checkThreat1) 
							&& !checkKingThreat(checkThreat2)
							&& !checkKingThreat(kingMove)) {
						
						Rook rookToPlace = new Rook(currentPlayer);
						Move rookMove = new Move(rookToPlace, rookStartingPosition, rookEndingPosition, false);
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
