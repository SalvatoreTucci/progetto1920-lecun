package it.uniba.game;

/**
* Exception raised from the class Match in case of game errors <br>
* Class type : &#60; no ECB &#62; <br><br>
*
* Responsibilities : <br>
*
* 	Knows : <br>
*	Does : <br>
*
* @author LeCun group
*/



@SuppressWarnings("serial")
public class MatchException extends Exception {

	/**
	 * Constructor for the class MatchException.
	 * 
	 * @param errorMessage Message explaining why the exception has been raised.
	 */
	public MatchException(final String errorMessage) {

		super(errorMessage);
	}
}
