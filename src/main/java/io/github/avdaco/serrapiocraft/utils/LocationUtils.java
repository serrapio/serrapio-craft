package io.github.avdaco.serrapiocraft.utils;

import org.bukkit.Chunk;
import org.bukkit.Location;

import io.github.avdaco.serrapiocraft.chunk.ChunkId;

public class LocationUtils {

	public static Location getStaticLocation(Location location) {
		return new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
	}
	
	public static ChunkId getStaticChunkId(Chunk chunk) {
		return new ChunkId(chunk.getX(), chunk.getZ());
	}
	
}
