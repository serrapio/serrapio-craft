package io.github.avdaco.serrapiocraft.death;

import org.bukkit.Location;
import org.bukkit.event.entity.PlayerDeathEvent;

import io.github.avdaco.serrapiocraft.chunk.ChunkId;
import io.github.avdaco.serrapiocraft.timer.DeathTimer;

public class PlayerDeathInformation {

	private PlayerDeathEvent playerDeathEvent;
	private Location location;
	private ChunkId chunkId;
	private DeathTimer deathTimer;
	
	public PlayerDeathInformation(PlayerDeathEvent playerDeathEvent, Location location, ChunkId chunkId) {
		super();
		this.playerDeathEvent = playerDeathEvent;
		this.location = location;
		this.chunkId = chunkId;
		this.deathTimer = new DeathTimer(playerDeathEvent.getEntity());
	}

	public PlayerDeathEvent getPlayerDeathEvent() {
		return playerDeathEvent;
	}

	public void setPlayerDeathEvent(PlayerDeathEvent playerDeathEvent) {
		this.playerDeathEvent = playerDeathEvent;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ChunkId getChunkId() {
		return chunkId;
	}

	public void setChunkId(ChunkId chunkId) {
		this.chunkId = chunkId;
	}

	public DeathTimer getDeathTimer() {
		return deathTimer;
	}

	public void setDeathTimer(DeathTimer deathTimer) {
		this.deathTimer = deathTimer;
	}
	
}
