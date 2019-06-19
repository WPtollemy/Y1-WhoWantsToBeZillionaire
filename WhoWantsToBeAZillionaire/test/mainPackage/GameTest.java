package mainPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	
	Game testGame = new Game();

	@Test
	public void testClearArrays() {
		testGame.initialiseQuestions();
		testGame.clearArrays();
		
		assertEquals(0, testGame.getGenKnow1().size());
	}

	@Test
	public void testAddPlayer() {

		testGame.initialiseQuestions();
		testGame.addPlayer("Will", "General Knowledge");
		testGame.addPlayer("Dave", "Movies");
		
		assertEquals(2, testGame.getPlayers().size());
	}

	@Test
	public void testRemovePlayer() {

		testGame.initialiseQuestions();
		testGame.addPlayer("Will", "General Knowledge");
		testGame.addPlayer("Dave", "Movies");
		testGame.removePlayer("Will");
		
		assertEquals(1, testGame.getPlayers().size());
	}
}
