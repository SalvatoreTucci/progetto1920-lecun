package it.uniba.game;
import it.uniba.game.pieces.*;
import it.uniba.game.board.ChessBoard;
import java.util.Vector;
import java.util.regex.Pattern;


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
	
	// Methods
	public Match() {
		
		currentPlayer = Piece.Color.WHITE;
		blackCaptured = new Vector<Piece>();
		whiteCaptured = new Vector<Piece>();
		moves = new Vector<String>();
		field = new ChessBoard();
		
	}
	
	public void inputMove(String toParse) throws MatchException {

		Move parsedMove = parseMove(toParse);
		findToMove(parsedMove);
		
		if(parsedMove.getPiece().getClass() == Pawn.class) {
		
			setPawnEnPassantFlag(parsedMove);
		}
		
		if(parsedMove.getCaptureFlag()){
			insertCapture(parsedMove);
		}
		
		field.setMove(parsedMove);
		
		moves.add(toParse);

	}
	
	void insertCapture(Move captureMove) {
		
		Coordinates endingSquare;
		
		if(captureMove.getEnPassant()) {
			
			int addR = ( captureMove.getPiece().getColor() == Piece.Color.WHITE ) ? Constants.DOWN_DIRECTION : Constants.UP_DIRECTION;
			endingSquare = new Coordinates(captureMove.getEndingPos().getColumn(), captureMove.getEndingPos().getRow() + addR);
			
		} else {
			
			endingSquare = captureMove.getEndingPos();
		}
		
		
		Piece capturedPiece = field.getSquare(endingSquare).getPiece();
		
		if(capturedPiece.getColor() == Piece.Color.BLACK){
			
			whiteCaptured.add(capturedPiece);
		}
		else{
			blackCaptured.add(capturedPiece);
		}
		
	}
	
	public String getPrintableCaptures(Piece.Color side) {
		
		if(side == Piece.Color.WHITE) {
			return whiteCaptured.toString();			
		}
		else {
			return blackCaptured.toString();	
		}
	}
	
	public String getPrintableMoves() {
		// returns a printable version of the move history, as in
		// 1. e3, b6
		// 2. c4, f6
		
		String printableHistory = "";

		int i = 0;
		int j = 1;
		while(i < moves.size()) {
			
			if(i % 2 == 0) {
				printableHistory += "\n" + j + ". ";
				j++;
			}
			
			printableHistory += moves.elementAt(i);
			
			if(i % 2 == 0) {
				printableHistory += ", ";
			}
			
			i++;
		}
		
		return printableHistory;
	}
	
	public String getPrintableChessBoard() {
		
		return field.toString();
	}
	
	public Piece.Color getCurrentPlayer(){
		
		return currentPlayer;
	}
	
	public void nextTurn() {
		// method used to proceed in the game flow
		
		if(currentPlayer == Piece.Color.BLACK) {
			currentPlayer = Piece.Color.WHITE;	
		}
		else {
			currentPlayer = Piece.Color.BLACK;
		}
	}

	private Move parseMove(String toParse) throws MatchException {
		// parses a move from a user entered string, following the algebraic notation
		// the general form for a recognized move is:
		// [Piece][Disambiguation coordinate][Capture][Landing square column][Landing square row]
		
		boolean validMove = Pattern.matches(Constants.GENERAL_MOVE_REGEX, toParse);
		
		if (validMove) {
			boolean capture = toParse.contains(Constants.MOVE_CAPTURE);
			Coordinates finalPos = new Coordinates((int) (toParse.charAt(toParse.length() - Constants.MOVE_COLUMN_OFFSET) - Constants.CHAR_COLUMN_OFFSET),
					Math.abs(Character.getNumericValue(toParse.charAt(toParse.length() - Constants.MOVE_ROW_OFFSET)) - Constants.ROW_OFFSET));
			
			Piece toMove = null;
			int offsetDisambiguation = 0;
			
			if (Pattern.matches(Constants.PIECE_MOVE_REGEX, toParse)) {
				switch(toParse.charAt(0)) {
					case Constants.CHAR_KING: 	toMove = new King(currentPlayer);
												break;
					case Constants.CHAR_QUEEN:	toMove = new Queen(currentPlayer);
												break;
					case Constants.CHAR_ROOK:	toMove = new Rook(currentPlayer);
												break;
					case Constants.CHAR_BISHOP:	toMove = new Bishop(currentPlayer);
												break;
					case Constants.CHAR_KNIGHT:	toMove = new Knight(currentPlayer);
												break;
					default:
				}
				offsetDisambiguation = 1;
				
			} else {
				toMove = new Pawn(currentPlayer);
				
			}
			
			Coordinates startPos = new Coordinates(Constants.INVALID_POS, Constants.INVALID_POS);
			
			if (Pattern.matches(Constants.DISAMBIGUATION_REGEX, toParse)) {
				
				if ((int) toParse.charAt(offsetDisambiguation) >= Constants.CHAR_COLUMN_OFFSET) {
					startPos.setColumn((int) (toParse.charAt(offsetDisambiguation) - Constants.CHAR_COLUMN_OFFSET));
					
				} else {
					
					startPos.setRow(Math.abs((int) toParse.charAt(offsetDisambiguation) - Constants.ROW_OFFSET));
				}
				
			}
			
			return new Move(toMove, startPos, finalPos, capture);
			
		} else {
			
			throw new MatchException(Constants.ERR_UNRECOGNIZED_MOVE);
		}
	}
	
	private void findToMove(Move toMove) throws MatchException {
		
		Vector<Coordinates> possibleSquares = toMove.getPiece().reverseMove(toMove);
		
		//checking if there are possible pieces to move in the vector possibleSquares
		int i = 0;
		while (i < possibleSquares.size()) {
			
			if (field.getSquare( possibleSquares.get(i) ).isOccupied() 
					&& field.getSquare( possibleSquares.get(i) ).getPiece().equal(toMove.getPiece())) {
				i++ ;
			} else {
				
				possibleSquares.remove(i);
			}
		}

		//now possibleSquares contains the Coordinates where there's a possible piece to move in the field
		
		//if we're handling a capture, the control is passed to a more specific method
		
		if (toMove.getCaptureFlag()) {
			
			 this.findToMoveCapture(toMove, possibleSquares);
			 
		} else {
			
			//check on there's a piece in the middle
			int k = 0;

			while (k < possibleSquares.size()) {

				if(isObstructed(possibleSquares.get(k), toMove.getEndingPos()) || field.getSquare(toMove.getEndingPos()).isOccupied()) {
					
					possibleSquares.remove(k);
				} else {
					
					k++;
				}
				
			}
			
			if(possibleSquares.size() > 1) {
				
				solveAmbiguousMoves(possibleSquares, toMove);
			}
			
			//if there are no alternatives raise an exception
			if (possibleSquares.size() == Constants.EMPTY_SIZE) {
				
				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}

			toMove.setStartingPos(possibleSquares.firstElement());
			
		}

	}

	//specific method which handles the situation where the move is a capture
	private void findToMoveCapture(Move toMove, Vector<Coordinates> possibleSquares) throws MatchException {
		
		if (toMove.getPiece().getClass() == Pawn.class) {
			
			handlePawn(toMove, possibleSquares);
			
		} else if ( field.getSquare(toMove.getEndingPos()).isOccupied() && (field.getSquare(toMove.getEndingPos()).getPiece().getColor() != toMove.getPiece().getColor()) ) {
			
			//to be expanded in further sprints
			//At the moment this block will throw an exception, because we can only move pawns for now 
			throw new MatchException(Constants.ERR_TEMP_BAD_MOVE);
		}
		
	}
	
	private boolean isObstructed (Coordinates startingPos, Coordinates endingPos) {
		
		int addR;
		int addC;
		
		if(startingPos.getRow() == endingPos.getRow()) {
			
			addR = Constants.STILL_DIRECTION;
		
		} else if(startingPos.getRow() > endingPos.getRow()) {
			
			addR = Constants.UP_DIRECTION;
			
		} else {
			
			addR = Constants.DOWN_DIRECTION;
		}
		
		if(startingPos.getColumn() == endingPos.getColumn()) {
			
			addC = Constants.STILL_DIRECTION;
		
		} else if(startingPos.getColumn() > endingPos.getColumn()) {
			
			addC = Constants.LEFT_DIRECTION;
			
		} else {
			
			addC = Constants.RIGHT_DIRECTION;
		}
		
		for (int i = startingPos.getRow() + addR, j = startingPos.getColumn() + addC;
				i != endingPos.getRow() || j != endingPos.getColumn();
				i += addR, j += addC ) {
			
			if (field.getSquare(new Coordinates(j, i)).isOccupied()) {
				
				return true;
			}
		}
		return false;
	}
	
	private void solveAmbiguousMoves(Vector<Coordinates> possibleSquares, Move toMove) throws MatchException {
		//solve possible ambiguous moves
		
		if (toMove.getStartingPos().getRow() != Constants.INVALID_POS) {
			
			int j = 0;
			while (j < possibleSquares.size()) {
				
				if (possibleSquares.get(j).getRow() != toMove.getStartingPos().getRow()) {
					
					possibleSquares.remove(j);
				} else {
					
					j++ ;
				}
			}
			
		} else if (toMove.getStartingPos().getColumn() != Constants.INVALID_POS) {
			
			int j = 0;
			while (j < possibleSquares.size()) {
				
				if (possibleSquares.get(j).getColumn() != toMove.getStartingPos().getColumn()) {
					
					possibleSquares.remove(j);
				} else {
					
					j++ ;
				}
			}
		} else {
			
			//exception-----------------------------------------------------------------
			throw new MatchException(Constants.ERR_BAD_DISAMBIGUATION);
		}
		
		//if there's still more than one alternative raise an exception
		if (possibleSquares.size() > 1) {
			
			//exception-----------------------------------------------------------------
			throw new MatchException(Constants.ERR_AMBIGUOUS_MOVE);
		}
		
	}
	
	private void handlePawn(Move toMove, Vector<Coordinates> possibleSquares) throws MatchException {
		
		if ( !field.getSquare(toMove.getEndingPos()).isOccupied() ) {
			
			int addR = ( toMove.getPiece().getColor() == Piece.Color.WHITE ) ? Constants.DOWN_DIRECTION : Constants.UP_DIRECTION;
			
			Coordinates toCheck = new Coordinates(toMove.getEndingPos().getColumn(), toMove.getEndingPos().getRow() + addR);
			
			if ( ( field.getSquare(toCheck).getPiece().getClass() == Pawn.class ) 
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
					
					//exception regarding the impossibility of doing an EnPassant move on the target pawn
					throw new MatchException(Constants.ERR_EN_PASSANT);
				}
				
			} else {
				
				//exception regarding an incorrect EnPassant move
				throw new MatchException(Constants.ERR_EN_PASSANT_BAD_TARGET);
			}
			
		} else if (( field.getSquare(toMove.getEndingPos()).getPiece().getColor() != toMove.getPiece().getColor() )) {
			
			if (possibleSquares.size() > 1) {
				
				solveAmbiguousMoves(possibleSquares, toMove);
			}
			
			if (!possibleSquares.isEmpty()) {
				
				toMove.setStartingPos(possibleSquares.firstElement());
				
			} else {
				
				throw new MatchException(Constants.ERR_ILLEGAL_MOVE);
			}
			
		} else {
			
			//exception regarding the wrong target piece which has to be captured
			throw new MatchException(Constants.ERR_BAD_TARGET);
		}
	}
	
	
	private void setPawnEnPassantFlag(Move toCheck) {
		
		if(Math.abs(toCheck.getStartingPos().getRow() - toCheck.getEndingPos().getRow()) == Constants.LONG_MOVE_LENGTH) {
			
			
			((Pawn)toCheck.getPiece()).setEnPassant(true);
			
		} else {
			
			((Pawn)toCheck.getPiece()).setEnPassant(false);
		}
		
	}
}
