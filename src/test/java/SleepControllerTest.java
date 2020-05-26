import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.avdaco.serrapiocraft.sleep.SleepController;

class SleepControllerTest {

	private static SleepController sleepController;
	
	@BeforeAll
	private static void setUp() {
		sleepController = new SleepController();
	}
	
	@Test
	void testEnoughSleepingPlayers() {
		assert(sleepController.isMoreThanSetPercentageSleeping(2, 4));
	}
	
	@Test
	void testEnoughSleepingPlayersEvenTotal() {
		assert(sleepController.isMoreThanSetPercentageSleeping(2, 5));
	}
	
	@Test
	void testNotEnoughSleepingPlayers() {
		assertFalse(sleepController.isMoreThanSetPercentageSleeping(2, 6));
	}

}
