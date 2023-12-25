package dev.ericvega.rankforge.command;

import dev.ericvega.rankforge.command.manager.RankDisplayManager;
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

    @Override
    protected void onCommand() {
        checkConsole();

        RankManager manager = RankManager.getInstance();
        RankDisplayManager displayManager = new RankDisplayManager();

        Player target = findPlayer(args[0], "Unable to locate &l{0}!");
        String rankID = args[1];

        if (manager.getRankList().contains(rankID)) {
            manager.setPlayerRank(target.getUniqueId(), manager.getRankById(rankID));
            displayManager.updatePlayerDisplay(target);

            tellSuccess("Successfully set '{0}' with the primary rank of '{1}'");
            Common.tell(target, "Your primary rank has been set to &a" + rankID);
        } else {
            tellError("'{1}' rank does not exist!");
        }
    }

    @Override
    protected List<String> tabComplete() {
        return super.tabComplete();
    }
}
