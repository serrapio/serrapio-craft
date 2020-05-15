package data;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import io.github.avdaco.serrapiocraft.death.PlayerDeathInformation;
import utils.LocationUtils;

public class MemoryData {

	public static Map<Integer, PlayerDeathInformation> playerDeathList;
	
	public static void initializeMemoryData() {
		playerDeathList = new HashMap<Integer, PlayerDeathInformation>();
	}
	
	public static void addDeath(PlayerDeathEvent playerDeathEvent) {
		Location deathLocation = LocationUtils.getStaticLocation(playerDeathEvent.getEntity().getLocation());
		PlayerDeathInformation deathInfo = new PlayerDeathInformation(playerDeathEvent, deathLocation);
		playerDeathList.put(playerDeathEvent.getEntity().getEntityId(), deathInfo);
	}
	
	public static Location getDeathLocation(Integer playerId) {
		return playerDeathList.get(playerId).getDeathLocation();
	}
	
	public static Player getPlayer(Integer playerId) {
		return playerDeathList.get(playerId).getPlayerDeathEvent().getEntity();
	}
	
	public static boolean isDeathSaved(Integer entityId) {
		return playerDeathList.containsKey(entityId);
	}
	
}
