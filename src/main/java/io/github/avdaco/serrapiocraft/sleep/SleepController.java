package io.github.avdaco.serrapiocraft.sleep;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class SleepController {
	
	private static final float MINIMUM_SLEEPING_PLAYERS_PERCENTAGE = 0.49f;

	public boolean enoughSleepingPlayers() {
		int onlinePlayers = Bukkit.getOnlinePlayers().size();
		return isMoreThanSetPercentageSleeping(getNumberSleepers() + 1, onlinePlayers);
	}
	
	public Integer getNumberSleepers() {
		return Math.toIntExact(Bukkit.getOnlinePlayers().stream().filter(x -> x.isSleeping()).count());
	}
	
	public void sleep(PlayerBedEnterEvent playerBedEnter) {
		World currentWorld = playerBedEnter.getBed().getWorld();
		currentWorld.setTime(0);
	}
	
	public boolean isMoreThanSetPercentageSleeping(int sleepingPlayers, int onlinePlayers) {
		int flooredSleepingPlayers = onlinePlayers % 2 == 1 ? sleepingPlayers + 1 : sleepingPlayers;
		return ((float) flooredSleepingPlayers / (float) onlinePlayers) >= MINIMUM_SLEEPING_PLAYERS_PERCENTAGE;
	}
	
}
