package io.github.avdaco.serrapiocraft.death;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEventListener implements Listener {
	
	private DeathController deathController;
	
	public DeathEventListener() {
		super();
		this.deathController = new DeathController();
	}

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent playerDeath) {
		Player player = playerDeath.getEntity();
		deathController.saveDeathData(playerDeath);
		deathController.broadcastDeath(player.getEntityId());
	}
	
	
	
}
