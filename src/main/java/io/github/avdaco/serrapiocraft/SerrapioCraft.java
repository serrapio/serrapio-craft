package io.github.avdaco.serrapiocraft;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.avdaco.serrapiocraft.chunk.ChunkLoadEventListener;
import io.github.avdaco.serrapiocraft.chunk.ChunkUnloadEventListener;
import io.github.avdaco.serrapiocraft.data.MemoryData;
import io.github.avdaco.serrapiocraft.death.DeathCommand;
import io.github.avdaco.serrapiocraft.death.DeathEventListener;
import io.github.avdaco.serrapiocraft.respawn.PlayerRespawnEventListener;
import io.github.avdaco.serrapiocraft.sleep.PlayerBedEnterEventListener;

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
	
	private static SerrapioCraft instance;
	
    @Override
    public void onEnable() {
    	instance = this;
    	MemoryData.initializeMemoryData();
    	this.loadListeners();
    	this.loadCommands();
    }

    @Override
    public void onDisable() {
        
    }
    
    private void loadListeners() {
    	this.getServer().getPluginManager().registerEvents(new DeathEventListener(), this);
    	this.getServer().getPluginManager().registerEvents(new ChunkLoadEventListener(), this);
    	this.getServer().getPluginManager().registerEvents(new ChunkUnloadEventListener(), this);
    	this.getServer().getPluginManager().registerEvents(new PlayerRespawnEventListener(), this);
    	this.getServer().getPluginManager().registerEvents(new PlayerBedEnterEventListener(), this);
    }
    
    private void loadCommands() {
    	this.getCommand("tumba").setExecutor(new DeathCommand());
    }
    
    public static SerrapioCraft getPlugin() {
    	return instance;
    }
}