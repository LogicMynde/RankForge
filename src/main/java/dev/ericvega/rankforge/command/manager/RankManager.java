package dev.ericvega.rankforge.command.manager;

import dev.ericvega.rankforge.data.PlayerCache;
import org.bukkit.entity.Player;
import org.mineacademy.fo.remain.Remain;

import java.util.*;

public final class RankManager {
    private static RankManager manager;

    private final Map<UUID, Rank> rankMap;

    private final String PRIMARY_RANK_PATH = "primaryRank";
    private final String SUB_RANK_PATH = "subRank";

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

//    public void setPlayerSubRank(UUID uniqueID, Rank rank) {
//        Player player = Remain.getPlayerByUUID(uniqueID);
//        PlayerCache.from(player).save(SUB_RANK_PATH, rank.getId());
//    }
//
//    public void setPlayerSubRank(Player player, Rank rank) {
//        setPlayerRank(player.getUniqueId(), rank);
//    }

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

    public void addSubRank(Player player, Rank subRank) {
        // Retrieve the current saved sub-ranks
        String savedSubRanks = PlayerCache.from(player).get(SUB_RANK_PATH, String.class);
        StringJoiner joiner = new StringJoiner(",");

        if (savedSubRanks != null && !savedSubRanks.isEmpty()) {
            joiner.add(savedSubRanks); // Add existing sub-ranks if any
        }

        // check if the player already has the sub-rank
        if (savedSubRanks != null && savedSubRanks.contains(subRank.getId())) return;

        // Add the new sub-rank ID
        joiner.add(subRank.getId());

        // Save the updated string to PlayerCache
        PlayerCache.from(player).save(SUB_RANK_PATH, joiner.toString());
    }


    public List<Rank> getSubRanks(Player player) {
        List<Rank> subRanks = new ArrayList<>();

        // Retrieve the concatenated rank IDs from PlayerCache
        String savedRanks = PlayerCache.from(player).get(SUB_RANK_PATH, String.class);
        if (savedRanks == null || savedRanks.isEmpty()) {
            return subRanks; // Return an empty list if nothing is saved
        }

        // Split the string by the delimiter and convert each ID to a Rank
        String[] rankIds = savedRanks.split(",");
        for (String id : rankIds) {
            Rank rank = Rank.getFromID(id);
            if (rank != Rank.DEFAULT) { // Assuming 'DEFAULT' means an unrecognized ID
                subRanks.add(rank);
            }
        }

        return subRanks;
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
