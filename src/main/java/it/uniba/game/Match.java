package it.uniba.game;
import it.uniba.game.pieces.*;
import it.uniba.game.board.ChessBoard;
import java.util.Vector;


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
		
	}
	
	public void inputMove(String toParse) {
/*
		Move parsedMove = parseMove(toParse);
		findToMove(parsedMove);
		
		if(parsedMove.getCaptureFlag()){
			insertCapture(parsedMove);
		}
		
		field.setMove(parsedMove);
		
		moves.add(toParse);
*/
	}
	
	void insertCapture(Move captureMove) {
/*		
		Coordinates endingSquare = captureMove.getEndingPos();
		Piece capturedPiece = field.getPiece(endingSquare);
		
		if(capturedPiece.getColor() == Piece.Color.BLACK){
			whiteCaptured.add(capturedPiece);
		}
		else{
			blackCaptured.add(capturedPiece);
		}
*/	
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
	
	public String getPrintableChessboard() {
		
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

	/*
	private Move parseMove(String toParse) {
	

	}
	*/
	
	private void findToMove(Move toMove) {
		
		Vector<Coordinates> possibleSquares = toMove.getPiece().reverseMove(toMove);
		
		
		//checking if there are possible pieces to move in the vector possibleSquares
		int i = 0;
		while (i < possibleSquares.size()) {
			
			if (field.getSquare( possibleSquares.get(i) ).getPiece().equal(toMove.getPiece())) {
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
				
				//exception-----------------------------------------------------------------
			}
			
			toMove.setStartingPos(possibleSquares.firstElement());
			
			
		}

	}

	//specific method wich handles the situation where the move is a capture
	private void findToMoveCapture(Move toMove, Vector<Coordinates> possibleSquares) {
		

		//handleEnPassant(toMove, possibleSquares);
		//if () {
			
			//handleEnPassant(toMove, possibleSquares);
			
		//}
		
		
		if( field.getSquare(toMove.getEndingPos()).isOccupied() && (field.getSquare(toMove.getEndingPos()).getPiece().getColor() != toMove.getPiece().getColor()) ) {
			
			
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
			
			addC = Constants.UP_DIRECTION;
			
		} else {
			
			addC = Constants.DOWN_DIRECTION;
		}
		
		for (int i = startingPos.getRow() + addR, j = startingPos.getColumn() + addC;
				i != endingPos.getRow() || j != endingPos.getColumn();
				i += addR, j += addC ) {
			
			if (field.getSquare(new Coordinates(i, j)).isOccupied()) {
				
				return true;
			}
		}
		return false;
	}
	
	private void solveAmbiguousMoves(Vector<Coordinates> possibleSquares, Move toMove) {
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
		}
		
		//if there's still more than one alternative raise an exception
		if (possibleSquares.size() > 1) {
			
			//exception-----------------------------------------------------------------
		}
		
	}
	
	private void handlePawn(Move toMove, Vector<Coordinates> possibleSquares) {
		
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
					
					toMove.setStartingPos(possibleSquares.firstElement());
					
				}
			}
			
		} else if (( field.getSquare(toMove.getEndingPos()).getPiece().getColor() != toMove.getPiece().getColor() )) {
			
			if (possibleSquares.size() > 1) {
				
				solveAmbiguousMoves(possibleSquares, toMove);
			}
			toMove.setStartingPos(possibleSquares.firstElement());
		}
	}
}
