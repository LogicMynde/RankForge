package dev.ericvega.rankforge.command;

import dev.ericvega.rankforge.command.manager.Rank;
import dev.ericvega.rankforge.command.manager.RankManager;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.List;

public class CreateSubCommand extends SimpleSubCommand {

    protected CreateSubCommand(SimpleCommandGroup parent) {
        super(parent, "create");

        setDescription("Creates a rank");
        setUsage("<ID> <Display Name>"); // rank create <Rank ID> <Rank Display Name>
        setMinArguments(2); // rank create {0} {1}
    }

    /*
        1. Check if the rankID and Rank Display Name already exists
        2. Save the newly created Rank to a Database and Locally via a local file
     */
    @Override
    protected void onCommand() {
        checkConsole();

        RankManager manager = RankManager.getInstance();

        String rankID = args[0];
        String rankDisplayName = Common.colorize(args[1]);

        Rank rank = Rank.valueOf(rankID);
    }

    @Override
    protected List<String> tabComplete() {
        return super.tabComplete();
    }
}
