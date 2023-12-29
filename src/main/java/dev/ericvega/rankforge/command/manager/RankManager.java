package dev.ericvega.rankforge.command.manager;

import dev.ericvega.rankforge.data.PlayerCache;
import org.bukkit.entity.Player;
import org.mineacademy.fo.remain.Remain;

import java.util.*;

public final class RankManager {
    private static RankManager manager;

    private final Map<UUID, Rank> rankMap;

    private final String PRIMARY_RANK_PATH = "primaryRank";

    public RankManager() {
        rankMap = new HashMap<>();
    }

    public void setPlayerRank(UUID uniqueID, Rank rank) {
        rankMap.put(uniqueID, rank);

        Player player = Remain.getPlayerByUUID(uniqueID);
        PlayerCache.from(player).save(PRIMARY_RANK_PATH, rank.getId());
    }

    public void setPlayerRank(Player player, Rank rank) {
        setPlayerRank(player.getUniqueId(), rank);
    }

    public Rank getPlayerRank(UUID uniqueID) {
        Player player = Remain.getPlayerByUUID(uniqueID);

        if (PlayerCache.from(player).get(PRIMARY_RANK_PATH, String.class) != null) {
            return Rank.getFromID(PlayerCache.from(player).get(PRIMARY_RANK_PATH, String.class));
        }

        return rankMap.get(uniqueID);
    }

    public Rank getPlayerRank(Player player) {
        return getPlayerRank(player.getUniqueId());
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
