package io.github.avdaco.serrapiocraft.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import io.github.avdaco.serrapiocraft.chunk.ChunkId;
import io.github.avdaco.serrapiocraft.death.PlayerDeathInformation;
import io.github.avdaco.serrapiocraft.utils.LocationUtils;

public class MemoryData {

	public static Map<Integer, PlayerDeathInformation> playerDeathList;
	public static Map<ChunkId, List<PlayerDeathInformation>> deathChunkList;
	
	public static void initializeMemoryData() {
		playerDeathList = new HashMap<Integer, PlayerDeathInformation>();
		deathChunkList = new HashMap<ChunkId, List<PlayerDeathInformation>>();
	}
	
	public static void addDeath(PlayerDeathEvent playerDeathEvent) {
		Location deathLocation = LocationUtils.getStaticLocation(playerDeathEvent.getEntity().getLocation());
		ChunkId deathChunkId = LocationUtils.getStaticChunkId(playerDeathEvent.getEntity().getLocation().getChunk());
		PlayerDeathInformation deathInfo = new PlayerDeathInformation(playerDeathEvent, deathLocation, deathChunkId);
		playerDeathList.put(playerDeathEvent.getEntity().getEntityId(), deathInfo);
		addPlayerToDeathChunkList(deathChunkId, deathInfo);
	}
	
	public static Location getDeathLocation(Integer playerId) {
		return playerDeathList.get(playerId).getLocation();
	}
	
	public static Player getPlayer(Integer playerId) {
		return playerDeathList.get(playerId).getPlayerDeathEvent().getEntity();
	}
	
	public static boolean isDeathSaved(Integer entityId) {
		return playerDeathList.containsKey(entityId);
	}
	
	public static boolean someoneDiedOnChunk(ChunkId chunkId) {
		return deathChunkList.containsKey(chunkId);
	}
	
	public static void addPlayerToDeathChunkList(ChunkId chunkId, PlayerDeathInformation deathInfo) {
		if (!deathChunkList.containsKey(chunkId)) {
			List<PlayerDeathInformation> listDeadPlayers = new ArrayList<PlayerDeathInformation>();
			deathChunkList.put(chunkId, listDeadPlayers);
		}
		deathChunkList.get(chunkId).add(deathInfo);
	}
	
	public static List<PlayerDeathInformation> getDeathInfoFromChunk(ChunkId chunkId) {
		return deathChunkList.get(chunkId).stream().filter(x -> !x.getDeathTimer().isFinished()).collect(Collectors.toList());
	}
	
	public static int getDeathTimer(Integer playerId) {
		return playerDeathList.get(playerId).getDeathTimer().getTime();
	}
	
	public static boolean isDeathTimerRunning(Integer playerId) {
		return !playerDeathList.get(playerId).getDeathTimer().isStopped();
	}
	
}
