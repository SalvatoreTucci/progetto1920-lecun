package it.uniba.game;

class MatchException extends Exception{
	
	// Exception class called from the class Move
	
	public MatchException(String errorMessage) {
		super(errorMessage);
	}
	
}
