package io.github.avdaco.serrapiocraft.messaging;

import org.bukkit.Bukkit;

public class Broadcaster {

	public static void broadcast(String message) {
		Bukkit.broadcastMessage(message);
	}
	
}
