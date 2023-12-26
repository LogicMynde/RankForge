package dev.ericvega.rankforge.command;

import dev.ericvega.rankforge.command.manager.Rank;
import dev.ericvega.rankforge.command.manager.RankManager;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.Arrays;

public class ListSubCommand extends SimpleSubCommand {

    protected ListSubCommand(SimpleCommandGroup parent) {
        super(parent, "list");

        setDescription("Lists all existing ranks");
        setUsage("");
        setMinArguments(0);
    }

    @Override
    protected void onCommand() {
        checkConsole();

        Rank[] rank = Rank.values();

        Common.tell(getPlayer(), Arrays.toString(rank));
    }
}
