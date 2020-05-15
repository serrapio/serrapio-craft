package io.github.avdaco.serrapiocraft.death;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import broadcast.Broadcaster;
import data.MemoryData;

public class DeathController {
	
	public void broadcastDeath(Integer entityId) {
		Player player = MemoryData.getPlayer(entityId);
		Broadcaster.broadcast(getDeathMessage(player));
	}
	
	public void whisperDeath(Integer entityId) {
		Player player = MemoryData.getPlayer(entityId);
		player.sendMessage(getDeathMessage(player));
	}
	
	public void saveDeathData(PlayerDeathEvent playerDeath) {
		MemoryData.addDeath(playerDeath);
	}
	
	public boolean isDeathSaved(Integer entityId) {
		return MemoryData.isDeathSaved(entityId);
	}
	
	public String getDeathMessage(Entity entity) {
		Location deathLocation = MemoryData.getDeathLocation(entity.getEntityId());
		return ("Coordenadas de muerte de " + entity.getName() + ": "
				+ ("x = " + deathLocation.getBlockX())
				+ (", y = " + deathLocation.getBlockY())
				+ (", z = " + deathLocation.getBlockZ()));
	}
	
}
