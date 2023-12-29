package dev.ericvega.rankforge.command.manager;

import dev.ericvega.rankforge.RankForgePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.mineacademy.fo.Common;

public class RankDisplayManager {

    private final RankManager rankManager = RankManager.getInstance();

    private final Scoreboard scoreboard;

    public RankDisplayManager() {
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        scoreboard = (scoreboardManager != null ? scoreboardManager.getNewScoreboard() : Bukkit.getScoreboardManager().getNewScoreboard());
    }

    public void updatePlayerDisplay(Player player) {
        Rank rank = rankManager.getPlayerRank(player.getUniqueId());

        if (rank != null) {
//            String displayName = Common.colorize(rank.getPrefix() + " " + player.getName());
            String displayName = Common.colorize(rank.getInheritColorPrefix() + " " + player.getName() + ChatColor.RESET);

            Bukkit.getScheduler().runTask(RankForgePlugin.getInstance(), () -> setPlayerRank(player, rank.getId()));

            player.setDisplayName(displayName);
            player.setPlayerListName(displayName);
        }
    }

    // Optionally, add methods to handle chat formatting including rank
    public String formatChatMessage() {
        return ("%s: %s");
    }

    public void setPlayerRank(Player player, String rankID) {
        Team team = getTeamForRank(rankID);
        team.addEntry(player.getName());
        player.setScoreboard(scoreboard);
    }

    public Team getTeamForRank(String rankID) {
        Team team = scoreboard.getTeam(rankID);

        if (team == null) {
            team = scoreboard.registerNewTeam(rankID);
//            team.setPrefix(Rank.getFromID(rankID).getPrefix() + " " + ChatColor.RESET);
            team.setPrefix(Rank.getFromID(rankID).getInheritColorPrefix() + " ");
            team.setColor(Rank.getFromID(rankID).getColor());
        }

        return team;
    }

    public Team getTeamForPlayer(Player player) {
        return scoreboard.getTeam(rankManager.getPlayerRank(player).getId());
    }
}
