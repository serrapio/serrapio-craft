package io.github.avdaco.serrapiocraft;
import org.bukkit.plugin.java.JavaPlugin;

import data.MemoryData;
import io.github.avdaco.serrapiocraft.death.DeathCommand;
import io.github.avdaco.serrapiocraft.death.DeathEventListener;

/**
 * Entry point for the template plugin. You should edit
 * this comment by explaining the main purpose of your
 * plugin
 *
 * You should also edit these tags below.
 *
 * @author avdaco
 * @version 1.0
 * @since 1.0
 */
public class SerrapioCraft extends JavaPlugin {
	
    @Override
    public void onEnable() {
    	MemoryData.initializeMemoryData();
    	this.loadListeners();
    	this.loadCommands();
    }

    @Override
    public void onDisable() {
        
    }
    
    private void loadListeners() {
    	this.getServer().getPluginManager().registerEvents(new DeathEventListener(), this);
    }
    
    private void loadCommands() {
    	this.getCommand("tumba").setExecutor(new DeathCommand());
    }

}