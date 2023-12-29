package dev.ericvega.rankforge.command;

import dev.ericvega.rankforge.command.manager.Rank;
import dev.ericvega.rankforge.command.manager.RankManager;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Messenger;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public class InfoSubCommand extends SimpleSubCommand {

    protected InfoSubCommand(SimpleCommandGroup parent) {
        super(parent, "info");

        setDescription("Displays a player's rank information");
        /*
            Usage: rank info <Player>

            Output:
                Rank Information of <Player>:
                Primary: admin
                Additional (number of additional ranks): names of additional ranks
         */
        setUsage("<Player>");
        setMinArguments(1); // rank info {0}
    }

    @Override
    protected void onCommand() {
        checkConsole();

        RankManager manager = RankManager.getInstance();

        Player target = findPlayer(args[0], "Unable to locate {0}!");

        if (manager.getPlayerRank(target) != null) { // player has a rank && player has been saved in DB
            manager.getSubRanks(target);

            List<Rank> subRanks = manager.getSubRanks(target);

            // Transform List<Rank> to List<String> containing rank id's
            List<String> subRankIDs = subRanks.stream()
                    .map(Rank::getId)
                    .toList();

            String[] output = {
                    Messenger.getInfoPrefix() + " &7Rank Information of {0}:",
                    "&9Primary: &7" + manager.getPlayerRank(target).getName(),
                    "&9Additional (" + subRankIDs.size() + "): " + subRankIDs
            };

            tell(output);
        }
    }
}
