package io.github.avdaco.serrapiocraft.chunk;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import io.github.avdaco.serrapiocraft.death.DeathController;
import io.github.avdaco.serrapiocraft.death.PlayerDeathInformation;

public class ChunkLoadEventListener implements Listener {

	private ChunkController chunkController;
	private DeathController deathController;
	
	public ChunkLoadEventListener() {
		super();
		this.chunkController = new ChunkController();
		this.deathController = new DeathController();
	}

	@EventHandler
	public void onChunkLoad(ChunkLoadEvent chunkLoadEvent) {
		if (chunkController.someoneDiedOnChunk(chunkLoadEvent.getChunk())) {
			List<PlayerDeathInformation> deathInfoList = chunkController.getDeathInfoFromChunk(chunkLoadEvent.getChunk());
			deathController.resumeDeathTimers(deathInfoList);
			chunkController.whisperLoad(deathInfoList);
		}
	}
	

	
}
