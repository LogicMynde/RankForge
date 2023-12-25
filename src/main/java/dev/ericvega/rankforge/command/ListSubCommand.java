package dev.ericvega.rankforge.command;

import dev.ericvega.rankforge.command.manager.RankManager;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

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

        RankManager manager = RankManager.getInstance();
        StringBuilder message = new StringBuilder();

        if (manager.getRankList().size() > 1) {

            for (String rank : manager.getRankList()) {
                message.append(rank).append(", ");
            }
            tellInfo(message.toString());

        } else if (manager.getRankList().isEmpty()) {
            tellError("No ranks available.");
        } else {
            tellInfo(manager.getRankList().toString());
        }
    }
}
