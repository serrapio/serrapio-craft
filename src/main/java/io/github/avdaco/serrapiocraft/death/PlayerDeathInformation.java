package io.github.avdaco.serrapiocraft.death;

import org.bukkit.Location;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathInformation {

	private PlayerDeathEvent playerDeathEvent;
	private Location deathLocation;
	
	public PlayerDeathInformation(PlayerDeathEvent playerDeathEvent, Location deathLocation) {
		super();
		this.playerDeathEvent = playerDeathEvent;
		this.deathLocation = deathLocation;
	}

	public PlayerDeathEvent getPlayerDeathEvent() {
		return playerDeathEvent;
	}

	public void setPlayerDeathEvent(PlayerDeathEvent playerDeathEvent) {
		this.playerDeathEvent = playerDeathEvent;
	}

	public Location getDeathLocation() {
		return deathLocation;
	}

	public void setDeathLocation(Location deathLocation) {
		this.deathLocation = deathLocation;
	}
	
}
