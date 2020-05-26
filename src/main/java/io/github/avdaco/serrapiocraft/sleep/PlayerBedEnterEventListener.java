package io.github.avdaco.serrapiocraft.sleep;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;

public class PlayerBedEnterEventListener implements Listener {
	
	private SleepController sleepController;
	
	public PlayerBedEnterEventListener() {
		this.sleepController = new SleepController();
	}

	@EventHandler
	public void onPlayerBedEnterEvent(PlayerBedEnterEvent playerBedEnter) {
		if (playerCanSleep(playerBedEnter) && this.sleepController.enoughSleepingPlayers()) {
			this.sleepController.sleep(playerBedEnter);
		}
	}
	
	private boolean playerCanSleep(PlayerBedEnterEvent playerBedEnter) {
		return playerBedEnter.getBedEnterResult() == BedEnterResult.OK;
	}
	
}
