package dev.ericvega.rankforge.command.manager;

import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;

public class RankDisplayManager {

    private final RankManager rankManager = RankManager.getInstance();

    public void updatePlayerDisplay(Player player) {
        Rank rank = rankManager.getPlayerRank(player.getUniqueId());

        if (rank != null) {
            String displayName = Common.colorize(rank.getDisplayName() + " " + player.getName());

            player.setDisplayName(displayName);
            player.setPlayerListName(displayName);
        }
    }

    // Optionally, add methods to handle chat formatting including rank
    public String formatChatMessage(Player player) {
        Rank rank = rankManager.getPlayerRank(player.getUniqueId());

        return (rank != null ? Common.colorize(rank.getDisplayName() + " %s: %s") : "%s: %s");
    }
}
