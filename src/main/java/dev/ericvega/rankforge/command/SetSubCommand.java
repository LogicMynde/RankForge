package dev.ericvega.rankforge.command;

import dev.ericvega.rankforge.RankForgePlugin;
import dev.ericvega.rankforge.command.manager.Rank;
import dev.ericvega.rankforge.command.manager.RankManager;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public class SetSubCommand extends SimpleSubCommand {

    protected SetSubCommand(SimpleCommandGroup parent) {
        super(parent, "set");

        setDescription("Sets the player's primary rank");
        setUsage("<Player> <Rank>"); // rank set <Player> <Rank>
        setMinArguments(2); // rank set {0} {1}
    }

    /**
     * In the future check if the player has a primary rank already, if YES replace it, if NO give them one
     */
    @Override
    protected void onCommand() {
        checkConsole();

        RankManager manager = RankManager.getInstance();

        Player target = findPlayer(args[0], "Unable to locate &l{0}!");
        String rankID = args[1];

        if (Rank.contains(rankID)) {
            manager.setPlayerRank(target, Rank.getFromID(rankID));
            RankForgePlugin.getInstance().getRankDisplayManager().updatePlayerDisplay(target);

            tell("Successfully set primary rank of '{0}' to '{1}'");
            Common.tell(target, "Primary rank set to " + Rank.getFromID(rankID).getPrefix());
        } else {
            tellError("'{1}' rank does not exist!");
        }
    }

    @Override
    protected List<String> tabComplete() {
        return super.tabComplete();
    }
}
