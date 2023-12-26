package dev.ericvega.rankforge.command.manager;

import org.bukkit.entity.Player;

import java.util.*;

public final class RankManager {
    private static RankManager manager;

    private final Map<UUID, Rank> rankMap;

    public RankManager() {
        rankMap = new HashMap<>();
    }

    public void setPlayerRank(UUID uniqueID, Rank rank) {
        rankMap.put(uniqueID, rank);
    }

    public void setPlayerRank(Player player, Rank rank) {
        rankMap.put(player.getUniqueId(), rank);
    }

    public Rank getPlayerRank(UUID uniqueID) {
        return rankMap.get(uniqueID);
    }

    public Rank getPlayerRank(Player player) {
        return rankMap.get(player.getUniqueId());
    }

    public void clearAll() {
        rankMap.clear();
    }

    /**
     *
     * @return A singleton of this class
     */
    public static RankManager getInstance() {
        if (manager == null)
            manager = new RankManager();

        return manager;
    }
}
