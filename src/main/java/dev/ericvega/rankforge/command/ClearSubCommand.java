package dev.ericvega.rankforge.command;

import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

public class ClearSubCommand extends SimpleSubCommand {

    protected ClearSubCommand(SimpleCommandGroup parent) {
        super(parent, "clear");

        setDescription("Resets a player's ranks to default");
        setUsage("<Player>"); // rank clear <Player>
        setMinArguments(1);
    }

    @Override
    protected void onCommand() {
        checkConsole();
    }
}
