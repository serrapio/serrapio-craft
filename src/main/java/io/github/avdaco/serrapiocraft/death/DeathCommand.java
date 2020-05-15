package io.github.avdaco.serrapiocraft.death;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathCommand implements CommandExecutor {
	
	DeathController deathController;
	
	public DeathCommand() {
		super();
		this.deathController = new DeathController();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			if (deathController.isDeathSaved(((Player) sender).getEntityId())) {
				deathController.whisperDeath(((Player) sender).getEntityId());
			} else {
				sender.sendMessage(sender.getName() + " no tiene muertes guardadas (se resetean al reiniciar el servidor)");
			}
		}
		return true;
	}
	
}
