package io.github.avdaco.serrapiocraft.chunk;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

import io.github.avdaco.serrapiocraft.death.DeathController;
import io.github.avdaco.serrapiocraft.death.PlayerDeathInformation;

public class ChunkUnloadEventListener implements Listener {
	
	private ChunkController chunkController;
	private DeathController deathController;
	
	public ChunkUnloadEventListener() {
		super();
		this.chunkController = new ChunkController();
		this.deathController = new DeathController();
	}

	@EventHandler
	public void onChunkUnload(ChunkUnloadEvent chunkUnloadEvent) {
		if (chunkController.someoneDiedOnChunk(chunkUnloadEvent.getChunk())) {
			List<PlayerDeathInformation> deathInfoList = chunkController.getDeathInfoFromChunk(chunkUnloadEvent.getChunk());
			deathController.stopDeathTimers(deathInfoList);
			chunkController.whisperUnload(deathInfoList);
		}
	}
	
}
