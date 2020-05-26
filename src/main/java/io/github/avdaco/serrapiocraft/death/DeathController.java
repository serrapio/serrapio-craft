package io.github.avdaco.serrapiocraft.death;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import io.github.avdaco.serrapiocraft.data.MemoryData;
import io.github.avdaco.serrapiocraft.messaging.Broadcaster;

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
				+ (", z = " + deathLocation.getBlockZ())
				+ (". Tiempo restante hasta desaparecer: " + MemoryData.getDeathTimer(entity.getEntityId()))
				+ (". Chunk: " + (MemoryData.isDeathTimerRunning(entity.getEntityId()) ? "CARGADA" : "DESCARGADA")));
	}
	
	public void resumeDeathTimers(List<PlayerDeathInformation> deathInfoList) {
		deathInfoList.stream().filter(x -> x.getDeathTimer().isStopped()).forEach(x -> x.getDeathTimer().startTimer());
	}
	
	public void stopDeathTimers(List<PlayerDeathInformation> deathInfoList) {
		deathInfoList.stream().filter(x -> !x.getDeathTimer().isStopped() && !x.getDeathTimer().isFinished()).forEach(x -> x.getDeathTimer().stopTimer());
	}
	
}
