package dev.ericvega.rankforge.command.manager;

import lombok.Getter;

import java.util.*;

public final class RankManager {

    private final Map<UUID, Rank> playerRanks;

    @Getter
    private final List<String> rankList;
    private static RankManager manager;

    public RankManager() {
        playerRanks = new HashMap<>();
        rankList = new ArrayList<>();
    }

    public void setPlayerRank(UUID uniqueID, Rank rank) {
        playerRanks.put(uniqueID, rank);
    }

    public Rank getPlayerRank(UUID uniqueID) {
        return playerRanks.getOrDefault(uniqueID, null);
    }

    public void removePlayerRank(UUID uniqueID) {
        playerRanks.remove(uniqueID);
    }

    /**
     * Returns a Map of players with the specified Rank
     */
    public Map<UUID, Rank> getPlayersWithRank(Rank rank) {
        Map<UUID, Rank> playersWithRank = new HashMap<>();

        for (Map.Entry<UUID, Rank> entry : playerRanks.entrySet()) {
            if (entry.getValue().equals(rank)) {
                playersWithRank.put(entry.getKey(), rank);
            }
        }

        return playersWithRank;
    }

    public void resetAllRanks() {
        playerRanks.clear();
    }

    public Rank getRankById(String id) {
        // Check if the provided ID is in the rankList
        if (!rankList.contains(id)) {
            return null;
        }

        // Search for the Rank object with the matching ID in playerRanks
        for (Rank rank : playerRanks.values()) {
            if (rank.getId().equals(id)) {
                return rank;
            }
        }

        // Return null if no matching Rank is found
        return null;
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
