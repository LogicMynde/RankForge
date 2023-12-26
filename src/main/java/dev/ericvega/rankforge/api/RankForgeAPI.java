package dev.ericvega.rankforge.api;

import org.bukkit.entity.Player;
import dev.ericvega.rankforge.data.PlayerCache;
import dev.ericvega.rankforge.RankForgePlugin;

/**
 * A sample API class you can build on to use for your plugin.
 */
public final class RankForgeAPI {

	/**
	 * Return the main instance of this plugin
	 *
	 * @return
	 */
	public static RankForgePlugin getAPI() {
		return RankForgePlugin.getInstance();
	}

	/**
	 * Get the player cache. Creates the cache if it does not exist.
	 *
	 * Please use with caution since we do create this cache on PlayerJoinEvent
	 * when the player joins automatically.
	 *
	 * @param player
	 * @return
	 */
	public static PlayerCache getPlayerCache(Player player) {
		return PlayerCache.from(player);
	}
}
