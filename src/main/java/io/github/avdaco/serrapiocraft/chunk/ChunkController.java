package io.github.avdaco.serrapiocraft.chunk;

import java.util.List;

import javax.swing.Timer;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import io.github.avdaco.serrapiocraft.data.MemoryData;
import io.github.avdaco.serrapiocraft.death.PlayerDeathInformation;
import io.github.avdaco.serrapiocraft.utils.LocationUtils;

public class ChunkController {
	
	public Chunk getChunkFromEntity(Entity entity) {
		return entity.getLocation().getChunk();
	}
	
	public boolean someoneDiedOnChunk(Chunk chunk) {
		return MemoryData.someoneDiedOnChunk(LocationUtils.getStaticChunkId(chunk));
	}
	
	public List<PlayerDeathInformation> getDeathInfoFromChunk(Chunk chunk) {
		return MemoryData.getDeathInfoFromChunk(LocationUtils.getStaticChunkId(chunk));
	}
	
	public void whisperLoad(List<PlayerDeathInformation> deathInfoList) {
		deathInfoList.stream().forEach(x -> whisperLoad(x.getPlayerDeathEvent().getEntity(), x.getDeathTimer().getTime()));
	}
	
	public void whisperLoad(Player player, int timeToDeletion) {
		player.sendMessage("Tu chunk de muerte se ha cargado, tiempo restante hasta perder los objetos: " + timeToDeletion + " segundos");
	}
	
	public void whisperUnload(List<PlayerDeathInformation> deathInfoList) {
		deathInfoList.stream().forEach(x -> whisperUnload(x.getPlayerDeathEvent().getEntity(), x.getDeathTimer().getTime()));
	}
	
	public void whisperUnload(Player player, int timeToDeletion) {
		player.sendMessage("Tu chunk de muerte se ha descargado, tiempo restante hasta perder los objetos cuando se cargue: " + timeToDeletion + " segundos");
	}
	
	public void forceChunkLoad(Player player) {
		player.getLocation().getChunk().setForceLoaded(true);
	}
	
	public void unforceChunkLoad(Player player) {
		player.getLocation().getChunk().setForceLoaded(false);
	}
	
}
