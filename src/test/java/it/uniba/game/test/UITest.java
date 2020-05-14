package it.uniba.game.test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import it.uniba.game.UI;

public class UITest {
	
	@Test
	public void getStatusTest() {
		UI toTest = UI.getUI();
		assertFalse(toTest.getStatus());
	}
	
	//It's not possibile to check the True status when we want to 
	//quit the game, because the UI directly uses the stream to 
	//ask the player
	
	//It's not possible to check if parseCommand printed the right
	//messages
	
	//Even printWelcome cannot be tested because it just print 
	//a message
	
	
}
