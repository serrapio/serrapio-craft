package io.github.avdaco.serrapiocraft.death;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import io.github.avdaco.serrapiocraft.chunk.ChunkController;

public class DeathEventListener implements Listener {
	
	private DeathController deathController;
	private ChunkController chunkController;
	
	public DeathEventListener() {
		super();
		this.deathController = new DeathController();
		this.chunkController = new ChunkController();
	}

	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent playerDeath) {
		Player player = playerDeath.getEntity();
		chunkController.forceChunkLoad(player);
		deathController.saveDeathData(playerDeath);
		deathController.broadcastDeath(player.getEntityId());
	}
	
	
	
}
