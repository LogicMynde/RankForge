package dev.ericvega.rankforge.command;

import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

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
    }
}
