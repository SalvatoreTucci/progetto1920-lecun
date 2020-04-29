/**
* MatchException
* Class type : <<no ECB>>
* Responsibilities :
* 	Knows :
* 		<ul>
* 		</ul>
*	Does : 
*		<ul>
*		<li>Instances a possible exception to be used in the class Match </li>
* 		</ul>
*
* @author LeCun group
*/

package it.uniba.game;



class MatchException extends Exception {
	
	// Exception class threw from the class Move
	
	public MatchException(String errorMessage) {
		
		super(errorMessage);
	}
	
}
