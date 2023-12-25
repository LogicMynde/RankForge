package dev.ericvega.rankforge.command;

import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

public class RemoveSubCommand extends SimpleSubCommand {

    protected RemoveSubCommand(SimpleCommandGroup parent) {
        super(parent, "remove");

        setDescription("Removes a sub-rank from a player");
        setUsage("<Player> <Rank>"); // rank remove <Player> <Rank>
        setMinArguments(2); // rank remove {0} {1}
    }

    @Override
    protected void onCommand() {
        checkConsole();
    }
}
