package mainPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testIncreaseScore() {
		Player player = new Player();
		player.increaseScore(100);
		assertEquals(200, player.getCurrentScore());
	}
}
