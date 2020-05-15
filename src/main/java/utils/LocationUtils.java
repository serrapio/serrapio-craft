package utils;

import org.bukkit.Location;

public class LocationUtils {

	public static Location getStaticLocation(Location location) {
		return new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
	}
	
}
