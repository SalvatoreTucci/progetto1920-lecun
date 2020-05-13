package it.uniba.game;

/**
* MatchException <br>
* Class type : no ECB <br>
* Responsibilities : <br>
* 	Knows : <br>
* 		<ul>
* 		</ul>
*	Does : <br>
*		<ul>
*		<li>Specialization of the class Exception which will only be thrown in the class Match</li>
* 		</ul>
*
* @author LeCun group <br>
*/
class MatchException extends Exception {
	
	// Exception class threw from the class Move <br>
	
	public MatchException(String errorMessage) {
		
		super(errorMessage);
	}
	
}
