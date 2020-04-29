package it.uniba.game;

/**
* MatchException
* Class type : <<no ECB>>
* Responsibilities :
* 	Knows :
* 		<ul>
* 		</ul>
*	Does : 
*		<ul>
*		<li>Specialization of the class Exception which will only be thrown in the class Match</li>
* 		</ul>
*
* @author LeCun group
*/
class MatchException extends Exception {
	
	// Exception class threw from the class Move
	
	public MatchException(String errorMessage) {
		
		super(errorMessage);
	}
	
}
