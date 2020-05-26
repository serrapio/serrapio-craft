package io.github.avdaco.serrapiocraft.respawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import io.github.avdaco.serrapiocraft.chunk.ChunkController;

public class PlayerRespawnEventListener implements Listener {

	private ChunkController chunkController;
	
	public PlayerRespawnEventListener() {
		super();
		this.chunkController = new ChunkController();
	}

	@EventHandler
	public void onPlayerRespawnEvent(PlayerRespawnEvent playerRespawn) {
		this.chunkController.unforceChunkLoad(playerRespawn.getPlayer());
	}
	
}
