package io.github.avdaco.serrapiocraft.messaging;

import org.bukkit.entity.Player;

public class Whisperer {

	public static void whisper(Player player, String message) {
		player.sendMessage(message);
	}
	
}
